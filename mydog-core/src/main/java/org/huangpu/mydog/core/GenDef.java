package org.huangpu.mydog.core;

import org.huangpu.mydog.core.enums.GenType;
import org.huangpu.mydog.core.enums.OutputFormat;

import java.util.Map;

/**
 * Created by shenli on 2017/6/1.
 */
public class GenDef {

    private GenType genType;
    private OutputFormat outputFormat;
    private String itemName;
    private Grammar grammar;
    private String templateCtx;
    private String generatorName;
    private Boolean overwrite;
    private Map<String,Object> templateProp;

    public GenType getGenType() {
        return genType;
    }

    public void setGenType(GenType genType) {
        this.genType = genType;
    }

    public OutputFormat getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(OutputFormat outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Grammar getGrammar() {
        return grammar;
    }

    public void setGrammar(Grammar grammar) {
        this.grammar = grammar;
    }

    public String getTemplateCtx() {
        return templateCtx;
    }

    public void setTemplateCtx(String templateCtx) {
        this.templateCtx = templateCtx;
    }

    public String getGeneratorName() {
        return generatorName;
    }

    public void setGeneratorName(String generatorName) {
        this.generatorName = generatorName;
    }

    public Boolean getOverwrite() {
        return overwrite;
    }

    public void setOverwrite(Boolean overwrite) {
        this.overwrite = overwrite;
    }

    public Map<String,Object> getTemplateProp() {
        return templateProp;
    }

    public void setTemplateProp(Map<String,Object> templateProp) {
        this.templateProp = templateProp;
    }

    @Override
    public String toString() {
        return "GenDef{" +
                "genType=" + genType +
                ", outputFormat=" + outputFormat +
                ", itemName='" + itemName + '\'' +
                ", grammar=" + grammar +
                ", templateCtx='" + templateCtx + '\'' +
                ", generatorName='" + generatorName + '\'' +
                ", overwrite=" + overwrite +
                ", templateProp=" + templateProp +
                '}';
    }
}
