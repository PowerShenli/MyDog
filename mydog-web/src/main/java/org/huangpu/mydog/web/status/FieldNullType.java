package org.huangpu.mydog.web.status;


/**
 * 生成字段是否是ID 0)不是 1)是
 * @author xusihan on 2017.09.06
 */
public enum FieldNullType {

	NOT_ID((byte) 0,false), ID((byte) 1,true);

	private byte value;
	
	private boolean sValue;

	FieldNullType(byte value,boolean sValue) {
		this.value = value;
		this.sValue = sValue;
	}

	public byte value() {
		return this.value;
	}
	
	public boolean sValue() {
		return this.sValue;
	}
	
	
	public static FieldNullType getByValue(byte value) {
		FieldNullType result = null;
		for (FieldNullType status : FieldNullType.values()) {
			if (status.value() == value) {
				result = status;
				break;
			}
		}
		if (result == null) {
			throw new IllegalArgumentException("No element matches " + value);
		}
		return result;
	}
}
