package org.huangpu.mydog.web.status;


/**
 * instance 类型
 * @author xusihan on 2017.08.04
 */
public enum MetaDataTypeEnum {
	
	PROJECT("project"),
	DATASOURCE("datasource"),
	ORMAPPING("ormapping"),
	ENTITYUI("entityui"),
	ENTITY("entity");

	private String value;

	MetaDataTypeEnum(String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}

	public static MetaDataTypeEnum getByValue(String value) {
		MetaDataTypeEnum result = null;
		for (MetaDataTypeEnum status : MetaDataTypeEnum.values()) {
			if (status.value().equalsIgnoreCase(value)) {
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
