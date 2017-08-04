package org.huangpu.mydog.plugins.ormapping.metadata;

import java.util.HashMap;
import java.util.Map;

import org.huangpu.mydog.core.plugins.metadata.AbstractMyDogPluginProperties;

/**
 * 
 * demo.json 中的Ormapping Properties
 * @author xusihan on 2017.08.04
 */
public class OrmappingPluginProperties extends AbstractMyDogPluginProperties{

	private static final long serialVersionUID = -1516580424322524556L;

	public OrmappingPluginProperties() {
		super();
		transaction = new HashMap<>();
		this.transaction.put("on", false);
		this.transaction.put("defaultStrategy", false);
		generateSQL=false;
	}
	
	private boolean generateSQL;
	
	private String mapperType;
	
	private Map<String, Object> transaction;

	public boolean isGenerateSQL() {
		return generateSQL;
	}

	public void setGenerateSQL(boolean generateSQL) {
		this.generateSQL = generateSQL;
	}

	public String getMapperType() {
		return mapperType;
	}

	public void setMapperType(String mapperType) {
		this.mapperType = mapperType;
	}

	public Map<String, Object> getTransaction() {
		return transaction;
	}

	public void setTransactionIsOn(boolean isOn) {
		this.transaction.put("on", isOn);
	}
	
	public void setDefaultStrategy(boolean defaultStrategy) {
		this.transaction.put("defaultStrategy", defaultStrategy);
	}
	
	
}
