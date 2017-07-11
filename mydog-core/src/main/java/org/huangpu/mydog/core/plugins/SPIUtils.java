package org.huangpu.mydog.core.plugins;


import org.huangpu.mydog.core.MyDogPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * Created by shenli on 2017/1/12.
 */
public class SPIUtils {

    private static final Logger LOG = LoggerFactory.getLogger(SPIUtils.class);

    public static <T> List<T> loadList(Class clazz) {
        ServiceLoader<T> serviceLoader = ServiceLoader.load(clazz);
        List<T> list = new ArrayList<>();
        for (T t : serviceLoader) {
            list.add(t);
        }
        return list;
    }

    public static <T> T loadFirst(Class clazz) {
        ServiceLoader<T> serviceLoader = ServiceLoader.load(clazz);
        return serviceLoader.iterator().next();
    }

    public static void main(String[] args) {
        List<Object> objects = loadList(MyDogPlugin.class);
        LOG.info("objects = " + objects);
        System.out.println("objects = " + objects);
        objects = loadList(MyDogPlugin.class);
        LOG.info("objects = " + objects);
        System.out.println("objects = " + objects);
    }

}
