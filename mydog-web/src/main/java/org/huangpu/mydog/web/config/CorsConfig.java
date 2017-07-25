package org.huangpu.mydog.web.config;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域
 * @author xusihan on 2017.07.25
 */
@Configuration
public class CorsConfig {

	@Value("${cors.allowed.origin}")
	String allowCorsOrigin;

	private CorsConfiguration corsConfiguration() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		if (StringUtils.isEmpty(allowCorsOrigin)) {
			return corsConfiguration;
		}
		Stream.of(allowCorsOrigin.split(",")).forEach(s -> corsConfiguration.addAllowedOrigin(s));// 1允许域名
		//corsConfiguration.addAllowedOrigin(CorsConfiguration.ALL);
		corsConfiguration.addAllowedHeader(CorsConfiguration.ALL); // 2允许所有请求头
		corsConfiguration.addAllowedMethod(CorsConfiguration.ALL); // 3 允许所有请求方法
		return corsConfiguration;
	}
	
	@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration()); // 4
        return new CorsFilter(source);
    }

}
