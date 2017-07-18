package org.huangpu.mydog.web.vo;

import org.huangpu.mydog.web.status.DataBaseTypeEnum;

/**
 * 生成项目的 datasource定义
 * @author xusihan on 2017.07.10
 */
public class MyDogDataSourceParams {
	
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
	
}
