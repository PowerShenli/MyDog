package org.huangpu.mydog.core;

import org.huangpu.mydog.core.enums.GenType;
import org.huangpu.mydog.core.generator.*;

/**
 * Created by shenli on 2017/6/5.
 */
public class TypeGeneratorFactory {

    public static Generator makeGenerator(GenType genType) {
        switch(genType){
            case byTemplate:
                return new ByTemplateGenerator();
            case byGrammar:
                return new ByGrammarGenerator();
            case byCopy:
                return new ByCopyGenerator();
            case byCode:
                return new ByCodedGenerator();
            default:
                return new ByNullGenerator();
        }
    }


}
