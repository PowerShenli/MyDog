package org.huangpu.mydog.web.status;


/**
 * 生成字段的额外模式 0)不为空 1)为空
 * @author xusihan on 2017.09.06
 */
public enum EntityIsPageEnum {

	NOT_PAGE((byte) 0,false), PAGE((byte) 1,true);

	private byte value;
	
	private boolean sValue;

	EntityIsPageEnum(byte value,boolean sValue) {
		this.value = value;
		this.sValue = sValue;
	}

	public byte value() {
		return this.value;
	}
	
	public boolean sValue() {
		return this.sValue;
	}
	
	
	public static EntityIsPageEnum getByValue(byte value) {
		EntityIsPageEnum result = null;
		for (EntityIsPageEnum status : EntityIsPageEnum.values()) {
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
