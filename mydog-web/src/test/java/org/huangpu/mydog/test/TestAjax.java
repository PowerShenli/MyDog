package org.huangpu.mydog.test;

import org.huangpu.mydog.web.AjaxResult;
import org.junit.Test;

public class TestAjax {
	
	@Test
	public void test01() {
		AjaxResult result = AjaxResult.prepare();
		result.result(1, "helloworld", "test");
		System.out.println(result);
	}
	
}
