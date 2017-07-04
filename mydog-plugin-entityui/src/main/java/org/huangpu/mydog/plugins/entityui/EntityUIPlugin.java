package org.huangpu.mydog.plugins.entityui;

import com.alibaba.fastjson.JSONObject;
import org.huangpu.mydog.core.*;
import org.huangpu.mydog.core.propresolver.MyDogFunction;

/**
 * Created by shenli on 2017/6/13.
 */
public class EntityUIPlugin implements MyDogPlugin {

    private JSONObject dependencyProps;
    private MetaDataPropResolver resolver = new EntityUIPropResolver();
    private static final ClassLoader classLoader = EntityUIPlugin.class.getClassLoader();

    @Override
    public void init()
    {
        dependencyProps = MyDogFunction.getDepFunc.apply(getMetadataType(),classLoader);
    }

    @Override
    public String getMetadataType() {
        return "entityui";
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
        return MyDogFunction.renderOutputDef("entityui",classLoader);
    }

    @Override
    public GeneratorDecorator getGeneratorDecorator(Generator generator) {
        return new EntityUIGeneratorDecorator(generator);
    }

    @Override
    public JSONObject getViewProps() {
        return null;
    }

    //TODO: 1 多种UI风格支持
    //TODO: 2 分页支持

}
