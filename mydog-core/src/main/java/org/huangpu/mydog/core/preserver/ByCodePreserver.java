package org.huangpu.mydog.core.preserver;


import org.huangpu.mydog.core.Preserver;
import org.huangpu.mydog.core.outputitem.CodedOutputItem;

/**
 * Created by shenli on 2017/5/25.
 */
public class ByCodePreserver implements Preserver<CodedOutputItem> {


    @Override
    public void persistent(CodedOutputItem outputItem) {
        System.out.println("ByCodePreserver.persistent");

        outputItem.getPreserver().persistent(outputItem);
    }



}
