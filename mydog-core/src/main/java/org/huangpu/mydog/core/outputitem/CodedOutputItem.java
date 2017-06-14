package org.huangpu.mydog.core.outputitem;

import org.huangpu.mydog.core.OutputItem;
import org.huangpu.mydog.core.Preserver;

/**
 * Created by shenli on 2017/6/2.
 */
public class CodedOutputItem extends OutputItem {

    private Preserver preserver;

    public Preserver getPreserver() {
        return preserver;
    }

    public void setPreserver(Preserver preserver) {
        this.preserver = preserver;
    }
}
