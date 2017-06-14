package org.huangpu.mydog.plugins.entity;


import com.alibaba.fastjson.JSONObject;
import org.huangpu.mydog.core.Generator;
import org.huangpu.mydog.core.Metadata;
import org.huangpu.mydog.core.OutputItem;
import org.huangpu.mydog.core.OutputItemDef;
import org.huangpu.mydog.core.plugins.GenerateContext;

import java.util.Map;

/**
 * Created by shenli on 2017/5/25.
 */
public class MyBatisGenerator implements Generator {


    @Override
    public OutputItem generate(Metadata metaInstance, OutputItemDef outputItemDef) {
        System.out.println("MyBatisGenerator.generate");

        MyBatisOutputItem outputItem = new MyBatisOutputItem();

        Map<String,Map<String,JSONObject>> stringMapMap = GenerateContext.get("props");

        JSONObject datasource = stringMapMap.get("datasource").get("tomcatDatasource");
        JSONObject connectionProps = datasource.getJSONObject("connectionProps");
        String driverClassName = connectionProps.getString("spring.datasource.driver-class-name");
        String url = connectionProps.getString("spring.datasource.url");
        String pass = connectionProps.getString("spring.datasource.password");
        String user = connectionProps.getString("spring.datasource.username");

        JSONObject project = stringMapMap.get("project").get("mydogProj");
        String targetProject = project.getString("outputPath");
        String basePackage = project.getString("basePackage");
//        String basePath = project.getString("basePath");

//        JSONObject entity = stringMapMap.get("entity").get("User");
//        String domainObjectName = entity.getString("entityName");
//        String tableName = MyBatisUtils.getTbName(domainObjectName);

        MyBatisGeneratorConfig myBConfig = new MyBatisGeneratorConfig();
        myBConfig.setConnectorJarFilePath("/Users/shenli/mvn/repo/m2/mysql/mysql-connector-java/5.1.40/mysql-connector-java-5.1.40.jar");
        myBConfig.setDriverClass(driverClassName);
        myBConfig.setConnectionURL(url);
        myBConfig.setUserName(user);
        myBConfig.setPassWord(pass);
        myBConfig.setTargetProject(targetProject+"src/main/java/");
        myBConfig.setClientGeneratorTargetPackage(basePackage+".mapping");
        myBConfig.setModelGeneratorTargetPackage(basePackage+".domain");
//        myBConfig.setTableName(tableName);
//        myBConfig.setDomainObjectName(domainObjectName);
        myBConfig.setOffsetLimit(true);

        System.out.println("myBConfig = " + myBConfig);


        MyBatisPreserver myBatisPreserver = new MyBatisPreserver();
//        myBatisPreserver.setColumnOverrides(columnOverrides);

        //2. 增加对应的插件
        //2.1 自定义的,支持校验的
        myBatisPreserver.addPlugin("org.huangpu.mydog.plugins.entity.MybatisValidatePlugin");
        //2.2 Mybatis自带的
        myBatisPreserver.addPlugin("org.mybatis.generator.plugins.ToStringPlugin");
        myBatisPreserver.addPlugin("org.mybatis.generator.plugins.SerializablePlugin");
        myBatisPreserver.addPlugin("org.mybatis.generator.plugins.EqualsHashCodePlugin");

//        outputItem.setOutputPath(targetProject);
//        outputItem.setBasePackage(targetPackage);
//        outputItem.setGenType(outItemDefinition.getGenType());
        outputItem.setContext(myBConfig);
        outputItem.setPreserver(myBatisPreserver);

        return outputItem;
    }


}
