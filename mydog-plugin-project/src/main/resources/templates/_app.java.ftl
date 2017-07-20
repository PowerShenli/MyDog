<#assign prj=project["mydogProj"]/>
package ${prj["basePackage"]};

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<#--import org.springframework.context.annotation.Bean;-->
<#--import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;-->
<#--import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;-->
<#--import org.springframework.web.socket.config.annotation.EnableWebSocket;-->


@SpringBootApplication
@MapperScan("${prj["basePackage"]}.mapping")
<#--@EnableWebSocket-->
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    <#--@Bean-->
    <#--public EmbeddedServletContainerFactory servletContainer() {-->
    <#--JettyEmbeddedServletContainerFactory factory =-->
    <#--new JettyEmbeddedServletContainerFactory();-->
    <#--return factory;-->
    <#--}-->

}