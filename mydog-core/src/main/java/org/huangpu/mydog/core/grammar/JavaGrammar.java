package org.huangpu.mydog.core.grammar;


import org.huangpu.mydog.core.Grammar;

import java.util.List;

/**
 * Created by shenli on 2017/3/28.
 */
public class JavaGrammar implements Grammar, Mergeable<JavaGrammar> {

    private String packageName;
    private String className;
    private Boolean isAbstract;
    private String parent;
    private List<String> interfaces;
    private List<String> classAnnotations;
    private List<String> imports;
    private List<Field> fields;
    private List<Method> methods;
    private List<String> subClasses;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public List<String> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(List<String> interfaces) {
        this.interfaces = interfaces;
    }

    public List<String> getClassAnnotations() {
        return classAnnotations;
    }

    public void setClassAnnotations(List<String> classAnnotations) {
        this.classAnnotations = classAnnotations;
    }

    public List<String> getImports() {
        return imports;
    }

    public void setImports(List<String> imports) {
        this.imports = imports;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    public List<String> getSubClasses() {
        return subClasses;
    }

    public void setSubClasses(List<String> subClasses) {
        this.subClasses = subClasses;
    }


    public Boolean getAbstract() {
        return isAbstract;
    }

    public void setAbstract(Boolean anAbstract) {
        isAbstract = anAbstract;
    }

    @Override
    public boolean supportMerge(JavaGrammar other) {
        return className.equals(other.getClassName());
    }

    @Override
    public JavaGrammar merge(JavaGrammar other) {
        JavaGrammar javaGrammar = new JavaGrammar();

        return javaGrammar;
    }


    @Override
    public String getCode() {
        return null;
    }
}
