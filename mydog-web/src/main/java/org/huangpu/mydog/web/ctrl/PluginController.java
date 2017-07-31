package org.huangpu.mydog.web.ctrl;

import org.huangpu.mydog.web.AjaxResult;
import org.huangpu.mydog.web.service.MyDogPluginService;
import org.huangpu.mydog.web.vo.MyDogDataSourceParams;
import org.huangpu.mydog.web.vo.MyDogEntityParams;
import org.huangpu.mydog.web.vo.MyDogEntityUIParams;
import org.huangpu.mydog.web.vo.MyDogPluginsParams;
import org.huangpu.mydog.web.vo.MyDogProjectParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * mydog plugins controller
 * @author xusihan on 2017.06.29
 */
@RestController
@RequestMapping("/v1/mydog/plugin")
public class PluginController {
	
	@Autowired
	MyDogPluginService myDogPluginService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@PostMapping("/project")
	@ResponseBody
	public AjaxResult configMydogProject(MyDogProjectParams myDogProjectParams) {
		
		return null;
	}
	
	@PostMapping("/datasource")
	@ResponseBody
	public AjaxResult configMydogDataSource(MyDogDataSourceParams myDogDataSourceParams) {
		return null;
	}
	
	@PostMapping("/entity")
	@ResponseBody
	public AjaxResult configMydogEntity(MyDogEntityParams myDogEntityParams) {
		return null;
	}
	
	@PostMapping("/entityUI")
	@ResponseBody
	public AjaxResult configMydogEntityUI(MyDogEntityUIParams myDogEntityUIParams) {
		return null;
	}
	
	@PostMapping("/mydogPlugins")
	@ResponseBody
	public AjaxResult buildJsonDemo(@RequestBody() MyDogPluginsParams myDogPluginsParams) {
		AjaxResult result = AjaxResult.prepare();
		System.out.println(myDogPluginsParams);
		myDogPluginService.parsePluginParams(myDogPluginsParams);
		return result;
	}
	
}
