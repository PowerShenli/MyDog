package org.huangpu.mydog.core;

/**
 * Created by shenli on 2017/6/1.
 */
public class OutputItemDef {

    private String itemName;
    private String metaInstanceName;
    private GenDef genDef;
    private PreDef preDef;


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public GenDef getGenDef() {
        return genDef;
    }

    public void setGenDef(GenDef genDef) {
        this.genDef = genDef;
    }

    public PreDef getPreDef() {
        return preDef;
    }

    public void setPreDef(PreDef preDef) {
        this.preDef = preDef;
    }

    public String getMetaInstanceName() {
        return metaInstanceName;
    }

    public void setMetaInstanceName(String metaInstanceName) {
        this.metaInstanceName = metaInstanceName;
    }

    @Override
    public String toString() {
        return "OutputItemDef{" +
                "itemName='" + itemName + '\'' +
                ", metaInstanceName='" + metaInstanceName + '\'' +
                ", genDef=" + genDef +
                ", preDef=" + preDef +
                '}';
    }
}
