package org.huangpu.mydog.web.core.plugin.loader;

import java.util.List;
import java.util.Map;

import org.huangpu.mydog.core.Metadata;

/**
 * 1.when the web application start
 * this loader will load all plugins of mydog and
 * put then in the container
 * 
 * 2.got a parser that explain the container while built at step 1
 * 
 * 3.let the parser to be a PARSERTOVIEW
 * 
 * 4.show this view at frontend
 * 
 * @author xusihan on 2017.06.30
 *
 */
public interface MyDogPluginPropertiesLoader {
	
	/**
	 * 
	 * To load all mydog plugin properties
	 * 
	 * @author xusihan on 2017.07.11
	 */
	Map<String, List<Metadata>> loadMyDogPluginProperties();
	
}
