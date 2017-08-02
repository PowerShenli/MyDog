package org.huangpu.mydog.web.exception;

/**
 * 处理在解析从前端传过来的Params类型不符合异常
 */
public class MyDogParamsParserException extends RuntimeException{

	public MyDogParamsParserException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyDogParamsParserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MyDogParamsParserException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MyDogParamsParserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MyDogParamsParserException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
