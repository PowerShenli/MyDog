package org.huangpu.mydog.web.vo;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.huangpu.mydog.core.plugins.metadata.MyDogPluginMetaData;
import org.huangpu.mydog.plugins.entity.metadata.EntityPluginField;
import org.huangpu.mydog.plugins.entity.metadata.EntityPluginProperties;
import org.huangpu.mydog.web.exception.MyDogParamsParserException;
import org.huangpu.mydog.web.status.EntityIsPageEnum;
import org.huangpu.mydog.web.status.FieldGenerateType;
import org.huangpu.mydog.web.status.FieldNullType;
import org.huangpu.mydog.web.status.MetaDataTypeEnum;
import org.huangpu.mydog.web.status.ViewPropEnum;
import org.springframework.util.StringUtils;

/**
 * mydog entity
 * @author xusihan on 2017.07.11
 *
 */
public class MyDogEntityParams extends AbstractMyDogParams{
	
	/**包名*/
	private String packageName;
	/**id字段*/
	private String id;
	/**自增长*/
	private byte isAutoIncrement;
	/**分页*/
	private byte isPage;
	/**页码大小*/
	private int pageSize;
	/**类名*/
	private String entityName;
	/**字段类型*/
	private String fieldType;
	/**字段说明*/
	private String label;
	/**验证属性*/
	private List<ValidateParams> validateParams;
	

	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public byte getIsAutoIncrement() {
		return isAutoIncrement;
	}
	public void setIsAutoIncrement(byte isAutoIncrement) {
		this.isAutoIncrement = isAutoIncrement;
	}
	public byte getIsPage() {
		return isPage;
	}
	public void setIsPage(byte isPage) {
		this.isPage = isPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public List<ValidateParams> getValidateParams() {
		return validateParams;
	}
	public void setValidateParams(List<ValidateParams> validateParams) {
		this.validateParams = validateParams;
	}
	
	@Override
	public MyDogPluginMetaData parser() {
		return parser(this);
	}	
	@Override
	public MyDogPluginMetaData parser(AbstractMyDogParams myDogParams) {
		if(!(myDogParams instanceof MyDogEntityParams)) {
			throw new MyDogParamsParserException(String.format("将 {%s} 强制转换成{%s} 出错", myDogParams.getClass().getName(),this.getClass().getName())) ;
		}
		MyDogEntityParams myDogEntityParams = (MyDogEntityParams)myDogParams;
		MyDogPluginMetaData metaData = new MyDogPluginMetaData();
		EntityPluginProperties properties = new EntityPluginProperties();
		setProperties(properties, myDogEntityParams);
		metaData.setInstanceName(entityName);
		metaData.setMetadataType(MetaDataTypeEnum.ENTITY.value());
		metaData.setProperties(properties);
		return metaData;
	}
	
	private void setProperties(EntityPluginProperties properties,MyDogEntityParams params) {
		properties.setEntityName(params.getEntityName());
		properties.setFieldName(params.getId());
		properties.setFieldType(params.getFieldType());
		properties.setGenerate(FieldGenerateType.INCREMENT.sValue());
		properties.setIdType(params.getFieldType());
		properties.setLabel(params.getLabel());
		properties.setPackageName(params.getPackageName());
		properties.setQuery(null);
		properties.setEnabled(EntityIsPageEnum.getByValue(params.getIsPage()).sValue());
		properties.setPageSize(Integer.toString(params.getPageSize()));
		setFields(properties,params);
	}
	
	private void setFields(EntityPluginProperties properties, MyDogEntityParams params) {
		if (!CollectionUtils.isEmpty(params.getValidateParams())) {
			params.getValidateParams().forEach(p->{
				EntityPluginField field = new EntityPluginField();
				field.setFieldName(p.getFieldName());
				field.setFieldType(p.getFieldType());
				field.setIsId(FieldNullType.getByValue(p.getFieldIsId()).sValue());
				field.setIsNull(FieldNullType.getByValue(p.getFieldValidateNull()).sValue());
				field.setLabel(p.getFieldLabel());
				field.setLength(p.getFieldLength());
				field.setViewPropType(ViewPropEnum.getByValue(p.getFieldViewProp()).sValue());
				/*if (!StringUtils.isEmpty(p.getFieldValidateNull())) {
					field.setValidate("@NotNull");
				}
				if (!StringUtils.isEmpty(p.getFieldValidateMin())) {
					field.setValidate("");
				}*/
				properties.addField(field);
			});
		}
	}
	
	
}
