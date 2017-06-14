<#assign prj=project["mydogProj"]/>

package ${prj.basePackage}.config;

import org.springframework.context.annotation.Configuration;
<#if imports??>
    <#list imports as import>
import ${import};
    </#list>
</#if>

@Configuration
public class BootConfig {



}