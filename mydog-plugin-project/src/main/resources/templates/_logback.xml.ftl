<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <!-- 文件输出格式 -->
    <property name="PATTERN" value="%-12(%d{yyyy-MM-dd HH:mm:ss.SSS}) |-%-5level [%thread] %c [%L] -| %msg%n" />

    <!-- 开发环境 -->
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>${r'${PATTERN}'}</pattern>
        </encoder>
    </appender>

    <logger name="${project["mydogProj"].basePackage}.mapping" level="debug"/>
    <logger name="log4j.logger.com.ibatis" level="debug"/>

    <root level="info">
        <appender-ref ref="CONSOLE" />
    </root>

</configuration>
