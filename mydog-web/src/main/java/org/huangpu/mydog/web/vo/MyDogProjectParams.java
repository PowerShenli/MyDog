package org.huangpu.mydog.web.vo;

import org.huangpu.mydog.core.plugins.metadata.MyDogPluginMetaData;
import org.huangpu.mydog.plugins.project.metadata.ProjectPluginProperties;
import org.huangpu.mydog.web.exception.MyDogParamsParserException;
import org.huangpu.mydog.web.util.PathUtils;

import com.alibaba.fastjson.JSON;

/**
 * 
 * 基础的项目配置项
 * @author xusihan on 2017.07.10
 *
 */
public class MyDogProjectParams extends AbstractMyDogParams{
	
	/**
	 * project groupId
	 */
	private String groupId;
	
	/**
	 * project artifactId
	 */
	private String artifactId;
	
	/**
	 * project version
	 */
	private String version;
	/**
	 * output path
	 */
	private String outputPath;
	
	/**
	 * default port
	 */
	private int port;
	
	/**
	 * 项目所用的 springboot 版本
	 */
	private String springbootVersion;
	
	/**
	 * project name
	 */
	private String projectName;

	/**
	 * 项目名称
	 */
	private String instanceName;
	
	/**
	 * base package
	 */
	private String basePackage;
	
	/**
	 * logging type
	 */
	private Byte loggingType;
	
	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getOutputPath() {
		return outputPath;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getSpringbootVersion() {
		return springbootVersion;
	}

	public void setSpringbootVersion(String springbootVersion) {
		this.springbootVersion = springbootVersion;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Byte getLoggingType() {
		return loggingType;
	}

	public void setLoggingType(Byte loggingType) {
		this.loggingType = loggingType;
	}

	@Override
	public String toString() {
		return "MyDogProjectParams [groupId=" + groupId + ", artifactId=" + artifactId + ", version=" + version
				+ ", outputPath=" + outputPath + ", port=" + port + ", springbootVersion=" + springbootVersion
				+ ", projectName=" + projectName + "]";
	}

	@Override
	public MyDogPluginMetaData parser() {
		return parser(this);
	}
	
	@Override
	public MyDogPluginMetaData parser(AbstractMyDogParams myDogParams) {
		if (!(myDogParams instanceof MyDogProjectParams)) {
			throw new MyDogParamsParserException(String.format("将 {%s} 强制转换成{%s} 出错", myDogParams.getClass().getName(),this.getClass().getName())) ;
		}
		MyDogProjectParams myDogProjectParams = (MyDogProjectParams) myDogParams;
		MyDogPluginMetaData medadata = new MyDogPluginMetaData();
		ProjectPluginProperties properties = new ProjectPluginProperties();
		setProperties(properties,myDogProjectParams);
		medadata.setProperties(properties);
		return medadata;
	}
	
	private ProjectPluginProperties setProperties(ProjectPluginProperties properties,MyDogProjectParams params) {
		properties.setArtifactId(params.getArtifactId());
		properties.setBasePackage(params.getBasePackage());
		properties.setBasePath(PathUtils.formatBasePath(params.getBasePackage()));
		properties.setGroupId(params.getGroupId());
		properties.setOutputPath(params.getOutputPath());
		properties.setProjectName(params.getProjectName());
		properties.setServerPort(params.getProjectName());
		properties.setSpringBootVersion(params.getSpringbootVersion());
		properties.setVersion(params.getVersion());
		return properties;
	}
	
	
	public static void main(String[] args) {
		MyDogProjectParams myDogProjectParams = new MyDogProjectParams();
		myDogProjectParams.setArtifactId("sdfafsf");
		myDogProjectParams.setBasePackage("/a/sd/d/f");
		myDogProjectParams.setGroupId("raindrops");
		myDogProjectParams.setLoggingType((byte)0);
		myDogProjectParams.setOutputPath("/R/A/S/Z/X/");
		myDogProjectParams.setPort(3304);
		myDogProjectParams.setProjectName("ahahha");
		myDogProjectParams.setSpringbootVersion("4.2.1.2");
		myDogProjectParams.setVersion("3.2");
		System.out.println(JSON.toJSON(myDogProjectParams.parser(myDogProjectParams)).toString());
	}

	
	
}
