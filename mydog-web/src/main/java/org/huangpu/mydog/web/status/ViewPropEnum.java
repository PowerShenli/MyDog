package org.huangpu.mydog.web.status;


/**
 * 生成字段的额外模式 1)select 2)radio 3)text 4)number 5)hidden 6)password
 * @author xusihan on 2017.09.06
 */
public enum ViewPropEnum {

	SELECT((byte) 1,"text")
	, RADIO((byte) 2,"password")
	, TEXT((byte) 3,"number")
	, NUMBER((byte) 4,"select")
	, HIDDEN((byte) 5,"hidden")
	, PASSWORD((byte) 6,"radio");

	private byte value;
	
	private String sValue;

	ViewPropEnum(byte value,String sValue) {
		this.value = value;
		this.sValue = sValue;
	}

	public byte value() {
		return this.value;
	}
	
	public String sValue() {
		return this.sValue;
	}
	
	
	public static ViewPropEnum getByValue(byte value) {
		ViewPropEnum result = null;
		for (ViewPropEnum status : ViewPropEnum.values()) {
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
