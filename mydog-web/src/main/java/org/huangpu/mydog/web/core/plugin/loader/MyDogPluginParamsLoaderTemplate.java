package org.huangpu.mydog.web.core.plugin.loader;

import java.util.ArrayList;
import java.util.List;

import org.huangpu.mydog.core.plugins.metadata.MyDogPluginMetaData;
import org.huangpu.mydog.web.vo.MyDogPluginsParams;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author xusihan on 2017.07.01
 */
public class MyDogPluginParamsLoaderTemplate implements MyDogPluginParamsLoader{
	
	private List<MyDogPluginMetaData> myDogPluginMetaDatas;
	
	@Override
	public void loadMyDogPluginParams(MyDogPluginsParams myDogPluginsParams) {
		myDogPluginMetaDatas = myDogPluginsParams.getPluginsParamsMetaData();
	}

	@Override
	public String getParamsJsonData() {
		return JSON.toJSON(myDogPluginMetaDatas).toString();
	}
	
}
