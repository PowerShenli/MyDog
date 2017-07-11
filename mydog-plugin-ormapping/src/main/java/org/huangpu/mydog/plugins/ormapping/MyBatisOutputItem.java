package org.huangpu.mydog.plugins.ormapping;

import org.huangpu.mydog.core.OutputItem;


/**
 * Created by shenli on 2017/5/25.
 */
public class MyBatisOutputItem extends OutputItem {

    private MyBatisGeneratorConfig context;

    public MyBatisGeneratorConfig getConfig() {
        return context;
    }

    public void setContext(MyBatisGeneratorConfig config) {
        this.context = config;
    }

    public MyBatisPreserver getMyBatisPreserver(){
        return new MyBatisPreserver();
    }
}
