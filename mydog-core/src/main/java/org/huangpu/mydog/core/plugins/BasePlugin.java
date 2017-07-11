package org.huangpu.mydog.core.plugins;

import com.alibaba.fastjson.JSONObject;
import org.huangpu.mydog.core.*;
import org.huangpu.mydog.core.propresolver.EmptyMetaDataPropResolver;
import org.huangpu.mydog.core.propresolver.MyDogFunction;

/**
 * Created by shenli on 2017/7/11.
 */
public abstract class BasePlugin implements MyDogPlugin {

    private JSONObject dependencyProps;

    abstract protected ClassLoader getClassLoader();

    @Override
    public void init() {

        dependencyProps = MyDogFunction.getDepFunc.apply(getMetadataType(),getClassLoader());
    }

    @Override
    public JSONObject getDependencyProps() {
        return dependencyProps;
    }

    @Override
    public MetaDataPropResolver getPropResolver() {
        return new EmptyMetaDataPropResolver();
    }

    @Override
    public OutputDef getOutputDef() {
        return MyDogFunction.renderOutputDef(getMetadataType(),getClassLoader());
    }
}
