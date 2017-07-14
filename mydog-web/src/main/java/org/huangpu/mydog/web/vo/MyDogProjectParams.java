package org.huangpu.mydog.web.vo;

/**
 * 
 * 基础的项目配置项
 * @author xusihan on 2017.07.10
 *
 */
public class MyDogProjectParams {
	
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

	@Override
	public String toString() {
		return "MyDogProjectParams [groupId=" + groupId + ", artifactId=" + artifactId + ", version=" + version
				+ ", outputPath=" + outputPath + ", port=" + port + ", springbootVersion=" + springbootVersion
				+ ", projectName=" + projectName + "]";
	}
	
}
