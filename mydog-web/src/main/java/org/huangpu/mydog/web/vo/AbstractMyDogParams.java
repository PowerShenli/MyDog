package org.huangpu.mydog.web.vo;

import org.huangpu.mydog.core.plugins.metadata.MyDogPluginMetaData;

/*
 * xusihan on 2017.07.20
 */
public abstract class AbstractMyDogParams {
	
	protected String instanceName;
	
	public abstract MyDogPluginMetaData parser();
	
	public abstract MyDogPluginMetaData parser(AbstractMyDogParams myDogParams);

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	
}
