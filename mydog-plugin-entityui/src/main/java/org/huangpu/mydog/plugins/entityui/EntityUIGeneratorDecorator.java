package org.huangpu.mydog.plugins.entityui;

import com.alibaba.fastjson.JSONObject;
import org.huangpu.mydog.core.*;
import org.huangpu.mydog.core.utils.CloneUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by shenli on 2017/6/13.
 */
public class EntityUIGeneratorDecorator extends GeneratorDecorator {

    private static final Logger LOG = LoggerFactory.getLogger(EntityUIGeneratorDecorator.class);

    public EntityUIGeneratorDecorator(Generator generator) {
        super(generator);
    }

    @Override
    public OutputItem generate(Metadata metaInstance, OutputItemDef outputItemDef) {

        LOG.debug("outputItemDef = {}", outputItemDef.getItemName());
        //元数据实例的属性
        JSONObject entityProp = metaInstance.getProp();
        //克隆所有的属性到新集合,保证不改变公共属性集
        Map<String, Object> templateProp = CloneUtils.clone(outputItemDef.getGenDef().getTemplateProp());
        //加入本实例的属性到这份copy中的固定位置,目的是在模板中渲染时模型一致
        templateProp.put("entity", entityProp);
        outputItemDef.getGenDef().setTemplateProp(templateProp);
        return generator.generate(metaInstance, outputItemDef);
    }


}
