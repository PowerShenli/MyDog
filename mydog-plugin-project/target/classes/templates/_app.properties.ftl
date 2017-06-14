<#assign prj=project["mydogProj"]/>
<#list prj["appProp"]?keys as key>
    <#assign value = prj["appProp"][key]>
${key}=${value}
</#list>
