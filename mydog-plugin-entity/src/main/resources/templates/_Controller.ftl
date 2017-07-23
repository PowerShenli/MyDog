<#assign entityName=entity["entityName"]/>
<#assign prj=project["mydogProj"]/>
package ${prj["basePackage"]}.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ${prj["basePackage"]}.domain.${entityName};
import ${prj["basePackage"]}.service.${entityName}Service;
import ${prj["basePackage"]}.bean.PageDataInfo;
@Controller
@RequestMapping(value = "/${entityName?lower_case}")
public class ${entityName}Controller {

    private static final Logger Log = LoggerFactory.getLogger(${entityName}Controller.class);
   
    @Autowired
    private ${entityName}Service service;
    
    @RequestMapping(value="/page",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> page(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        Log.info("${entityName}Controller.page");
        PageDataInfo<${entityName}> pageData=service.getPage(pageNum, pageSize);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("resCode",200);
        result.put("resMsg","操作成功");
        <#--result.put("data",pageData);-->
        result.put("data",pageData.getList());
        result.put("pageNum",pageData.getPageNum());
        result.put("pageSize",pageData.getPageSize());
        result.put("size",pageData.getSize());
        result.put("total",pageData.getTotal());
        result.put("pages",pageData.getPages());
        return result;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> list(){
        Log.info("${entityName}Controller.list");
        List<${entityName}> entityList = service.getAll${entityName}();
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("resCode",200);
        result.put("resMsg","操作成功");
        result.put("data",entityList);
        return result;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> get(@PathVariable ${entity["idType"]} id){
        Log.info("${entityName}Controller.get id="+id);
        ${entityName} entity = service.get${entityName}ById(id);
        Map<String,Object> result = new HashMap<String,Object>();
        if(entity != null){
            result.put("resCode",200);
            result.put("resMsg","操作成功");
            result.put("data",entity);
        }
        else{
            result.put("resCode",500);
            result.put("reason","can not find ${entityName} for id="+id);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> update(@RequestBody @Valid ${entityName} ${entityName?lower_case}){
        Log.info("${entityName}Controller.update(\n{}\n)",${entityName?lower_case}); 
        int cnt = service.update(${entityName?lower_case});
      
        Map<String, Object> response = new HashMap<String,Object>(){{
            put("resCode",200);
            put("resMsg","操作成功");
            //put("update","completed");
            put("cnt",cnt);
        }};
        return response;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> delete(@PathVariable ${entity["idType"]} id){
        Log.info("${entityName}Controller.delete");
        int cnt = service.delete(id);
        Map<String, Object> response = new HashMap<String,Object>(){{
            put("resCode",200);
            put("resMsg","操作成功");
            //put("delete","completed");
            put("cnt",cnt);
        }};
        return response;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> create(@RequestBody @Valid ${entityName} ${entityName?lower_case}){
        Log.info("${entityName}Controller.create");
        int cnt = service.create(${entityName?lower_case});
        Map<String, Object> response = new HashMap<String,Object>(){{
            put("resCode",200);
            put("resMsg","操作成功");
            put("id", ${entityName?lower_case}.getId());
            put("cnt", cnt);
        }};
        return response;
    }

}