package org.huangpu.mydog.plugins.datasource;


import com.alibaba.fastjson.JSONObject;
import org.huangpu.mydog.core.MetaDataPropResolver;
import org.huangpu.mydog.core.plugins.GenerateContext;

import java.util.Map;

/**
 * Created by shenli on 2017/6/2.
 */
public class DatasourcePropResolver implements MetaDataPropResolver {

    @Override
    public void resolve() {
        Map<String,Map<String,JSONObject>> props = GenerateContext.get("props");
        JSONObject datasource = props.get("datasource").get("tomcatDatasource");
        JSONObject connectionProps = datasource.getJSONObject("connectionProps");

        JSONObject project = props.get("project").get("mydogProj");
        JSONObject appProp = project.getJSONObject("appProp");

        System.out.println("before merge appProp = " + appProp);
        appProp.putAll(connectionProps);

        props = GenerateContext.get("props");
        JSONObject project2 = props.get("project").get("mydogProj");
        project2.getJSONObject("appProp");

        System.out.println("after merge appProp = "+ appProp);


    }

}
