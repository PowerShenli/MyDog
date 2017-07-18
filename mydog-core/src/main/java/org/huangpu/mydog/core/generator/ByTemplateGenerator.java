package org.huangpu.mydog.core.generator;

import org.huangpu.mydog.core.Generator;
import org.huangpu.mydog.core.Metadata;
import org.huangpu.mydog.core.OutputItem;
import org.huangpu.mydog.core.OutputItemDef;
import org.huangpu.mydog.core.outputitem.TemplateOutputItem;
import org.huangpu.mydog.core.preserver.ByTemplatedPreserver;
import org.huangpu.mydog.core.utils.TemplateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by shenli on 2017/6/2.
 */
public class ByTemplateGenerator implements Generator {

    private static final Logger LOG = LoggerFactory.getLogger(ByTemplateGenerator.class);

    @Override
    public OutputItem generate(Metadata metaInstance, OutputItemDef outputItemDef) {

        String templateSource = outputItemDef.getGenDef().getTemplateCtx();
        String itemName = outputItemDef.getGenDef().getItemName();
        //生成目标代码
        Map<String,Object> templateProp = outputItemDef.getGenDef().getTemplateProp();
//        if (itemName.equals("index.html")) {
//            LOG.info("meta.instanceName= {} \nindex.html props == \n{}",metaInstance.getName(), templateProp);
//        }
        String code = TemplateUtils.render("itemCtx_" + itemName, templateSource, templateProp);

        TemplateOutputItem outputItem = new TemplateOutputItem();
        outputItem.setOutputContent(code);
        outputItem.setOutputPath(outputItemDef.getPreDef().getOutputPath());
        outputItem.setOutputName(itemName);
        outputItem.setPreserver(new ByTemplatedPreserver());

        LOG.debug("item.getOutputName = {}", itemName);
        LOG.debug("code = {}", code);

        return outputItem;
    }


}
