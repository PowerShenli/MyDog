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


    /**
     * 获取该插件在mydog-web展现的内容
     *
     * @return
     * 返回JSON中应该包含可选的实例,以及每个实例对应的属性列表.
     * 属性列表中,应该明确每个属性的类型和对应的UI元素类型,及取值范围.
     * 比如Entity User 的 sex 属性, 类型是int,对应的UI元素类型是 select
     * 取值范围是 {"男":1,"女":2}
     *
     * mydog-web 会读取所有插件，并获取展示属性(通过本方法)，
     * mydog-web 会根据通用逻辑进行页面渲染.而不用根据不同插件的属性
     * 进行定制化的UI开发.
     *
     */
    JSONObject getViewProps();

}
