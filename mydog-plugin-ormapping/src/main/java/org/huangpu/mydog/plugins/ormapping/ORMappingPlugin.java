package org.huangpu.mydog.plugins.ormapping;

import com.alibaba.fastjson.JSONObject;
import org.huangpu.mydog.core.*;
import org.huangpu.mydog.core.plugins.BasePlugin;
import org.huangpu.mydog.core.propresolver.CpPropResolver;

/**
 * Created by shenli on 2017/7/11.
 */
public class ORMappingPlugin extends BasePlugin {


    @Override
    protected ClassLoader getClassLoader() {
        return ORMappingPlugin.class.getClassLoader();
    }

    @Override
    public String getMetadataType() {
        return "ormapping";
    }

    @Override
    public MetaDataPropResolver getPropResolver() {
        return new CpPropResolver("entity","ormapping");
    }

    @Override
    public GeneratorDecorator getGeneratorDecorator(Generator generator) {
        return new ORMappingGeneratorDecorator(generator);
    }

    @Override
    public JSONObject getViewProps() {
        return null;
    }
}
