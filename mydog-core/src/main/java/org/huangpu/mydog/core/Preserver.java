package org.huangpu.mydog.core;

/**
 * Created by shenli on 2017/6/2.
 */
public interface Preserver<Item extends OutputItem>  {

    void persistent(Item outputItem);
}
