package org.huangpu.mydog.core;

/**
 * Created by shenli on 2017/6/1.
 */
public class OutputItem {

    private String outputName;
    private String outputContent;
    private Preserver preserver;

    public String getOutputName() {
        return outputName;
    }

    public void setOutputName(String outputName) {
        this.outputName = outputName;
    }

    public String getOutputContent() {
        return outputContent;
    }

    public void setOutputContent(String outputContent) {
        this.outputContent = outputContent;
    }

    public Preserver getPreserver() {
        return preserver;
    }

    public void  setPreserver(Preserver preserver) {
        this.preserver = preserver;
    }

    @Override
    public String toString() {
        return "OutputItem{" +
                "outputName='" + outputName + '\'' +
                ", outputContent='" + outputContent + '\'' +
                ", preserver=" + preserver +
                '}';
    }
}
