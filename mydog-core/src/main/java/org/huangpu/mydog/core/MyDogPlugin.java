package org.huangpu.mydog.core;

import com.alibaba.fastjson.JSONObject;


/**
 * Created by shenli on 2017/6/1.
 */
public interface MyDogPlugin {

    /**
     * 初始化
     */
    void init();

    /**
     * 获取元数据类型
     * @return 元数据类型
     */
    String getMetadataType();

    /**
     * 获取本插件依赖的其它插件的属性
     * @return 依赖的属性
     */
    JSONObject getDependencyProps();

    /**
     * 获取元数据属性解析器
     * @return 元数据的属性解析器
     */
    MetaDataPropResolver getPropResolver();

    /**
     * 获取该插件输出定义
     * @return 输出定义
     */
    OutputDef getOutputDef();

    /**
     * 获取该插件的元数据相关的装饰器
     * 该方法是为了让插件可以扩展默认生成器的行为
     * @return 返回对应装饰器
     */
    GeneratorDecorator getGeneratorDecorator(Generator generator);




}
