package org.huangpu.mydog.web.vo;

import org.huangpu.mydog.core.plugins.metadata.MyDogPluginMetaData;
import org.huangpu.mydog.web.exception.MyDogParamsParserException;

/**
 * Mydog entity UI plugins params
 * @author xusihan on 2017.07.11
 */
public class MyDogEntityUIParams extends AbstractMyDogParams{

	@Override
	public MyDogPluginMetaData parser(AbstractMyDogParams myDogParams) {
		if (!(myDogParams instanceof MyDogEntityUIParams)) {
			throw new MyDogParamsParserException(String.format("将 {%s} 强制转换成{%s} 出错", myDogParams.getClass().getName(),this.getClass().getName())) ;
		}
		MyDogEntityUIParams myDogEntityUIParams = (MyDogEntityUIParams)myDogParams;
		return null;
	}

}
