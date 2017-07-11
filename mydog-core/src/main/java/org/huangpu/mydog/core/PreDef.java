package org.huangpu.mydog.core;

/**
 * Created by shenli on 2017/6/1.
 */
public class PreDef {

    private String outputPath;
    private String cpFilePath;
    private String itemName;

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public String getCpFilePath() {
        return cpFilePath;
    }

    public void setCpFilePath(String cpFilePath) {
        this.cpFilePath = cpFilePath;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "PreDef{" +
                "outputPath='" + outputPath + '\'' +
                ", cpFilePath='" + cpFilePath + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
