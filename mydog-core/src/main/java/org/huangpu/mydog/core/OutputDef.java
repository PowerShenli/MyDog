package org.huangpu.mydog.core;

import java.util.List;
import java.util.Map;

/**
 * Created by shenli on 2017/6/6.
 */
public class OutputDef {

    List<OutputItemDef> commList;
    Map<String,List<OutputItemDef>> instanceDefMap;

    public List<OutputItemDef> getCommList() {
        return commList;
    }

    public void setCommList(List<OutputItemDef> commList) {
        this.commList = commList;
    }

    public Map<String, List<OutputItemDef>> getInstanceDefMap() {
        return instanceDefMap;
    }

    public void setInstanceDefMap(Map<String, List<OutputItemDef>> instanceDefMap) {
        this.instanceDefMap = instanceDefMap;
    }


}
