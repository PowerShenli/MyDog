package org.huangpu.mydog.web.vo;

import java.util.List;

import org.huangpu.mydog.core.plugins.metadata.MyDogPluginMetaData;
import org.huangpu.mydog.plugins.entity.metadata.EntityPluginProperties;
import org.huangpu.mydog.web.exception.MyDogParamsParserException;

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
		EntityPluginProperties prope rties = new EntityPluginProperties();
		setProperties(properties, myDogEntityParams);
		metaData.setProperties(properties);
		return metaData;
	}
	
	
	private void setProperties(EntityPluginProperties properties,MyDogEntityParams myDogEntityParams) {
		
		
	}
	
	
}
