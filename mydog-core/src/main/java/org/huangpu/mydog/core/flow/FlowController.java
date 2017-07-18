package org.huangpu.mydog.core.flow;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.huangpu.mydog.core.*;
import org.huangpu.mydog.core.plugins.GenerateContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * Created by shenli on 2017/6/2.
 */
public class FlowController {

    private static final Logger LOG = LoggerFactory.getLogger(FlowController.class);

    public String check(String inputJson) {
        //check plugin dependency
        return "false|null";
    }

    @SuppressWarnings("unchecked")
	public String startGenerate(String inputJson){
        JSONObject json = JSON.parseObject(inputJson);

        //从输入解析元数据
        parseMetadata(json.getJSONArray("metadatas"));

        Map<String,List<Metadata>> metadataMapList = GenerateContext.get("metadataMapList");


        //合并元数据属性,这是为何应对新添加的插件对已有插件进行扩展的情况.
        transProps(metadataMapList);

        List<OutputItem> outputItemList = new ArrayList<OutputItem>();

        metadataMapList.entrySet().stream().forEach(entry -> {

            String type = entry.getKey();
//            if(!type.equals("ormapping")){
//                return;
//            }

            MyDogPlugin myDogPlugin = GenerateContext.getPluginByMetadataType(type);

            //1. 渲染输出定义,并进行分类(common,instance1,instance2 ...)
            OutputDef outputDef = myDogPlugin.getOutputDef();


            // 元数据通用输出定义列表
            List<OutputItemDef> commList = outputDef.getCommList();
            // 元数据实例输出定义列表
            Map<String, List<OutputItemDef>> instanceDefMap = outputDef.getInstanceDefMap();


            //2. 先生成元数据中通用部分对应的输出文件
            if(commList != null) {
                Metadata common = new Metadata();
                common.setType(type);
                common.setName(type+"Common");
                LOG.debug("{}.commList={}",common.getName(),commList);
                commList.forEach(def -> {
                    Generator generatorImpl = TypeGeneratorFactory.makeGenerator(def.getGenDef().getGenType());
                    LOG.debug("Common generatorImpl = " + generatorImpl);
                    //实例装饰器
                    LOG.debug("comm.name={},generator={}", common.getName(), generatorImpl);
                    OutputItem outputItem = generatorImpl.generate(common, def);
                    LOG.debug("outputItem={}", outputItem);
                    outputItemList.add(outputItem);
                });
            }


            //3. 再循环生成元数据中实例部分对应的输出文件
            List<Metadata> metadataList = entry.getValue();
            metadataList.stream().forEach(meta ->{
                String instanceName = meta.getName();

                //TODO: instance的方式对于非Entity元数据是否合理?
                LOG.debug("{}.instanceDefMap={}",meta.getName(),instanceDefMap);
                if(instanceDefMap != null) {
                    //通过instanceName取出对应的output定义
                    //TODO:EntityUI get(jquery+bootstrap)拿不到Entity的属性(除非get(User) get(Role))
                    List<OutputItemDef> itemDefList = instanceDefMap.get(instanceName);
                    if(itemDefList != null)
                    itemDefList.forEach(def ->{
                        Generator generatorImpl = TypeGeneratorFactory.makeGenerator(def.getGenDef().getGenType());
                        Generator decGenerator = GenerateContext.getPluginByMetadataType(meta.getType()).getGeneratorDecorator(generatorImpl);
                        outputItemList.add(decGenerator.generate(meta, def));
                    });
                }
            });

            LOG.debug("outputItemList={}",outputItemList);

            //持久化
            for (OutputItem out : outputItemList) {
                out.getPreserver().persistent(out);
            }

        });

        GenerateContext.clear();
        return "success";
    }

    private void transProps(Map<String, List<Metadata>> metadataMapList) {
        metadataMapList.entrySet().stream().forEach(e ->{
//            String type = e.getKey();
            List<Metadata> metadataList = e.getValue();
            metadataList.stream().forEach(meta -> {
                String metaName = meta.getName();
                LOG.debug("metaName = {}" , metaName);
                GenerateContext.getPluginByMetadataType(meta.getType()).getPropResolver().resolve();
            });
        });
    }

    private void parseMetadata(JSONArray metadataArray) {
        Map<String,List<Metadata>> metaMap =
            metadataArray.stream().map(obj -> {
                JSONObject metadataJson = (JSONObject)obj;
                return MetadataParser.parse(metadataJson);
            }).collect(groupingBy(Metadata::getType, toList()));

        GenerateContext.put("metadataMapList", metaMap);
    }
}
