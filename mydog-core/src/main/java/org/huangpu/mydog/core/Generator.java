package org.huangpu.mydog.core;

/**
 * Created by shenli on 2017/6/1.
 */
public interface Generator {

    OutputItem generate(Metadata metaInstance, OutputItemDef outputItemDef);

}
