package org.huangpu.mydog.core.grammar;

import org.huangpu.mydog.core.Grammar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by shenli on 2017/4/17.
 */
public class PropertiesGrammar implements Grammar,Mergeable<PropertiesGrammar> {

    private static final Logger LOG = LoggerFactory.getLogger(PropertiesGrammar.class);

    private Map<String,Object> prop = new HashMap<>();
//    private OutputItemDefinition outItemDefinition;

//    public PropertiesGrammar(OutputItemDefinition outItemDefinition) {
//        this.outItemDefinition = outItemDefinition;
//        Map<String,Object> mm = (Map<String,Object>)outItemDefinition.getPropMap().get("propMap");
//        prop.putAll(mm);
//    }

    @Override
    public boolean supportMerge(PropertiesGrammar other) {
        return other != null && other.getClass().equals(PropertiesGrammar.class);
    }

    @Override
    public PropertiesGrammar merge(PropertiesGrammar other) {
        prop.putAll(other.prop);
//        outItemDefinition.getPropMap().put("propMap", prop);
        return this;
    }

//
//    @Override
//    public void parsePropMap(Map<String, Object> map) {
//        Map<String,Object> mm = (Map<String,Object>)map.get("propMap");
//        prop.putAll(mm);
//    }

    @Override
    public String getCode() {
        String content = prop.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("\n"));
//        LOG.debug("content = {} ", content);
        return content;
    }
}
