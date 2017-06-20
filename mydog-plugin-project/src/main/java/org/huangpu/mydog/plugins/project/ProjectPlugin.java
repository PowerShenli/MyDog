package org.huangpu.mydog.plugins.project;

import com.alibaba.fastjson.JSONObject;
import org.huangpu.mydog.core.*;
import org.huangpu.mydog.core.propresolver.EmptyMetaDataPropResolver;
import org.huangpu.mydog.core.propresolver.MyDogFunction;

/**
 * Created by shenli on 2017/6/2.
 */
public class ProjectPlugin implements MyDogPlugin {

    private JSONObject dependencyProps;
    private MetaDataPropResolver resolver = new EmptyMetaDataPropResolver();
    private static final ClassLoader classLoader = ProjectPlugin.class.getClassLoader();


    @Override
    public void init() {
        dependencyProps = MyDogFunction.getDepFunc.apply(getMetadataType(),classLoader);
    }

    @Override
    public String getMetadataType() {
        return "project";
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
        return MyDogFunction.renderOutputDef("project",classLoader);
    }

    @Override
    public GeneratorDecorator getGeneratorDecorator(Generator generator) {
        return new GeneratorDecorator(generator) {
            @Override
            public OutputItem generate(Metadata metaInstance, OutputItemDef outputItemDef) {
                return generator.generate(metaInstance,outputItemDef);
            }
        };
    }

    @Override
    public JSONObject getViewProps() {
        return null;
    }

    //TODO: 支持多种project定义
}
