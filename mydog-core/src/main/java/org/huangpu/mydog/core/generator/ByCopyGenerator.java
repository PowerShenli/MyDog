package org.huangpu.mydog.core.generator;

import org.huangpu.mydog.core.Generator;
import org.huangpu.mydog.core.Metadata;
import org.huangpu.mydog.core.OutputItem;
import org.huangpu.mydog.core.OutputItemDef;
import org.huangpu.mydog.core.outputitem.CopyOutputItem;
import org.huangpu.mydog.core.plugins.GenerateContext;
import org.huangpu.mydog.core.preserver.ByCopyPreserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

/**
 * Created by shenli on 2017/6/2.
 */
public class ByCopyGenerator implements Generator {

    private static final Logger LOG = LoggerFactory.getLogger(ByCopyGenerator.class);

    @Override
    public OutputItem generate(Metadata metaInstance, OutputItemDef outputItemDef) {
        String outputPath2 = outputItemDef.getPreDef().getOutputPath();
        String cpFilePath = outputItemDef.getPreDef().getCpFilePath();

        String itemName = outputItemDef.getItemName();
        LOG.debug("\n itemName = {}, \n cpFilePath = {}, \n outputPath = {}", itemName, cpFilePath, outputPath2);
        CopyOutputItem outputItem = new CopyOutputItem();
        outputItem.setOutputPath(outputPath2);
        outputItem.setPreserver(new ByCopyPreserver());
        outputItem.setCpFilePath(cpFilePath);
        outputItem.setOutputName(itemName);

        URL resourceFolder = GenerateContext.getPluginByMetadataType(metaInstance.getType()).getClass().getProtectionDomain().getCodeSource().getLocation();
        outputItem.setResourceFolder(resourceFolder);

        ClassLoader classLoader = GenerateContext.getPluginByMetadataType(metaInstance.getType()).getClass().getClassLoader();
        outputItem.setClassLoader(classLoader);

        return outputItem;
    }
}
