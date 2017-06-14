package org.huangpu.mydog.core.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shenli on 2017/6/13.
 */
public class CloneUtils {

    public static Map<String,Object> clone(Map<String,Object> propMap) {
        Map<String, Object> result = new HashMap<>();
        propMap.entrySet().stream().forEach(e->{
            Map<String, JSONObject> valueMap = (Map<String, JSONObject>) e.getValue();
            Map<String, JSONObject> nvalueMap = new HashMap<String, JSONObject>();
            valueMap.entrySet().stream().forEach(e2->{
                nvalueMap.put(e2.getKey(), JSON.parseObject(e2.getValue().toJSONString()));
            });
            result.put(e.getKey(), nvalueMap);
        });
        return result;
    }

}
