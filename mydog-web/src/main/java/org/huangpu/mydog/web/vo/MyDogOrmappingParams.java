package org.huangpu.mydog.web.vo;

import org.huangpu.mydog.core.plugins.metadata.MyDogPluginMetaData;
import org.huangpu.mydog.plugins.ormapping.metadata.OrmappingPluginProperties;
import org.huangpu.mydog.plugins.project.metadata.ProjectPluginProperties;
import org.huangpu.mydog.web.exception.MyDogParamsParserException;
import org.huangpu.mydog.web.status.MetaDataTypeEnum;
import org.huangpu.mydog.web.util.PathUtils;

/**
 * 
 * @author xusihan on 2017.07.25
 *
 */
public class MyDogOrmappingParams extends AbstractMyDogParams{

	private String mapperType;
	
	public String getMapperType() {
		return mapperType;
	}
	public void setMapperType(String mapperType) {
		this.mapperType = mapperType;
	}
	@Override
	public MyDogPluginMetaData parser() {
		return parser(this);
	}
	@Override
	public MyDogPluginMetaData parser(AbstractMyDogParams myDogParams) {
		if (!(myDogParams instanceof MyDogOrmappingParams)) {
			throw new MyDogParamsParserException(String.format("将 {%s} 强制转换成{%s} 出错", myDogParams.getClass().getName(),this.getClass().getName())) ;
		}
		MyDogOrmappingParams myDogOrmappingParams = (MyDogOrmappingParams) myDogParams;
		MyDogPluginMetaData metadata = new MyDogPluginMetaData();
		OrmappingPluginProperties properties = new OrmappingPluginProperties();
		setProperties(properties, myDogOrmappingParams);
		metadata.setInstanceName(myDogOrmappingParams.getInstanceName());
		metadata.setProperties(properties);
		metadata.setMetadataType(MetaDataTypeEnum.ORMAPPING.value());
		return metadata;
	}
	
	private void setProperties(OrmappingPluginProperties properties,MyDogOrmappingParams params) {
		properties.setMapperType(params.getMapperType());
	}
	
	
}
