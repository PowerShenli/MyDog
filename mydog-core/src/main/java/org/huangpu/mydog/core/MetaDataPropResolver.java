package org.huangpu.mydog.core;

/**
 * Created by shenli on 2017/6/2.
 */
public interface MetaDataPropResolver {

    /**
     * 负责解析本插件的元数据,然后转换为其它插件的元数据
     * 最后合并到公共属性中,方便后续的生成
     *
     * 如果对其它插件没有影响,可以直接使用 EmptyMetaDataPropResolver
     */
    void resolve();
}
