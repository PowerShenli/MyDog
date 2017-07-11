package org.huangpu.mydog.web.vo;

/**
 * 
 * 主要接收前端所有用于生成json的mydog plugin定义
 * @author xusihan on 2017.07.10
 *
 */
public class MyDogPluginsParams {
	
	/**
	 * mydog project params
	 */
	private MyDogProjectParams myDogProjectParams;

	public MyDogProjectParams getMyDogProjectParams() {
		return myDogProjectParams;
	}

	public void setMyDogProjectParams(MyDogProjectParams myDogProjectParams) {
		this.myDogProjectParams = myDogProjectParams;
	}
	
}
