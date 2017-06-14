package org.huangpu.mydog.test;

import org.apache.commons.io.FileUtils;
import org.huangpu.mydog.core.MyDogPlugin;
import org.huangpu.mydog.core.plugins.GenerateContext;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by shenli on 2017/6/14.
 */
public class TestClassLoader {

    public static void main(String[] args) throws IOException {
        MyDogPlugin entityUiPlugin = GenerateContext.getPluginByMetadataType("entityui");
        ClassLoader classLoader = entityUiPlugin.getClass().getClassLoader();
        URL resource = classLoader.getResource("templates/bootstrap");
        System.out.println("resource = " + resource);
        File f = new File(resource.getFile());
        FileUtils.copyDirectory(f, new File("/tmp/mydogx/"));
    }
}
