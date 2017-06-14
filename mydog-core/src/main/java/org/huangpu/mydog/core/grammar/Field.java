package org.huangpu.mydog.core.grammar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenli on 2017/4/23.
 */
public class Field {
    private String type;
    private String filedName;
    private List<Annotat> annotats = new ArrayList();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public List<Annotat> getAnnotats() {
        return annotats;
    }

    public void setAnnotats(List<Annotat> annotats) {
        this.annotats = annotats;
    }
}
