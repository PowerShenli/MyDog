package org.huangpu.mydog.core.grammar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenli on 2017/4/23.
 */
public class Method {
    private String mehtodName;
    private boolean isAbstract;
    private String returnType;
    private List<Field> params = new ArrayList<>();
    private List<Annotat> annotats = new ArrayList<>();
    private List<String> methodLines = new ArrayList<>();

    public String getMehtodName() {
        return mehtodName;
    }

    public void setMehtodName(String mehtodName) {
        this.mehtodName = mehtodName;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public void setAbstract(boolean anAbstract) {
        isAbstract = anAbstract;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public List<Field> getParams() {
        return params;
    }

    public void setParams(List<Field> params) {
        this.params = params;
    }

    public List<Annotat> getAnnotats() {
        return annotats;
    }

    public void setAnnotats(List<Annotat> annotats) {
        this.annotats = annotats;
    }

    public List<String> getMethodLines() {
        return methodLines;
    }

    public void setMethodLines(List<String> methodLines) {
        this.methodLines = methodLines;
    }
}
