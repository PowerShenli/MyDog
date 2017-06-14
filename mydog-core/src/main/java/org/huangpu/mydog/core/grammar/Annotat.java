package org.huangpu.mydog.core.grammar;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shenli on 2017/4/23.
 */
public class Annotat {
    private String annoName;
    private Map<String, String> annomap = new HashMap<>();

    public String getAnnoName() {
        return annoName;
    }

    public void setAnnoName(String annoName) {
        this.annoName = annoName;
    }

    public Map<String, String> getAnnomap() {
        return annomap;
    }

    public void setAnnomap(Map<String, String> annomap) {
        this.annomap = annomap;
    }
}
