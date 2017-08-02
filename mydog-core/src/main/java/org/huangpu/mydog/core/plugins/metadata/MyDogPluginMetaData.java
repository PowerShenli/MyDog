package org.huangpu.mydog.core.plugins.metadata;

/**
 * 
 * @author xusihan on 20170724
 *
 */
public class MyDogPluginMetaData {
	
	private String metadataType;
	
	private String instanceName;
	
	private MyDogPluginProperties properties;

	public String getMetadataType() {
		return metadataType;
	}

	public void setMetadataType(String metadataType) {
		this.metadataType = metadataType;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public MyDogPluginProperties getProperties() {
		return properties;
	}

	public void setProperties(MyDogPluginProperties properties) {
		this.properties = properties;
	}
	
}
