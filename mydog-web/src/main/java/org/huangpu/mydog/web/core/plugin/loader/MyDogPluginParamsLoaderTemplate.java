package org.huangpu.mydog.web.core.plugin.loader;

import java.util.List;
import java.util.Map;

import org.huangpu.mydog.core.Metadata;
import org.huangpu.mydog.core.plugins.GenerateContext;
import org.huangpu.mydog.core.plugins.metadata.MyDogPluginProperties;
import org.huangpu.mydog.web.vo.AbstractMyDogParams;

/**
 * 
 * 
 * @author xusihan on 2017.07.01
 */
public class MyDogPluginParamsLoaderTemplate implements MyDogPluginParamsLoader{
	
	@Override
	public MyDogPluginProperties loadMyDogPluginParams(AbstractMyDogParams MyDogParams) {
		
		return null;
	}
	
	private static class MetaDataCoordinator{
		/**
		 * init all plugin metaData
		 */
		public static void initMetaData() {
			// load metadata
			
			// let metadata's json to be obj
			
			// use component pattern to set those properties
			Map<String,List<Metadata>> metadataMapList = GenerateContext.get("metadataMapList");
			
			
			
		}
		
	}

}
