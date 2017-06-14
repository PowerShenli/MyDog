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
//        Objects.requireNonNull(outputPath);
        CopyOutputItem outputItem = new CopyOutputItem();

//        OutputDef outputDef = metaInstance.getPlugin().getOutputDef();

//        File srcDir = null;// ,destDir = null;

//        String path = getClass().getClassLoader().getResource(".").getPath().replace("/test-classes", "/classes");
//            String outPath = "/tmp/myDog/output/";


//        Map<String, Map<String,JSONObject>> props = GenerateContext.get("props");
//        JSONObject project = props.get("project").get("mydogProj");
//        String outputPath1 = project.getString("outputPath");


//        srcDir = new File(path + cpFilePath);
//        outputItem.setGenType(GenType.byCopy);
        outputItem.setOutputPath(outputPath2);
        outputItem.setPreserver(new ByCopyPreserver());
        outputItem.setCpFilePath(cpFilePath);
        outputItem.setOutputName(itemName);

        URL resourceFolder = metaInstance.getPlugin().getClass().getProtectionDomain().getCodeSource().getLocation();
        outputItem.setResourceFolder(resourceFolder);

        ClassLoader classLoader = metaInstance.getPlugin().getClass().getClassLoader();
        outputItem.setClassLoader(classLoader);

//        outputItem.setOutputPath(outputPath);

//            destDir = new File(outPath + outputPath);
//            FileUtils.copyDirectory(srcDir, destDir);
//            outputItem.setDestDir(destDir.getPath());

//            TODO: 打到jar中后需要 xxx.jar!xxx 这样读取
//            URL url = getClass().getResource(cpFilePath);
//            FileUtils.copyURLToFile(url, destDir);


        return outputItem;
    }
}
