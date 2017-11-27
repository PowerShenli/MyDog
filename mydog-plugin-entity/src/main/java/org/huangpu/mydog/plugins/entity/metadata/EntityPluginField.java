package org.huangpu.mydog.plugins.entity.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author xusihan on 2017.07.17
 *
 */
public class EntityPluginField implements Serializable{
	
	public EntityPluginField() {
		validates = new HashSet<>();
		viewProp = new HashMap<>();
	}
	
	private static final long serialVersionUID = -2995460197231515120L;

	private String fieldName;
	
	private String label;
	
	private boolean isId;
	
	private Set<String> validates;
	
	private String fieldType;
	
	private String length;
	
	private boolean isNull;
	
	private Map<String, String> viewProp;

	public String getFieldName() {
		return fieldName;
	}

	public String getLabel() {
		return label;
	}

	public boolean getIsId() {
		return isId;
	}

	public Set<String> getValidates() {
		return validates;
	}

	public String getFieldType() {
		return fieldType;
	}

	public String getLength() {
		return length;
	}

	public boolean getIsNull() {
		return isNull;
	}

	public Map<String, String> getViewProp() {
		return viewProp;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setIsId(boolean isId) {
		this.isId = isId;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public void setIsNull(boolean isNull) {
		this.isNull = isNull;
	}
	
	public void setValidate(String validate) {
		validates.add(validate);
	}
	
	public void setViewPropType(String type) {
		viewProp.put("type", type);
	}
}
