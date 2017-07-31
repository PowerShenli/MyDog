package org.huangpu.mydog.web.vo;

import org.huangpu.mydog.core.plugins.metadata.MyDogPluginMetaData;

/*
 * xusihan on 2017.07.20
 */
public abstract class AbstractMyDogParams {
	
	public abstract MyDogPluginMetaData parser();
	
	public abstract MyDogPluginMetaData parser(AbstractMyDogParams myDogParams);
	
}
