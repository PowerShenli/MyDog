package org.huangpu.mydog.plugins.entity.metadata;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * @author xusihan on 2017.07.17
 *
 */
public class EntityPluginField implements Serializable{
	
	private static final long serialVersionUID = -2995460197231515120L;

	private String fieldName;
	
	private String label;
	
	private String isId;
	
	private Map<String, String> validates;
	
	private String fieldType;
	
	private String length;
	
	private String isNull;
	
	private Map<String, String> viewProp;

	public String getFieldName() {
		return fieldName;
	}

	public String getLabel() {
		return label;
	}

	public String getIsId() {
		return isId;
	}

	public Map<String, String> getValidates() {
		return validates;
	}

	public String getFieldType() {
		return fieldType;
	}

	public String getLength() {
		return length;
	}

	public String getIsNull() {
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

	public void setIsId(String isId) {
		this.isId = isId;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}
	
	public void setValidate(String validateType,String validate) {
		validates.put(validateType, validate);
	}
}
