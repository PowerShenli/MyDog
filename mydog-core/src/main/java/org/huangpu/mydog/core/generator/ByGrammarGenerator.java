package org.huangpu.mydog.core.generator;

import org.huangpu.mydog.core.*;
import org.huangpu.mydog.core.enums.OutputFormat;
import org.huangpu.mydog.core.grammar.GrammarFactory;
import org.huangpu.mydog.core.outputitem.GrammarOutputItem;
import org.huangpu.mydog.core.preserver.ByGrammarPreserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shenli on 2017/6/2.
 */
public class ByGrammarGenerator implements Generator {

    private static final Logger LOG = LoggerFactory.getLogger(ByGrammarGenerator.class);

    @Override
    public OutputItem generate(Metadata metaInstance, OutputItemDef outputItemDef) {
        LOG.info("ByGrammarGenerator.generate()");

        OutputFormat outputFormat = outputItemDef.getGenDef().getOutputFormat();

        LOG.debug("outputFormat = {}, itemName = {}" , outputFormat, outputItemDef.getGenDef().getItemName());

        Grammar grammar = GrammarFactory.buildGrammar(outputFormat);
//        Map<String,Object> propMap = outItemDefinition.getPropMap();

//        Objects.requireNonNull(propMap);
//        grammar.parsePropMap(propMap);

        GrammarOutputItem codedOutputItem = new GrammarOutputItem();
        codedOutputItem.setGrammar(grammar);
        codedOutputItem.setOutputFormat(outputFormat);
        codedOutputItem.setOutputName(outputItemDef.getGenDef().getItemName());
        codedOutputItem.setOutputPath(outputItemDef.getPreDef().getOutputPath());


        String code = grammar.getCode();
        LOG.debug("code = {}", code);
        codedOutputItem.setOutputContent(code);
        codedOutputItem.setPreserver(new ByGrammarPreserver());

        return codedOutputItem;
    }
}
