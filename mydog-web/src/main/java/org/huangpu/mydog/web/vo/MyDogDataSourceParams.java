package org.huangpu.mydog.web.vo;

import org.huangpu.mydog.core.plugins.metadata.MyDogPluginMetaData;
import org.huangpu.mydog.plugins.datasource.metadata.DatasourcePluginProperties;
import org.huangpu.mydog.web.exception.MyDogParamsParserException;
import org.huangpu.mydog.web.status.DataBaseTypeEnum;
import org.huangpu.mydog.web.status.MetaDataTypeEnum;
import org.huangpu.mydog.web.util.PathUtils;

import com.alibaba.fastjson.JSON;

/**
 * 生成项目的 datasource定义
 * @author xusihan on 2017.07.10
 */
public class MyDogDataSourceParams extends AbstractMyDogParams{
	
	/**
	 * db
	 */
	private String database;
	
	/**
	 * url
	 */
	private String url;
	
	/**
	 * user
	 */
	private String user;
	
	/**
	 * password
	 */
	private String password;
	
	/**
	 * dateType {@link DataBaseTypeEnum} 
	 */
	private Byte dataType;
	
	/**
	 * jar path
	 */
	private String jarPath;

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Byte getDataType() {
		return dataType;
	}

	public void setDataType(Byte dataType) {
		this.dataType = dataType;
	}

	public String getJarPath() {
		return jarPath;
	}

	public void setJarPath(String jarPath) {
		this.jarPath = jarPath;
	}

	@Override
	public String toString() {
		return "MyDogDataSourceParams [database=" + database + ", url=" + url + ", user=" + user + ", password="
				+ password + ", dataType=" + dataType + ", jarPath=" + jarPath + "]";
	}
	@Override
	public MyDogPluginMetaData parser() {
		return parser(this);
	}
	@Override
	public MyDogPluginMetaData parser(AbstractMyDogParams myDogParams) {
		if (!(myDogParams instanceof  MyDogDataSourceParams)) {
			throw new MyDogParamsParserException(String.format("将 {%s} 强制转换成{%s} 出错", myDogParams.getClass().getName(),this.getClass().getName())) ;
		}
		MyDogDataSourceParams params = (MyDogDataSourceParams)myDogParams;
		MyDogPluginMetaData metaData = new MyDogPluginMetaData();
		DatasourcePluginProperties properties = new DatasourcePluginProperties();
		// 必须字段
		setProperties(properties,params);
		//metaData
		metaData.setProperties(properties);
		metaData.setMetadataType(MetaDataTypeEnum.DATASOURCE.value());
		metaData.setInstanceName(params.getInstanceName());
		return metaData;
	}

	
	private void setProperties(DatasourcePluginProperties properties,MyDogDataSourceParams params) {
		properties.setDatasourceUsername(params.getUser());
		properties.setDatasourcePassword(params.getPassword());
		properties.setDriverJarPath(params.getJarPath());
		switch (DataBaseTypeEnum.getByValue(params.getDataType())) {
		case MYSQL:
			properties.setDatasourceDriverClassName("com.mysql.jdbc.Driver");
			properties.setDatasourceUrl(PathUtils.parserMysqlPath(params.getUrl(), params.getDatabase()));
			break;
		default:
			break;
		}
	}
	
	
	public static void main(String[] args) {
		
		MyDogDataSourceParams myDogDataSourceParams = new MyDogDataSourceParams();
		myDogDataSourceParams.setDatabase("raindrops");
		myDogDataSourceParams.setDataType(DataBaseTypeEnum.MYSQL.value());
		myDogDataSourceParams.setJarPath("C://xxxx");
		myDogDataSourceParams.setPassword("123456");
		myDogDataSourceParams.setUser("root");
		myDogDataSourceParams.setUrl("localhost");
		
		MyDogPluginMetaData myDogPluginMetaData = myDogDataSourceParams.parser(myDogDataSourceParams);
		System.out.println(JSON.toJSON(myDogPluginMetaData).toString());
		
	}
	
}
