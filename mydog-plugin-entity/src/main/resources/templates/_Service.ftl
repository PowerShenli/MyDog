<#assign entityName=entity["entityName"]/>
<#assign prj=project["mydogProj"]/>

package ${prj["basePackage"]}.service;

public class ${entityName}Service {

<#if mymap??>
    <#list mymap?keys as key>
        <#assign item = mymap[key]>
        <#list item as itemValue>
             ${key} = ${itemValue}
        </#list>
    </#list>
</#if>

}