package org.huangpu.mydog.test;

import org.apache.commons.io.FileUtils;
import org.huangpu.mydog.core.flow.FlowController;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by shenli on 2017/6/2.
 */
public class TestFlowController {

    @Test
    public void AtestFlow() throws IOException {
        String s = new FlowController().startGenerate(makeIntput());
        System.out.println("s = " + s);
    }

    private String makeIntput() throws IOException {
        String path = TestFlowController.class.getClassLoader().getResource(".").getPath();
        String allMetaJson = FileUtils.readFileToString(new File(path + "all_in_one.json"), "UTF-8");
        return allMetaJson;
    }
}
