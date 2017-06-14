package org.huangpu.mydog.core.preserver;


import org.huangpu.mydog.core.Preserver;
import org.huangpu.mydog.core.enums.GenType;

/**
 * Created by shenli on 2017/4/22.
 */
public class PreserverFactory {

    public static Preserver makePreserver(GenType genType) {
        System.out.println("genType = " + genType);
        switch (genType) {
            case byCopy:
                return new ByCopyPreserver();
            case byGrammar:
                return new ByGrammarPreserver();
            case byTemplate:
                return new ByTemplatedPreserver();
            case byCode:
                return new ByCodePreserver();
            default:
                return null;
        }
    }
}
