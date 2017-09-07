package org.huangpu.mydog.web.vo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.huangpu.mydog.core.plugins.metadata.MyDogPluginMetaData;
import org.huangpu.mydog.web.exception.MyDogOperationNotSupportedException;
import org.huangpu.mydog.web.exception.MyDogParamsNullPointException;

/**
 * 
 * 主要接收前端所有用于生成json的mydog plugin定义
 * TODO:考虑到参数太多 后续版本要进行异步保存和修改
 * @author xusihan on 2017.07.10
 *
 */
public class MyDogPluginsParams extends AbstractMyDogParams{
	
	/**
	 * mydog project params
	 */
	private MyDogProjectParams myDogProjectParams;
	
	private MyDogDataSourceParams myDogDataSourceParams;
	
	private List<MyDogEntityParams> myDogEntityParams;
	
	private MyDogEntityUIParams myDogEntityUIParams;
	
	private MyDogOrmappingParams myDogOrmappingParams;
	
	
	public MyDogDataSourceParams getMyDogDataSourceParams() {
		return myDogDataSourceParams;
	}

	public void setMyDogDataSourceParams(MyDogDataSourceParams myDogDataSourceParams) {
		this.myDogDataSourceParams = myDogDataSourceParams;
	}

	public List<MyDogEntityParams> getMyDogEntityParams() {
		return myDogEntityParams;
	}

	public void setMyDogEntityParams(List<MyDogEntityParams> myDogEntityParams) {
		this.myDogEntityParams = myDogEntityParams;
	}

	public MyDogEntityUIParams getMyDogEntityUIParams() {
		return myDogEntityUIParams;
	}

	public void setMyDogEntityUIParams(MyDogEntityUIParams myDogEntityUIParams) {
		this.myDogEntityUIParams = myDogEntityUIParams;
	}

	public MyDogOrmappingParams getMyDogOrmappingParams() {
		return myDogOrmappingParams;
	}

	public void setMyDogOrmappingParams(MyDogOrmappingParams myDogOrmappingParams) {
		this.myDogOrmappingParams = myDogOrmappingParams;
	}

	public MyDogProjectParams getMyDogProjectParams() {
		return myDogProjectParams;
	}

	public void setMyDogProjectParams(MyDogProjectParams myDogProjectParams) {
		this.myDogProjectParams = myDogProjectParams;
	}
	@Override
	public MyDogPluginMetaData parser() {
		throw new MyDogOperationNotSupportedException("operation not supported.");
	}
	@Override
	public MyDogPluginMetaData parser(AbstractMyDogParams myDogParams) {
		throw new MyDogOperationNotSupportedException("operation not supported.");
	}
	

	public List<MyDogPluginMetaData> getPluginsParamsMetaData(){
		//myDogProjectParams.parser(myDogParams)
		List<MyDogPluginMetaData> myDogPluginMetaDatas = new ArrayList<>();
		if (myDogProjectParams==null) {
			throw new MyDogParamsNullPointException("mydog project must not be null !");
		}
		if (myDogDataSourceParams!=null) {
			myDogPluginMetaDatas.add(myDogDataSourceParams.parser());
		}
		myDogPluginMetaDatas.add(myDogProjectParams.parser());
		if (myDogEntityUIParams!=null) {
			myDogPluginMetaDatas.add(myDogEntityUIParams.parser());
		}
		if (myDogOrmappingParams!=null) {
			myDogPluginMetaDatas.add(myDogOrmappingParams.parser());
		}
		if (!CollectionUtils.isEmpty(myDogEntityParams)) {
			myDogEntityParams.forEach(p-> myDogPluginMetaDatas.add(p.parser()));
		}
		if (CollectionUtils.isEmpty(myDogPluginMetaDatas)) {
			
		}
		return myDogPluginMetaDatas;
	}
}
