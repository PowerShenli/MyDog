package org.huangpu.mydog.web.core.plugin.loader;

import java.util.List;
import java.util.Map;

import org.huangpu.mydog.core.Metadata;
import org.huangpu.mydog.core.plugins.GenerateContext;

/**
 * 
 * Using Map<String,List<MetaData> to save all plugin properties
 * 
 * @author xusihan on 2017.07.01
 */
public abstract class MyDogPluginPropertiesLoaderTemplate implements MyDogPluginPropertiesLoader{
	
	
	
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
