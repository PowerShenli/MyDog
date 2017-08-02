package org.huangpu.mydog.web.core.plugin.loader;

import org.huangpu.mydog.core.plugins.metadata.MyDogPluginMetaData;
import org.huangpu.mydog.web.vo.MyDogPluginsParams;

/**
 * @author xusihan on 2017.06.30
 *
 */
public interface MyDogPluginParamsLoader {
	
	/**
	 * 
	 * To load all mydog plugin properties
	 * 
	 * @author xusihan on 2017.07.11
	 */
	void loadMyDogPluginParams(MyDogPluginsParams myDogPluginsParams);
	
	/**
	 * 得到所需要的demo.json
	 * @return
	 */
	String getParamsJsonData();
}
