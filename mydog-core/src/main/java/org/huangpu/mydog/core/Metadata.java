package org.huangpu.mydog.core;

import com.alibaba.fastjson.JSONObject;
import org.huangpu.mydog.core.plugins.GenerateContext;

/**
 * Created by shenli on 2017/6/1.
 */
public class Metadata {

    private String name;
    private String type;
    private JSONObject prop;

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取元数据类型
     * @return
     */
    public String getType(){
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取具体的元数据名称
     * @return
     */
    public String getName(){
        return name;
    }

    public MyDogPlugin getPlugin(){
        return GenerateContext.getPluginByMetadataType(type);
    }

    public JSONObject getProp() {
        return prop;
    }

    public void setProp(JSONObject prop) {
        this.prop = prop;
    }
}
