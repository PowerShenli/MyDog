package org.huangpu.mydog.shell;

import org.apache.commons.io.FileUtils;
import org.huangpu.mydog.core.flow.FlowController;

import java.io.File;
import java.io.IOException;

/**
 * Created by shenli on 2017/6/15.
 */
public class ShellTools {

    public static void main(String[] args) throws IOException {
        if (args == null || args.length < 1) {
            System.err.println("please input the config json path. [java -jar mydog-shell-1.0-SNAPSHOT.jar /xxx/xxx.json]");
            System.exit(1);
        }
        String configPath = args[0];
        File cfgFile = new File(configPath);
        if (!cfgFile.exists()) {
            System.err.println("the config file [" + configPath + "] is not exist.");
            System.exit(1);
        }
        String json = FileUtils.readFileToString(cfgFile, "UTF-8");
        String s = new FlowController().startGenerate(json);
        System.out.println("execute " + s);
    }
}
