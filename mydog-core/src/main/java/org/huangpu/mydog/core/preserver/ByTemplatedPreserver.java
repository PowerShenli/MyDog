package org.huangpu.mydog.core.preserver;

import org.apache.commons.io.FileUtils;
import org.huangpu.mydog.core.Preserver;
import org.huangpu.mydog.core.outputitem.TemplateOutputItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by shenli on 2017/4/22.
 */
public class ByTemplatedPreserver implements Preserver<TemplateOutputItem> {

    private static final Logger LOG = LoggerFactory.getLogger(ByTemplatedPreserver.class);

    @Override
    public void persistent(TemplateOutputItem outputItem) {

        File dest = new File(outputItem.getOutputPath() + outputItem.getOutputName());
        try {
            FileUtils.writeStringToFile(dest, outputItem.getOutputContent(), "UTF-8");
            LOG.info("file = " + dest.getAbsolutePath());
        } catch (IOException e) {
            LOG.error("writeStringToFile failed.", e);
        }
    }
}
