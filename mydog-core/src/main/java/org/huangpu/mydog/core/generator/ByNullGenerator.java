package org.huangpu.mydog.core.generator;

import org.huangpu.mydog.core.Generator;
import org.huangpu.mydog.core.Metadata;
import org.huangpu.mydog.core.OutputItem;
import org.huangpu.mydog.core.OutputItemDef;

/**
 * Created by shenli on 2017/6/2.
 */
public class ByNullGenerator implements Generator {

    @Override
    public OutputItem generate(Metadata metaInstance, OutputItemDef outputItemDef) {
        System.out.println("ByNullGenerator.generate");
        return null;
    }
}
