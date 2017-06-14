/**
 * Created by shenli on 2017/6/7.
 */
public class TestInstead {

    public void test(){
        //        //替换itemName 中的变量
//        String itemName = outputItemDef.getGenDef().getItemName();
//        StringBuilder ss = new StringBuilder();
//        String eName = metaInstance.getProp().getString("entityName");
//        ss.append("itemName=").append(itemName);
//        String entityName = metaInstance.getName();
//        itemName = itemName.replaceAll("[$]\\{entityName\\}",entityName);
//        ss.append("=>itemName=").append(itemName);
//        ss.append("\nent.name=").append(entityName).append(",ent.prop.entityName=").append(eName);
//        LOG.info(ss.toString());
//        outputItemDef.setItemName(itemName);
//
//
//        //替换outputPath 中的变量
//        Map<String,Map<String,JSONObject>> propMap = GenerateContext.get("props");
//        JSONObject project = propMap.get("project").get("mydogProj");
//        String outputPath1 = project.getString("outputPath");
//        String basePath = project.getString("basePath");
//        String outputPath2 = outputItemDef.getPreDef().getOutputPath();
//        outputPath2 = outputPath2.replaceAll("[$]\\{basePath\\}", basePath);
//        outputItemDef.getPreDef().setOutputPath(outputPath1 + outputPath2);

    }
}
