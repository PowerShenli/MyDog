package org.huangpu.mydog.core.generator;

import org.huangpu.mydog.core.Generator;
import org.huangpu.mydog.core.Metadata;
import org.huangpu.mydog.core.OutputItem;
import org.huangpu.mydog.core.OutputItemDef;

import java.util.Objects;

/**
 * Created by shenli on 2017/6/2.
 */
public class ByCodedGenerator implements Generator {

    @Override
    public OutputItem generate(Metadata metaInstance, OutputItemDef outputItemDef) {
        String generatorName = outputItemDef.getGenDef().getGeneratorName();
        Objects.requireNonNull(generatorName);

        Generator generator = null;
        try {
            generator = (Generator) Class.forName(generatorName).newInstance();
//            Constructor<Generator> constructor = (Constructor<Generator>) Class.forName(generatorName).getConstructor(OutputItemDef.class);
//            generator = constructor.newInstance(outputItemDef);
        } catch (ClassNotFoundException |InstantiationException |IllegalAccessException e) {
            e.printStackTrace();
        }
        Objects.requireNonNull(generator);

        return generator.generate(metaInstance, outputItemDef);
    }

}
