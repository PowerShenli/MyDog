package org.huangpu.mydog.web.status;

/**
 * 
 * 日志类型 Logback(0)
 * @author xusihan on 2017.07.20
 *
 */
public enum LogTypeEnum {
	
	Logback((byte)0);
	
	private byte value;
	
	private LogTypeEnum(byte value) {
		this.value = value;
	}
	
	public byte value() {
		return this.value;
	}
	
}
