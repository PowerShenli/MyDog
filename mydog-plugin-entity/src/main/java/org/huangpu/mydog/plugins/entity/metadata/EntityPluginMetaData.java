package org.huangpu.mydog.plugins.entity.metadata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huangpu.mydog.core.plugins.metadata.AbstractMyDogPluginMetaData;

/**
 * 
 * @author xusihan on 2017.07.17
 *
 */
public class EntityPluginMetaData extends AbstractMyDogPluginMetaData {

	private static final long serialVersionUID = 2411937820328948001L;
	
	public EntityPluginMetaData() {
		super();
		id = new HashMap<>();
		fields = new ArrayList<>();
	}

	private String entityName;
	
	private String label;
	
	private Map<String, String> id;
	
	private String idType;
	
	private String packageName;
	
	private List<EntityPluginField> fields;
	
	private EntityQuery query;

	public String getEntityName() {
		return entityName;
	}

	public String getLabel() {
		return label;
	}

	public Map<String, String> getId() {
		return id;
	}

	public String getIdType() {
		return idType;
	}

	public String getPackageName() {
		return packageName;
	}

	public List<EntityPluginField> getFields() {
		return fields;
	}

	public EntityQuery getQuery() {
		return query;
	}

	//////////////////////////////
	//// setter
	/////////////////////////////
	
		
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public void setQuery(EntityQuery query) {
		this.query = query;
	}

	public void setFieldName(String fieldName) {
		id.put("fieldName", fieldName);
	}
	
	public void setFieldType(String fieldType) {
		id.put("fieldType", fieldType);
	}
	
	public void setGenerate(String generate) {
		id.put("generate", generate);
	}
	/** fields */
	public void addField(EntityPluginField entityPluginField) {
		fields.add(entityPluginField);
	}
	
}
