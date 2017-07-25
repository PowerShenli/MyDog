package org.huangpu.mydog.web.core.plugin.loader;

import org.huangpu.mydog.core.plugins.metadata.MyDogPluginProperties;
import org.huangpu.mydog.web.vo.AbstractMyDogParams;

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
public interface MyDogPluginParamsLoader {
	
	/**
	 * 
	 * To load all mydog plugin properties
	 * 
	 * @author xusihan on 2017.07.11
	 */
	MyDogPluginProperties loadMyDogPluginParams(AbstractMyDogParams abstractMyDogParams);
	
}
