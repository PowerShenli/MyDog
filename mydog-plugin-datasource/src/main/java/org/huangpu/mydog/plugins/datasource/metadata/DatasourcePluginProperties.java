package org.huangpu.mydog.plugins.datasource.metadata;

import java.util.HashMap;
import java.util.Map;

import org.huangpu.mydog.core.plugins.metadata.AbstractMyDogPluginProperties;

/**
 * 
 * @author xusihan on 2017.07.17
 *
 */
public class DatasourcePluginProperties extends AbstractMyDogPluginProperties {

	private static final long serialVersionUID = -5746982299287869446L;
	
	public DatasourcePluginProperties() {
		super();
		connectionProps = new HashMap<>();
		connectionProps.put("datasourceName", "default");
	}

	/**
	 * driverJarPath
	 */
	private String driverJarPath;

	private Map<String, String> connectionProps;

	public String getDriverJarPath() {
		return driverJarPath;
	}

	public void setDriverJarPath(String driverJarPath) {
		this.driverJarPath = driverJarPath;
	}

	public Map<String, String> getConnectionProps() {
		return connectionProps;
	}

	/** datasourceName */
	public void setDatasourceName(String datasourceName) {
		connectionProps.put("datasourceName", datasourceName);
	}

	/** spring.datasource.url */
	public void setDatasourceUrl(String datasourceUrl) {
		connectionProps.put("spring.datasource.url", datasourceUrl);
	}

	/** spring.datasource.username */
	public void setDatasourceUsername(String datasourceUsername) {
		connectionProps.put("spring.datasource.username", datasourceUsername);
	}

	/** spring.datasource.password */
	public void setDatasourcePassword(String datasourcePassword) {
		connectionProps.put("spring.datasource.password", datasourcePassword);
	}

	/** spring.datasource.driver-class-name */
	public void setDatasourceDriverClassName(String datasourceDriverClassName) {
		connectionProps.put("spring.datasource.driver-class-name", datasourceDriverClassName);
	}

	/** spring.datasource.test-on-borrow */
	public void setDatasourceTestOnBorrow(String datasourceTestOnBorrow) {
		connectionProps.put("spring.datasource.test-on-borrow", datasourceTestOnBorrow);
	}

	/** spring.datasource.max-wait-millis */
	public void setDatasourceMaxWaitMillis(String datasourceMaxWaitMillis) {
		connectionProps.put("spring.datasource.max-wait-millis", datasourceMaxWaitMillis);
	}

	/** spring.datasource.max-idle */
	public void setDatasourceMaxIdle(String datasourceMaxIdle) {
		connectionProps.put("spring.datasource.max-idle", datasourceMaxIdle);
	}
	
	/** spring.datasource.min-evictable-idle-time-millis */
	public void setDatasourceMinEvictableIdleTimeMillis(String datasourceMinEvictableIdleTimeMillis) {
		connectionProps.put("spring.datasource.min-evictable-idle-time-millis", datasourceMinEvictableIdleTimeMillis);
	}
	
	/** spring.datasource.min-idle */
	public void setDatasourceMinIdle(String datasourceMinIdle) {
		connectionProps.put("spring.datasource.min-idle", datasourceMinIdle);
	}
	
	/** spring.datasource.test-on-return */
	public void setDatasourceTestOnReturn(String datasourceTestOnReturn) {
		connectionProps.put("spring.datasource.test-on-return", datasourceTestOnReturn);
	}
	
	/** spring.datasource.time-between-eviction-runs-millis */
	public void setDatasourceTimeBetweenEvictionRunsMillis(String datasourceTimeBetweenEvictionRunsMillis) {
		connectionProps.put("spring.datasource.time-between-eviction-runs-millis", datasourceTimeBetweenEvictionRunsMillis);
	}
	
	/** spring.datasource.initial-size */
	public void setDatasourceInitialSize(String datasourceInitialSize) {
		connectionProps.put("spring.datasource.initial-size", datasourceInitialSize);
	}
	
	/** spring.datasource.test-while-idle */
	public void setDatasourceTestWhileIdle(String datasourceTestWhileIdle) {
		connectionProps.put("spring.datasource.test-while-idle", datasourceTestWhileIdle);
	}
	
	/** spring.datasource.validation-query */
	public void setDatasourceValidationQuery(String datasourceValiddationQuery) {
		connectionProps.put("spring.datasource.validation-query", datasourceValiddationQuery);
	}
}
