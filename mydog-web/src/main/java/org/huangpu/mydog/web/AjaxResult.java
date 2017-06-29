package org.huangpu.mydog.web;

import java.util.HashMap;

/**
 * 接口返回统一API
 * 包括 code data mes
 * @author xusihan on 2017/06/22
 */
public class AjaxResult extends HashMap<String, Object>{
	
	private static final long serialVersionUID = 1L;

	private AjaxResult(){
	}
	
	/**
	 * 初始化
	 * @return
	 */
	public static AjaxResult prepare() {
		return new AjaxResult();
	}
	
	/**
	 * 结果
	 * @param code 响应
 	 * @param data 数据
	 * @param mes 响应消息
	 * @return
	 */
	public AjaxResult result(int code,Object data,String mes) {
		this.put("code", code);
		this.put("data", data);
		this.put("mes",mes);
		return this;
	}
	
}
