package org.huangpu.mydog.core.grammar;

/**
 * Created by shenli on 2017/4/13.
 */
public interface Mergeable<T> {

    boolean supportMerge(T other);

    T merge(T other);

}
