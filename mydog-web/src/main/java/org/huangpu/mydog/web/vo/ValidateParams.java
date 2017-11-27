package org.huangpu.mydog.web.vo;

/**
 * 
 * @author xusihan on 2017.09.05
 *
 */
public class ValidateParams {
	/**
	 * 字段名
	 */
	private String fieldName;

	/**
	 * 字段说明
	 */
	private String fieldLabel;

	/**
	 * 字段类型
	 */
	private String fieldType;

	/**
	 * 长度
	 */
	private String fieldLength;

	/**
	 * 最小值
	 */
	private String fieldValidateMin;

	
	/**
	 * 最大值
	 */
	private String fieldValidateMax;
	
	/**
	 * 正则匹配
	 */
	private String fieldValidateRegexp;

	/**
	 * 是否为空
	 */
	private byte fieldValidateNull;
	
	/**
	 * 是否ID
	 */
	private byte fieldIsId;
	
	/**
	 * 显示的类型
	 */
	private byte fieldViewProp;
	
	public byte getFieldIsId() {
		return fieldIsId;
	}

	public void setFieldIsId(byte fieldIsId) {
		this.fieldIsId = fieldIsId;
	}

	public byte getFieldViewProp() {
		return fieldViewProp;
	}

	public void setFieldViewProp(byte fieldViewProp) {
		this.fieldViewProp = fieldViewProp;
	}

	public byte getFieldValidateNull() {
		return fieldValidateNull;
	}

	public void setFieldValidateNull(byte fieldValidateNull) {
		this.fieldValidateNull = fieldValidateNull;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldLabel() {
		return fieldLabel;
	}

	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldLength() {
		return fieldLength;
	}

	public void setFieldLength(String fieldLength) {
		this.fieldLength = fieldLength;
	}

	public String getFieldValidateMin() {
		return fieldValidateMin;
	}

	public void setFieldValidateMin(String fieldValidateMin) {
		this.fieldValidateMin = fieldValidateMin;
	}

	public String getFieldValidateMax() {
		return fieldValidateMax;
	}

	public void setFieldValidateMax(String fieldValidateMax) {
		this.fieldValidateMax = fieldValidateMax;
	}

	public String getFieldValidateRegexp() {
		return fieldValidateRegexp;
	}

	public void setFieldValidateRegexp(String fieldValidateRegexp) {
		this.fieldValidateRegexp = fieldValidateRegexp;
	}
	
	
}
