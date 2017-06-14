package org.huangpu.mydog.core;

import com.alibaba.fastjson.JSONObject;
import org.huangpu.mydog.core.plugins.GenerateContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shenli on 2017/6/1.
 */
public class MetadataParser {

    public static Metadata parse(JSONObject jsonObj) {
        JSONObject properties = jsonObj.getJSONObject("properties");
        String metadataType = jsonObj.getString("metadataType");
        String instanceName = jsonObj.getString("instanceName");

        Metadata meta = new Metadata();
        meta.setType(metadataType);
        meta.setName(instanceName);
        meta.setProp(properties);

        Map<String,Map<String,JSONObject>> propMap = GenerateContext.get("props");
        Map<String,JSONObject> map = propMap.get(metadataType);
        if (map == null) {
            map = new HashMap<>();
            propMap.put(metadataType, map);
        }
        map.put(instanceName, properties);
//        GenerateContext.putProp(metadataType+"::"+instanceName, properties);
        return meta;
    }
}
