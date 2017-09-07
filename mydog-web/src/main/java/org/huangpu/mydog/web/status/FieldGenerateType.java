package org.huangpu.mydog.web.status;


/**
 * 生成字段的额外模式 0)无 1)自增长
 * @author xusihan on 2017.09.06
 */
public enum FieldGenerateType {

	NULL((byte) 0,""), INCREMENT((byte) 1,"increment");

	private byte value;
	
	private String sValue;

	FieldGenerateType(byte value,String sValue) {
		this.value = value;
		this.sValue = sValue;
	}

	public byte value() {
		return this.value;
	}
	
	public String sValue() {
		return this.sValue;
	}
	
}
