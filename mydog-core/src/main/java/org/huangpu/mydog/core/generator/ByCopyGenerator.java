package org.huangpu.mydog.core.generator;

import org.huangpu.mydog.core.*;
import org.huangpu.mydog.core.outputitem.CopyOutputItem;
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

        URL resourceFolder = metaInstance.getPlugin().getClass().getProtectionDomain().getCodeSource().getLocation();
        outputItem.setResourceFolder(resourceFolder);

        ClassLoader classLoader = metaInstance.getPlugin().getClass().getClassLoader();
        outputItem.setClassLoader(classLoader);

        return outputItem;
    }
}
