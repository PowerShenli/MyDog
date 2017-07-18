package org.huangpu.mydog.plugins.ormapping;

import com.alibaba.fastjson.JSONArray;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Properties;

/**
 * Created by shenli on 2017/5/31.
 */
public class MybatisValidatePlugin extends PluginAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(MybatisValidatePlugin.class);

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass,
                                       IntrospectedColumn introspectedColumn,
                                       IntrospectedTable introspectedTable,
                                       ModelClassType modelClassType) {
        introspectedColumn.getLength();
        introspectedColumn.isNullable();

        Properties colProps = introspectedColumn.getProperties();

        String fieldName = field.getName();
        LOG.debug("fieldName = {},{}" , fieldName,colProps);

        String validates = colProps.getProperty("validates","[]");
        JSONArray array = JSONArray.parseArray(validates);
        array.stream().forEach(o -> {
            String v = String.valueOf(o);
            LOG.debug("validate=>{}", v);
            field.addAnnotation(v);
            FullyQualifiedJavaType imptStr = new FullyQualifiedJavaType(getImport(v));
            topLevelClass.addImportedType(imptStr);
        });

        return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }


    private String getImport(String validate){
        String imptStr = "javax.validation.constraints.";
        int index = validate.indexOf("(");
        if (index != -1) {
            validate = validate.substring(0,index);
        }
        return imptStr + validate.substring(1);
    }


}
