package org.huangpu.mydog.plugins.project.metadata;

import java.util.HashMap;
import java.util.Map;

import org.huangpu.mydog.core.plugins.metadata.AbstractMyDogPluginProperties;

/**
 * 
 * @author xusihan on 2017.07.17
 *
 */
public class ProjectPluginProperties extends AbstractMyDogPluginProperties{

	private static final long serialVersionUID = 7037011594288798410L;
	
	public ProjectPluginProperties() {
		super();
		project = new HashMap<>();
		appProp = new HashMap<>();
	}
	
	/**
	 * 项目名称 前端的brand
	 */
	private String name;
	
	/**
	 * spring boot 版本
	 */
	private String springBootVersion;
	
	/**
	 * groupId artifactId version 配置
	 */
	private Map<String,String> project;
	
	/**
	 * 基本路径
	 */
	private String basePath;
	
	/**
	 * 项目输出
	 */
	private String outputPath;
	
	/**
	 * 输出类型 file / download
	 */
	private String outputType;
	
	/**
	 * 基本包结构
	 */
	private String basePackage;
	
	/**
	 * server.port  "logging.config":"classpath:logback.xml"
	 */
	private Map<String, String> appProp;

	public String getName() {
		return name;
	}

	public String getSpringBootVersion() {
		return springBootVersion;
	}

	public Map<String, String> getProject() {
		return project;
	}

	public String getBasePath() {
		return basePath;
	}

	public String getOutputPath() {
		return outputPath;
	}

	public String getOutputType() {
		return outputType;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public Map<String, String> getAppProp() {
		return appProp;
	}

	////////////////////////////////////////////
	//setter
	/////////////////////////////////////////////
	
	
	/** name */
	public void setProjectName(String name) {
		this.name = name;
	}
	/**
	 * outputType
	 * @param outputType
	 */
	public void setOutputType(String outputType) {
		this.outputType = outputType;
	}

	/** springBootVersion */
	public void setSpringBootVersion(String springBootVersion) {
		this.springBootVersion = springBootVersion;
	}
	
	/** groupId */
	public void setGroupId(String projectGroupId) {
		project.put("groupId", projectGroupId);
	}
	
	/** artifactId */
	public void setArtifactId(String projectArtifactId) {
		project.put("artifactId", projectArtifactId);
	}
	
	/** version */
	public void setVersion(String projectVersion) {
		project.put("version", projectVersion);
	}
	
	/** basePath */
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	
	/** outputPath */
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}
	
	/** basePackage */
	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
	
	/** server.port */
	public void setServerPort(String serverPort) {
		appProp.put("server.port", serverPort);
	}
	
	/** logging.config */
	public void setLoggingConfig(String loggingConfig) {
		appProp.put("logging.config", loggingConfig);
	}
	
}
