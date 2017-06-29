package org.huangpu.mydog.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author xusihan on 2017.06.30
 */
@Configuration
@PropertySource(value = "file:///${CONFIG_HOME}/application.properties", ignoreResourceNotFound = true)
public class MyDogApplicationConfig {
	
	@Value("${mydog.admin.user}")
	private String user;
	
	@Value("${mydog.admin.password}")
	private String password;

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
	
	
	
}
