package org.huangpu.mydog.core;

/**
 * Created by shenli on 2017/6/5.
 */
public abstract class GeneratorDecorator implements Generator {

    protected Generator generator;

    public GeneratorDecorator(Generator generator) {
        this.generator = generator;
    }
}
