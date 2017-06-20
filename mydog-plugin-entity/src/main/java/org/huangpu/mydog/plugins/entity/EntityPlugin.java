package org.huangpu.mydog.plugins.entity;


import com.alibaba.fastjson.JSONObject;
import org.huangpu.mydog.core.*;
import org.huangpu.mydog.core.propresolver.MyDogFunction;

/**
 * Created by shenli on 2017/6/2.
 */
public class EntityPlugin implements MyDogPlugin {

    private JSONObject dependencyProps;
    private MetaDataPropResolver resolver = new EntityPropResolver();
    private static final ClassLoader classLoader = EntityPlugin.class.getClassLoader();

    @Override
    public void init() {
        dependencyProps = MyDogFunction.getDepFunc.apply(getMetadataType(),classLoader);
    }

    @Override
    public String getMetadataType() {
        return "entity";
    }

    @Override
    public JSONObject getDependencyProps() {
        return dependencyProps;
    }

    @Override
    public MetaDataPropResolver getPropResolver() {
        return resolver;
    }

    @Override
    public OutputDef getOutputDef() {
        return MyDogFunction.renderOutputDef("entity",classLoader);
    }

    @Override
    public GeneratorDecorator getGeneratorDecorator(Generator generator) {
        return new EntityGeneratorDecorator(generator);
    }

    @Override
    public JSONObject getViewProps() {
        return null;
    }

    //TODO: 1 对于非本地运行Web来生成Entity的用户,应该提供DDL文件.(现在默认执行了,却没能让用户下载)
    //TODO: 2 非MySql数据库的支持比如DDL
}
