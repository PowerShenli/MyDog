package org.huangpu.mydog.core.plugins;

import com.alibaba.fastjson.JSONObject;
import org.huangpu.mydog.core.MyDogPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by shenli on 2017/4/1.
 */
public class GenerateContext {

    private static final Logger LOG = LoggerFactory.getLogger(GenerateContext.class);
    private static Map<String, MyDogPlugin> pluginMap = new HashMap<>();

    /**
     * genPropMap 是用来merge 属性的
     * 所有插件共享,可改变,单个线程的生命周期
     *
     */
    private static ThreadLocal<Map<String,Object>> genPropMap = new ThreadLocal<Map<String,Object>>(){
        @Override
        protected Map<String, Object> initialValue() {
            Map<String,Object> map = new HashMap<>();
            map.put("props",new HashMap<String,Object>());
            return map;
        }
    };

    public static Map<String, MyDogPlugin> getPluginMap(){
    	return pluginMap;
    }

    public static <T> T get(String key){
        return (T)genPropMap.get().get(key);
    }

    public static Object put(String key, Object v){
        return genPropMap.get().put(key,v);
    }

    public static void putProp(String key , JSONObject value){
        Map<String,Object> propMap = get("props");
        propMap.put(key, value);
    }

    public static void clear(){
        genPropMap.get().clear();
        genPropMap.set(null);
    }

    public static void mergeProp(String key,Object o){
        Map<String,Object> propMap = (Map<String, Object>) genPropMap.get().get("props");
        if(propMap.containsKey(key)){
            Object v = propMap.get(key);
            //如果key对应的值,是集合类型,合并新的集合到老的集合中
            if(v instanceof Collection){
                Collection parentCollection = (Collection)v;
                if(o instanceof Collection){
                    parentCollection.addAll((Collection)o);
                }
                else{
                    parentCollection.add(o);
                }
            }
            //如果key对应的值,是map,合并新的map中的值,到老的map中
            else if(v instanceof Map){
                Map parentM = (Map)v;
                Object parentMv = parentM.values().iterator().next();
                if(o instanceof Map){
                    Map<String,Object> subM =(Map<String,Object>)o;
                    subM.entrySet().forEach(e -> {
                        if(parentM.containsKey(e.getKey())){
                            Object subMapv = e.getValue();
                            if(parentMv instanceof Collection){
                                Collection parentColl = (Collection)parentM.get(e.getKey());
                                if(subMapv instanceof Collection){
                                    parentColl.addAll((Collection)subMapv);
                                }
                                else {
                                    parentColl.add(subMapv);
                                }
                            }
                            else{
                                LOG.warn("Key={},value={},parent.value=Map, parent.map.value(not Collection) = {}",key,o,parentMv);
                            }
                        }
                        else{
                            parentM.put(e.getKey(), e.getValue());
                        }
                    });
                }
            }
        }
        else{
            propMap.put(key,o);
        }
    }

    static{
        init();
    }

    public static void init(){
        LOG.info("init");
        List<MyDogPlugin> objects = SPIUtils.loadList(MyDogPlugin.class);
        LOG.info("plugins.size="+objects.size());
        for (MyDogPlugin plugin : objects) {
            Objects.requireNonNull(plugin);
            if(plugin!= null && plugin.getMetadataType() != null) {
                plugin.init();
                pluginMap.put(plugin.getMetadataType(), plugin);
                LOG.debug("put {} => {}",plugin.getMetadataType(), plugin);
            }
        }
    }

    public static MyDogPlugin getPluginByMetadataType(String metadataType) {
        return pluginMap.get(metadataType);
    }


    /**
     * //TODO: 新的设计是不在将依赖的属性添加到自己的属性中,而是将所有属性放入ThreadLocal,按需要获取.
     * 添加依赖
     *
     *//*
    public static void addDependencies(List<MyDogPlugin> pluginList) {
        pluginList.stream().forEach(plugin -> {

            JSONObject depends = plugin.getDependencyProps();
            String hasName = depends.getString("pluginName");
            MyDogPlugin sPlugin = pluginMap.get(hasName);

            Objects.requireNonNull(sPlugin);

            depends.getJSONArray("dependency").forEach(o ->{
                JSONObject item = (JSONObject)o;
                String targetPluginName = item.getString("meta");
                JSONArray propNameArray = item.getJSONArray("props");

                MyDogPlugin tPlugin = pluginMap.get(targetPluginName);

                Objects.requireNonNull(sPlugin);

                propNameArray.forEach(o2 ->{
                    String propName = (String)o2;
                    //将依赖的插件的属性,copy到自己的属性中
                    Object v = tPlugin.getMetadata().getPropertyMap().get(propName);
                    sPlugin.getMetadata().getPropertyMap().put(propName, v);
                    if(sPlugin.getMetadataType().equals("entity")){
                        LOG.info("put prop {} = {}", propName, v);
                    }
                });

            });

        });
    }*/

}
