package org.huangpu.mydog.web.ctrl;

import org.huangpu.mydog.web.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * admin controller of mydog-web
 * @author xusihan on 2017.06.29
 */
@RestController
@RequestMapping("/v1/user")
public class AdminController {
	
	/**
	 * authentication
	 * @param username
	 * @param password
	 * @return {@link AjaxResult}
	 */
	@GetMapping("auth")
	public AjaxResult adminAuth(String username,String password) {
		
		return null;
	}
	
	/**
	 * edit admin
	 */
	@PutMapping("/")
	public AjaxResult editAdmin() {
		return null;
	}
	
}
