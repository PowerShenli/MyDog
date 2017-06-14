package org.huangpu.mydog.core.outputitem;

import org.huangpu.mydog.core.OutputItem;

import java.net.URL;

/**
 * Created by shenli on 2017/6/2.
 */
public class CopyOutputItem extends OutputItem {

    private String outputPath;
    private String cpFilePath;
    private URL resourceFolder;
    private ClassLoader classLoader;

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public URL getResourceFolder() {
        return resourceFolder;
    }

    public void setResourceFolder(URL resourceFolder) {
        this.resourceFolder = resourceFolder;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public String getCpFilePath() {
        return cpFilePath;
    }

    public void setCpFilePath(String cpFilePath) {
        this.cpFilePath = cpFilePath;
    }
}
