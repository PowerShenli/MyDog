<#assign entityName=entity["entityName"]/>
<#assign prj=project["mydogProj"]/>

package ${prj["basePackage"]}.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ${prj["basePackage"]}.domain.${entityName};
import ${prj["basePackage"]}.domain.${entityName}Example;
import ${prj["basePackage"]}.mapping.${entityName}Mapper;
import ${prj["basePackage"]}.bean.PageDataInfo;

@Component
public class ${entityName}Service {
    private static final Logger Log = LoggerFactory.getLogger(${entityName}Service.class);

    @Autowired
    private ${entityName}Mapper ${entityName?lower_case}Dao;
    
	public ${entityName} get${entityName}ById(Integer id) {
		${entityName} entity = ${entityName?lower_case}Dao.selectByPrimaryKey(id);
		return entity;
	}
	
	public List<${entityName}> getAll${entityName}() {
		${entityName}Example example = new ${entityName}Example();
		List<${entityName}> entityList = ${entityName?lower_case}Dao.selectByExample(example);
		return entityList;
	}
	
	
	public PageDataInfo<${entityName}> getPage(int pageNum, int pageSize) {
		${entityName}Example example = new ${entityName}Example();
		PageHelper.startPage(pageNum, pageSize);
		List<${entityName}> entityList = ${entityName?lower_case}Dao.selectByExample(example);
		PageInfo<${entityName}> pagehelpInfo = new PageInfo<>(entityList);
		PageDataInfo<${entityName}> pageData = new PageDataInfo<${entityName}>(pagehelpInfo.getList());
		pageData.setPageNum(pageNum);
		pageData.setPageSize(pageSize);
		pageData.setPages(pagehelpInfo.getPages());
		pageData.setSize(pagehelpInfo.getSize());
		pageData.setTotal(pagehelpInfo.getTotal());
		return pageData;
	}
  
   public int  update(${entityName} role){
        int cnt = ${entityName?lower_case}Dao.updateByPrimaryKey(role);
        return cnt;
    }
	public int delete(int id) {
		int cnt = ${entityName?lower_case}Dao.deleteByPrimaryKey(id);
		return cnt;
	}

	public int create(${entityName} role) {
		int cnt=${entityName?lower_case}Dao.insert(role);
		return cnt;
	}
}