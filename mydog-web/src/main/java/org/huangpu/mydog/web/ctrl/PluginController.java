package org.huangpu.mydog.web.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mydog plugins controller
 * @author xusihan on 2017.06.29
 */
@RestController
@RequestMapping("/v1/plugin")
public class PluginController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
}
