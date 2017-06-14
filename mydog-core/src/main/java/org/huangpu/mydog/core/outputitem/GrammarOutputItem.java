package org.huangpu.mydog.core.outputitem;

import org.huangpu.mydog.core.Grammar;
import org.huangpu.mydog.core.OutputItem;
import org.huangpu.mydog.core.enums.OutputFormat;

/**
 * Created by shenli on 2017/6/2.
 */
public class GrammarOutputItem extends OutputItem {

    private OutputFormat outputFormat;
    private Grammar grammar;
    private String outputPath;

    public OutputFormat getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(OutputFormat outputFormat) {
        this.outputFormat = outputFormat;
    }

    public Grammar getGrammar() {
        return grammar;
    }

    public void setGrammar(Grammar grammar) {
        this.grammar = grammar;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
}
