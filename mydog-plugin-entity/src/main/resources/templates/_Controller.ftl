<#assign entityName=entity["entityName"]/>
<#assign prj=project["mydogProj"]/>
package ${prj["basePackage"]}.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ${prj["basePackage"]}.domain.${entityName};
import ${prj["basePackage"]}.domain.${entityName}Example;
import ${prj["basePackage"]}.mapping.${entityName}Mapper;
import ${prj["basePackage"]}.bean.PageDataInfo;
@Controller
@RequestMapping(value = "/${entityName?lower_case}")
public class ${entityName}Controller {

    private static final Logger Log = LoggerFactory.getLogger(${entityName}Controller.class);

    @Autowired
    private ${entityName}Mapper ${entityName?lower_case}Dao;

    @RequestMapping(value="/page",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> page(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        Log.info("${entityName}Controller.page");
        ${entityName}Example example = new ${entityName}Example();
        PageHelper.startPage(pageNum, pageSize);
        List<${entityName}> entityList = ${entityName?lower_case}Dao.selectByExample(example);
        PageInfo<${entityName}> pagehelpInfo=new PageInfo<>(entityList);
        PageDataInfo<${entityName}> pageData=new PageDataInfo<${entityName}>(pagehelpInfo.getList());
        
        pageData.setPageNum(pageNum);
        pageData.setPageSize(pageSize);
        pageData.setPages(pagehelpInfo.getPages());
        pageData.setSize(pagehelpInfo.getSize());
        pageData.setTotal(pagehelpInfo.getTotal());
        
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("success",true);
        result.put("data",pageData);
        return result;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> list(){
        Log.info("${entityName}Controller.list");
        ${entityName}Example example = new ${entityName}Example();
        List<${entityName}> entityList = ${entityName?lower_case}Dao.selectByExample(example);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("success",true);
        result.put("data",entityList);
        return result;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> get(@PathVariable ${entity["idType"]} id){
        Log.info("${entityName}Controller.get id="+id);
        ${entityName} entity = ${entityName?lower_case}Dao.selectByPrimaryKey(id);
        Map<String,Object> result = new HashMap<String,Object>();
        if(entity != null){
            result.put("success",true);
            result.put("data",entity);
        }
        else{
            result.put("success",false);
            result.put("reason","can not find ${entityName} for id="+id);
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> update(@RequestBody @Valid ${entityName} ${entityName?lower_case}){
        Log.info("${entityName}Controller.update(\n{}\n)",${entityName?lower_case});
        int cnt = ${entityName?lower_case}Dao.updateByPrimaryKey(${entityName?lower_case});
        Map<String, Object> response = new HashMap<String,Object>(){{
            put("success",true);
            put("update","completed");
            put("cnt",cnt);
        }};
        return response;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> delete(@PathVariable ${entity["idType"]} id){
        Log.info("${entityName}Controller.delete");
        int cnt = ${entityName?lower_case}Dao.deleteByPrimaryKey(id);
        Map<String, Object> response = new HashMap<String,Object>(){{
            put("success",true);
            put("delete","completed");
            put("cnt",cnt);
        }};
        return response;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> create(@RequestBody @Valid ${entityName} ${entityName?lower_case}){
        Log.info("${entityName}Controller.create");
        int cnt = ${entityName?lower_case}Dao.insert(${entityName?lower_case});
        Map<String, Object> response = new HashMap<String,Object>(){{
            put("success",true);
            put("id", ${entityName?lower_case}.getId());
            put("cnt", cnt);
        }};
        return response;
    }

}