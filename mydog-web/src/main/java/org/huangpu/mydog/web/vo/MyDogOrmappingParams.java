package org.huangpu.mydog.web.vo;

import org.huangpu.mydog.core.plugins.metadata.MyDogPluginMetaData;

/**
 * 
 * @author xusihan on 2017.07.25
 *
 */
public class MyDogOrmappingParams extends AbstractMyDogParams{

	@Override
	public MyDogPluginMetaData parser() {
		return parser(this);
	}
	@Override
	public MyDogPluginMetaData parser(AbstractMyDogParams myDogParams) {
		return null;
	}

}
