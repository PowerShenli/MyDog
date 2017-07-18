package org.huangpu.mydog.core.grammar;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.huangpu.mydog.core.Grammar;
import org.huangpu.mydog.core.plugins.GenerateContext;
import org.huangpu.mydog.core.utils.DDLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by shenli on 2017/5/3.
 */
public class DDLGrammar implements Grammar {

    private static final Logger LOG = LoggerFactory.getLogger(DDLGrammar.class);

    @Override
    public String getCode() {
        StringBuffer sb = new StringBuffer();

        Map<String,Map<String,JSONObject>> props = GenerateContext.get("props");
        Map<String,JSONObject> entityMap = props.get("entity");

        entityMap.entrySet().stream().forEach(e ->{
            JSONObject entity = e.getValue();
            String entityName = entity.getString("entityName");
            String tableName = DDLUtils.getTbName(entityName);
            sb.append("DROP TABLE IF EXISTS ").append(tableName).append(";\n");
            sb.append("CREATE TABLE ").append(tableName).append("(");

            JSONArray fields = entity.getJSONArray("fields");
            sb.append(fields.stream().map(obj -> {
                JSONObject field = (JSONObject)obj;
                StringBuilder ss = new StringBuilder();
                ss.append("`").append(DDLUtils.getColumnName(field.getString("fieldName"))).append("`");
                ss.append(" ").append(DDLUtils.getColumnType(field.getString("fieldType"), field.getInteger("length")));
//                LOG.info("field={}",field);
                if(!field.getBoolean("isNull")){
                    ss.append(" NOT NULL ");
                }
                if (field.getBoolean("isId")) {
                    if("Integer,Long".indexOf(field.getString("fieldType")) != -1){
                        ss.append(" AUTO_INCREMENT ");
                    }
                    ss.append(" PRIMARY KEY ");
                }

                return ss.toString();
            }).collect(Collectors.joining(",\n")));
            JSONArray uniques = entity.getJSONArray("unique");
            if (uniques != null) {
                sb.append(",\nUNIQUE KEY `").append(entityName).append("UniqueKey`").append(" (");
                sb.append(
                        uniques.stream().map(obj ->{
                        String fieldName = String.valueOf(obj);
                        return DDLUtils.getColumnName(fieldName);
                    }).collect(Collectors.joining(","))
                );
                sb.append(")\n");
            }
            sb.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");
        });
        return sb.toString();
    }


}
