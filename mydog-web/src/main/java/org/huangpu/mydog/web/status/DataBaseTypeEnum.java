package org.huangpu.mydog.web.status;

/**
 * DataBase Type MYSQL(0) ORACLE(1)
 * @author xusihan on 2017.07.10
 */
public enum DataBaseTypeEnum {

	MYSQL((byte)0),
	ORACLE((byte)1);
	
	private byte value;
	
	private DataBaseTypeEnum(byte value) {
		this.value = value;
	}
	
	public byte value() {
		return this.value;
	}
}
