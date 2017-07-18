package org.huangpu.mydog.plugins.ormapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import org.huangpu.mydog.core.Preserver;
import org.huangpu.mydog.core.plugins.GenerateContext;
import org.huangpu.mydog.core.utils.DDLUtils;
import org.huangpu.mydog.core.utils.FileUtil;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.*;


/**
 * Created by zss
 */
public class MyBatisPreserver implements Preserver<MyBatisOutputItem> {

    private static final Logger LOG = LoggerFactory.getLogger(MyBatisPreserver.class);

    private MyBatisGeneratorConfig generatorConfig;

    private ProgressCallback progressCallback;

    private List<IgnoredColumn> ignoredColumns;

//    private List<ColumnOverride> columnOverrides;

    private List<String> pluginList = new ArrayList<>();

    public MyBatisPreserver() {
        init();
    }

    private void init() {
        Configuration config = new Configuration();
        Context context = new Context(ModelType.CONDITIONAL);
        config.addContext(context);
    }

    public void setMyBatisGeneratorConfig(MyBatisGeneratorConfig generatorConfig) {
        this.generatorConfig = generatorConfig;
    }

    public void addPlugin(String plugin) {
        if (!Strings.isNullOrEmpty(plugin)) {
            pluginList.add(plugin);
        }
    }

    // 使用generator生成文件前先删除旧文件：解决mybatis 生成xml文件内容重复问题，
    public void clearMybatisGenFiles(){

        String targetProject = generatorConfig.getTargetProject();
        String clientPackage = generatorConfig.getClientGeneratorTargetPackage();
        String modelPackage = generatorConfig.getModelGeneratorTargetPackage();

        String clientPath = clientPackage.replace(".", File.separator);
        String modelPath = modelPackage.replace(".", File.separator);

        FileUtil.delAllFile(targetProject+clientPath,false);
        FileUtil.delAllFile(targetProject+modelPath,false);

    }

    public void generate() throws Exception {

        clearMybatisGenFiles();

        Configuration config = new Configuration();
        String connectorLibPath = generatorConfig.getConnectorJarFilePath();

        LOG.debug("connectorLibPath: {}", connectorLibPath);
        config.addClasspathEntry(connectorLibPath);
        Context context = new Context(ModelType.CONDITIONAL);
        config.addContext(context);

        Map<String,Map<String,JSONObject>> propMap = GenerateContext.get("props");
        Map<String, JSONObject> entityMap = propMap.get("entity");

        entityMap.entrySet().stream().forEach(ent ->{
            JSONObject entProp = ent.getValue();
            String domainName = entProp.getString("entityName");
            // Table config
            TableConfiguration tableConfig = new TableConfiguration(context);
            tableConfig.setTableName(DDLUtils.getTbName(domainName));
            tableConfig.setDomainObjectName(domainName);

//            tableConfig.setSelectByPrimaryKeyStatementEnabled(false);
//            tableConfig.setSelectByExampleStatementEnabled(false);
//            tableConfig.setUpdateByExampleStatementEnabled(false);
//            tableConfig.setUpdateByPrimaryKeyStatementEnabled(false);

            // add ignore columns
            if (ignoredColumns != null) {
                ignoredColumns.stream().forEach(ignoredColumn -> {
                    tableConfig.addIgnoredColumn(ignoredColumn);
                });
            }

            /** 支持 Validation 框架 **/
            //1 将Validation 字段写入 columnOverrides

            JSONArray fields = entProp.getJSONArray("fields");

            fields.stream().forEach(obj ->{
                JSONObject field = (JSONObject)obj;
                ColumnOverride col = new ColumnOverride(field.getString("fieldName"));
                col.addProperty("null",field.getString("isNull"));
                col.addProperty("length",field.getString("length"));
                col.addProperty("type", field.getString("fieldType"));
                JSONArray validates = field.getJSONArray("validates");
                if(validates != null) {
                    col.addProperty("validates", field.getJSONArray("validates").toJSONString());
                }
                col.addProperty("isId",field.getString("isId"));
                tableConfig.addColumnOverride(col);
            });
            context.addTableConfiguration(tableConfig);

        });



        context.setId("myid");

        // JDBC Config
        JDBCConnectionConfiguration jdbcConfig = new JDBCConnectionConfiguration();
        jdbcConfig.setDriverClass(generatorConfig.getDriverClass());
        jdbcConfig.setConnectionURL(generatorConfig.getConnectionURL());
        jdbcConfig.setUserId(generatorConfig.getUserName());
        jdbcConfig.setPassword(generatorConfig.getPassWord());
        context.setJdbcConnectionConfiguration(jdbcConfig);

        // java model
        JavaModelGeneratorConfiguration modelConfig = new JavaModelGeneratorConfiguration();
        modelConfig.setTargetPackage(generatorConfig.getModelGeneratorTargetPackage());
        modelConfig.setTargetProject(generatorConfig.getTargetProject());
        context.setJavaModelGeneratorConfiguration(modelConfig);

        // Mapper config
        SqlMapGeneratorConfiguration mapperConfig = new SqlMapGeneratorConfiguration();
        mapperConfig.setTargetPackage(generatorConfig.getClientGeneratorTargetPackage());
        mapperConfig.setTargetProject(generatorConfig.getTargetProject());
        context.setSqlMapGeneratorConfiguration(mapperConfig);

        // DAO
        JavaClientGeneratorConfiguration daoConfig = new JavaClientGeneratorConfiguration();
        daoConfig.setConfigurationType(generatorConfig.getClientGeneratorType());
        daoConfig.setTargetPackage(generatorConfig.getClientGeneratorTargetPackage());
        daoConfig.setTargetProject(generatorConfig.getTargetProject());
        daoConfig.setImplementationPackage(generatorConfig.getTargetProject());
        context.setJavaClientGeneratorConfiguration(daoConfig);



        // Comment
        CommentGeneratorConfiguration commentConfig = new CommentGeneratorConfiguration();
        // commentConfig.setConfigurationType(DbRemarksCommentGenerator.class.getName());
        if (generatorConfig.isComment()) {
            commentConfig.addProperty("columnRemarks", "true");
        }
        if (generatorConfig.isAnnotation()) {
            commentConfig.addProperty("annotations", "true");
        }
        commentConfig.addProperty("suppressAllComments","true");
        commentConfig.addProperty("suppressDate","true");
        context.setCommentGeneratorConfiguration(commentConfig);


        context.setTargetRuntime("MyBatis3");

        // 添加扩展插件
        for(String plugin :pluginList) {
            PluginConfiguration pc = new PluginConfiguration();
            pc.setConfigurationType(plugin);
            context.addPluginConfiguration(pc);
            LOG.debug("add plugin = {}" , plugin);
        }

        List<String> warnings = new ArrayList<>();
        Set<String> fullyqualifiedTables = new HashSet<>();
        Set<String> contexts = new HashSet<>();
        ShellCallback shellCallback = new DefaultShellCallback(true); // override=true
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
        myBatisGenerator.generate(progressCallback, contexts, fullyqualifiedTables);
    }

    public void setProgressCallback(ProgressCallback progressCallback) {
        this.progressCallback = progressCallback;
    }

    public void setIgnoredColumns(List<IgnoredColumn> ignoredColumns) {
        this.ignoredColumns = ignoredColumns;
    }


    @Override
    public void persistent(MyBatisOutputItem outputItem) {
        MyBatisGeneratorConfig config = outputItem.getConfig();
        setMyBatisGeneratorConfig(config);
        try {
            generate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOG.info("Mybatis persist completed.");

    }


}
