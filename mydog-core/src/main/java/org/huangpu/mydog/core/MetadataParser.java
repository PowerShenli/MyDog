package org.huangpu.mydog.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.huangpu.mydog.core.plugins.GenerateContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shenli on 2017/6/1.
 */
public class MetadataParser {

	private static Logger logger = LoggerFactory.getLogger(MetadataParser.class);
	
    public static Metadata parse(JSONObject jsonObj) {
        JSONObject properties = parseProperties(jsonObj);
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
    
    private static JSONObject parseProperties(JSONObject jsonObject) {
    	JSONObject result = null;
    	if (jsonObject==null) {
    		logger.warn("Null JSONObject ! metadata parser demojson -> get properties node value Null");
    		return null;
		}
    	result = jsonObject.getJSONObject("properties");
    	if (result==null) {//if null set a empty object
			result = JSONObject.parseObject(JSONObject.toJSONString(new NullMetadataProperties()));
		}
    	return result;
    }
    
}
