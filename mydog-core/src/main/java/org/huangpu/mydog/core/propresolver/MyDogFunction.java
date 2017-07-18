package org.huangpu.mydog.core.propresolver;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.huangpu.mydog.core.*;
import org.huangpu.mydog.core.enums.GenType;
import org.huangpu.mydog.core.enums.OutputFormat;
import org.huangpu.mydog.core.grammar.GrammarFactory;
import org.huangpu.mydog.core.plugins.GenerateContext;
import org.huangpu.mydog.core.utils.TemplateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiFunction;

/**
 * Created by shenli on 2017/6/2.
 */
public class MyDogFunction {

    private static final Logger LOG = LoggerFactory.getLogger(MyDogFunction.class);

    public static final BiFunction<String,ClassLoader,JSONObject> getDepFunc = (type,loader)->
         readConfigFileContent(type, "dependency", loader);


    public static OutputDef renderOutputDef(String type,ClassLoader classLoader){

        OutputDef outputDef = new OutputDef();

        String source = readConfigFile(type, "output", classLoader);
        Map<String, Object> props = GenerateContext.get("props");
        Objects.requireNonNull(props);
        source = TemplateUtils.render(type + "_output_def", source, props);
//        LOG.info("A source==>{}",source);
//        LOG.info("props = {}" , props);
        JSONObject jo = JSON.parseObject(source);

        JSONObject outItemsDef = jo.getJSONObject("outItemsDef");
        List<OutputItemDef> commons = new ArrayList<>();
        Map<String, List<OutputItemDef>> instanceMap = new HashMap<>();
        outItemsDef.entrySet().stream().forEach(entry -> {
            String key = entry.getKey();
//            LOG.info("key={}", key);
            JSONArray itemDefJsons = (JSONArray)entry.getValue();
            List<OutputItemDef> itemDef = parseOutputItemDef(itemDefJsons, classLoader);
//            LOG.info("itemDef={}",itemDef);
            if(key.equals("Common")){
                commons.addAll(itemDef);
            }
            else{
                if (!instanceMap.containsKey(key)) {
                    List<OutputItemDef> itemDefList = new ArrayList<OutputItemDef>();
                    instanceMap.put(key, itemDefList);
                }
                instanceMap.get(key).addAll(itemDef);
            }
        });

        outputDef.setCommList(commons);
        outputDef.setInstanceDefMap(instanceMap);

//        LOG.info("outputDef={},commons.size={},instanceMap.size={}",outputDef,outputDef.getCommList()==null?0:outputDef.getCommList().size(),outputDef.getInstanceDefMap()==null?0:outputDef.getInstanceDefMap().size());
        return outputDef;
    }

    private static List<OutputItemDef> parseOutputItemDef(JSONArray itemJsons, ClassLoader classLoader) {
        List<OutputItemDef> outputItemDefList = new ArrayList<>();
        itemJsons.forEach(entry ->{
            JSONObject itemJson = (JSONObject)entry;
            String itemName = itemJson.getString("itemName");
            String outputPath = itemJson.getString("outputPath");
            String genTypeStr = itemJson.getString("genType");
            String tmpFilePath = itemJson.getString("tmpFilePath");
            String cpFilePath = itemJson.getString("cpFilePath");
            String generator = itemJson.getString("generator");
            Boolean overwrite = itemJson.getBoolean("overwrite");

            OutputItemDef itemDef = new OutputItemDef();
            GenType genType = GenType.valueOf(genTypeStr);
            String outputTypeStr = itemName.split("[.]")[1];
            OutputFormat outputFormat = OutputFormat.valueOf(outputTypeStr.toUpperCase());

            Preconditions.checkNotNull(genType, "genType can not be null from genTypeStr [" + genTypeStr + "]");
            Preconditions.checkNotNull(outputFormat, "outputFormat can not be null from outputFormatStr [" + outputTypeStr + "]");


            itemDef.setItemName(itemName);
            GenDef genDef = new GenDef();
            genDef.setItemName(itemName);
            genDef.setGenType(genType);
            genDef.setGeneratorName(generator);
            genDef.setTemplateProp(GenerateContext.get("props"));
            if (genType.equals(GenType.byGrammar)) {
                Grammar grammar = GrammarFactory.buildGrammar(outputFormat);
                genDef.setGrammar(grammar);
            }
            if (tmpFilePath != null) {
                String templateStr = readFileContent(classLoader, tmpFilePath);
                genDef.setTemplateCtx(templateStr);
            }
            genDef.setOutputFormat(outputFormat);
            genDef.setOverwrite(overwrite == null ? false : overwrite);
            itemDef.setGenDef(genDef);

            PreDef preDef = new PreDef();
            preDef.setItemName(itemName);
            preDef.setCpFilePath(cpFilePath);
            preDef.setOutputPath(outputPath);
            itemDef.setPreDef(preDef);
            outputItemDefList.add(itemDef);
        });
        return outputItemDefList;
    }

    private static String readFileContent(ClassLoader classLoader, String path){
        InputStream input = classLoader.getResourceAsStream(path);
        StringBuilder ss = new StringBuilder();
        try(BufferedReader br=new BufferedReader(new InputStreamReader(input))){
            String s="";
            while((s=br.readLine())!=null){
                ss.append(s).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String source = ss.toString();
//        System.out.println("source = " + source);
        return source;
    }

    private static String readConfigFile(String type, String key, ClassLoader classLoader){
        String subPath = "templates/"+ type + "_"+key+"_def.json";
        return readFileContent(classLoader, subPath);
    }

    private static JSONObject readConfigFileContent(String type,String key,ClassLoader classLoader){
        String content = readConfigFile(type, key, classLoader);
        if (!Strings.isNullOrEmpty(content)) {
            return JSON.parseObject(content);
        }
        else {
            return new JSONObject();
        }
    }


}
