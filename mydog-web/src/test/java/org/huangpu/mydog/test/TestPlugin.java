package org.huangpu.mydog.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.huangpu.mydog.core.MyDogPlugin;
import org.huangpu.mydog.core.OutputDef;
import org.huangpu.mydog.core.OutputItemDef;
import org.huangpu.mydog.core.plugins.GenerateContext;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shenli on 2017/6/11.
 */
public class TestPlugin {

    @Test
    public void testProjectPlugin(){
        MyDogPlugin project = GenerateContext.getPluginByMetadataType("project");
        JSONObject pro = JSON.parseObject(
                "{\n" +
                "        \"name\":\"MyDog测试项目\",\n" +
                "        \"springBootVersion\": \"1.4.2.RELEASE\",\n" +
                "        \"project\": {\n" +
                "          \"groupId\": \"com.power.test\",\n" +
                "          \"artifactId\": \"MyDogPrj\",\n" +
                "          \"version\": \"1.0.0-SNAPSHOT\"\n" +
                "        },\n" +
                "        \"basePath\": \"com/power/test/project\",\n" +
                "        \"outputPath\": \"/tmp/myDog1/output/\",\n" +
                "        \"basePackage\": \"com.power.test.project\",\n" +
                "        \"appProp\":{\n" +
                "          \"server.port\":\"8082\",\n" +
                "          \"logging.config\":\"classpath:logback.xml\"\n" +
                "        }\n" +
                "      }");

        Map<String,Map<String,JSONObject>> propMap = GenerateContext.get("props");
        Map<String,JSONObject> map = new HashMap<>();
        propMap.put("project", map);
        map.put("mydogProj", pro);

        OutputDef outputDef = project.getOutputDef();
        outputDef.getInstanceDefMap().entrySet().stream().forEach(e -> {
            String key = e.getKey();
            List<OutputItemDef> value = e.getValue();
            System.out.println("key = " + key);
            System.out.println("value = " + value.size());
        });
    }

    @Test
    public void testDatasourcePlugin(){
        MyDogPlugin project = GenerateContext.getPluginByMetadataType("datasource");
        JSONObject pro = JSON.parseObject(
                "{\n" +
        "        \"connectionProps\": {\n" +
        "          \"datasourceName\":\"default\",\n" +
        "          \"spring.datasource.url\":\"jdbc:mysql://localhost:3306/springlesson9?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false\",\n" +
        "          \"spring.datasource.username\":\"root\",\n" +
        "          \"spring.datasource.password\":\"\",\n" +
        "          \"spring.datasource.driver-class-name\":\"com.mysql.jdbc.Driver\",\n" +
        "          \"spring.datasource.test-on-borrow\": \"false\",\n" +
        "          \"spring.datasource.max-wait-millis\": \"30000\",\n" +
        "          \"spring.datasource.max-idle\": \"20\",\n" +
        "          \"spring.datasource.min-evictable-idle-time-millis\": \"600000\",\n" +
        "          \"spring.datasource.min-idle\": \"5\",\n" +
        "          \"spring.datasource.test-on-return\": \"false\",\n" +
        "          \"spring.datasource.time-between-eviction-runs-millis\": \"180000\",\n" +
        "          \"spring.datasource.initial-size\": \"10\",\n" +
        "          \"spring.datasource.test-while-idle\": \"true\",\n" +
        "          \"spring.datasource.validation-query\": \"SELECT 1\"\n" +
        "        }\n" +
        "      }");

        Map<String,Map<String,JSONObject>> propMap = GenerateContext.get("props");
        Map<String,JSONObject> map = new HashMap<>();
        propMap.put("datasource", map);
        map.put("tomcatDatasource", pro);

        OutputDef outputDef = project.getOutputDef();
        outputDef.getInstanceDefMap().entrySet().stream().forEach(e -> {
            String key = e.getKey();
            List<OutputItemDef> value = e.getValue();
            System.out.println("key = " + key);
            System.out.println("value = " + value.size());
        });
    }

    @Test
    public void testEntityPlugin(){
        testProjectPlugin();
        MyDogPlugin project = GenerateContext.getPluginByMetadataType("entity");
        JSONObject pro = JSON.parseObject(
        "       {\n" +
        "        \"entityName\": \"User\",\n" +
        "        \"label\":\"用户\",\n" +
        "        \"id\":{\n" +
        "          \"fieldName\":\"id\",\n" +
        "          \"fieldType\":\"Integer\",\n" +
        "          \"generate\":\"increment\"\n" +
        "        },\n" +
        "        \"idType\":\"Integer\",\n" +
        "        \"packageName\": \"org.huangpu.mydog.demo\",\n" +
        "        \"fields\": [\n" +
        "          {\n" +
        "            \"fieldName\": \"username\",\n" +
        "            \"label\":\"用户名\",\n" +
        "            \"isId\": false,\n" +
        "            \"validates\": [\n" +
        "              \"@Size(min = 6,max = 18)\",\n" +
        "              \"@NotNull\",\n" +
        "              \"@Pattern(regexp = \\\"^[A-Za-z0-9]+$\\\")\"\n" +
        "            ],\n" +
        "            \"fieldType\": \"String\",\n" +
        "            \"length\":\"10\",\n" +
        "            \"null\":false,\n" +
        "            \"viewProp\":{\n" +
        "              \"type\":\"text\"\n" +
        "            }\n" +
        "          },\n" +
        "          {\n" +
        "            \"fieldName\": \"password\",\n" +
        "            \"label\":\"密码\",\n" +
        "            \"isId\": false,\n" +
        "            \"fieldType\": \"String\",\n" +
        "            \"length\":50,\n" +
        "            \"null\":false,\n" +
        "            \"validates\":[\n" +
        "              \"@NotNull\",\n" +
        "              \"@Size(min =6, max=18)\",\n" +
        "              \"@Pattern(regexp=\\\"^[A-Za-z0-9]+$\\\")\"\n" +
        "            ],\n" +
        "            \"viewProp\":{\n" +
        "              \"type\":\"password\"\n" +
        "            }\n" +
        "          },\n" +
        "          {\n" +
        "            \"fieldName\": \"id\",\n" +
        "            \"label\":\"用户id\",\n" +
        "            \"fieldType\": \"Integer\",\n" +
        "            \"isId\": true,\n" +
        "            \"length\":11,\n" +
        "            \"null\": true,\n" +
        "            \"validates\":[\n" +
        "\n" +
        "            ],\n" +
        "            \"viewProp\":{\n" +
        "              \"type\":\"hidden\"\n" +
        "            }\n" +
        "          },\n" +
        "          {\n" +
        "            \"fieldName\": \"age\",\n" +
        "            \"label\":\"年龄\",\n" +
        "            \"fieldType\": \"Integer\",\n" +
        "            \"isId\": false,\n" +
        "            \"length\": 3,\n" +
        "            \"null\": false,\n" +
        "            \"validates\":[\n" +
        "              \"@NotNull\",\n" +
        "              \"@DecimalMax(value = \\\"99\\\")\",\n" +
        "              \"@DecimalMin(value = \\\"18\\\")\"\n" +
        "            ],\n" +
        "            \"viewProp\":{\n" +
        "              \"type\":\"number\"\n" +
        "            }\n" +
        "          },\n" +
        "          {\n" +
        "            \"fieldName\": \"email\",\n" +
        "            \"label\":\"邮箱\",\n" +
        "            \"fieldType\": \"String\",\n" +
        "            \"isId\": false,\n" +
        "            \"length\": 50,\n" +
        "            \"null\": false,\n" +
        "            \"validates\":[\n" +
        "              \"@NotNull\",\n" +
        "              \"@Pattern(regexp=\\\"^\\\\\\\\s*\\\\\\\\w+(?:\\\\\\\\.{0,1}[\\\\\\\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\\\\\\\.[a-zA-Z]+\\\\\\\\s*$\\\")\"\n" +
        "            ],\n" +
        "            \"viewProp\":{\n" +
        "              \"type\":\"text\"\n" +
        "            }\n" +
        "          }\n" +
        "        ],\n" +
        "        \"query\":{\n" +
        "          \"alias\":[\"User,u\",\"Role,r\",\"UserRole,ur\"],\n" +
        "          \"item\":[\n" +
        "            {\n" +
        "              \"u.username\":\"like\"\n" +
        "            },{\n" +
        "              \"u.age\":\"between\"\n" +
        "            },{\n" +
        "              \"u.email\":\"\"\n" +
        "            }\n" +
        "          ],\n" +
        "          \"innerJoin\":[\n" +
        "            {\n" +
        "              \"on\":\"u.id,ur.uid\",\n" +
        "              \"item\":[]\n" +
        "            },\n" +
        "            {\n" +
        "              \"on\":\"ur.rid,r.id\",\n" +
        "              \"item\":[\n" +
        "                {\"r.name\":\"distinct:select\"}\n" +
        "              ]\n" +
        "            }\n" +
        "          ]\n" +
        "        }\n" +
        "      }");

        Map<String,Map<String,JSONObject>> propMap = GenerateContext.get("props");
        Map<String,JSONObject> map = new HashMap<>();
        propMap.put("entity", map);
        map.put("User", pro);

        OutputDef outputDef = project.getOutputDef();
        outputDef.getInstanceDefMap().entrySet().stream().forEach(e -> {
            String key = e.getKey();
            List<OutputItemDef> value = e.getValue();
            System.out.println("key = " + key);
            System.out.println("value = " + value.size());
        });
    }

    @Test
    public void testEntityUIPlugin(){
        testEntityPlugin();
        MyDogPlugin entityui = GenerateContext.getPluginByMetadataType("entityui");
        JSONObject pro = JSON.parseObject("{}");

        Map<String,Map<String,JSONObject>> propMap = GenerateContext.get("props");
        Map<String,JSONObject> map = new HashMap<>();
        propMap.put("entityui", map);
        map.put("bootstrap+jquery", pro);

        OutputDef outputDef = entityui.getOutputDef();
        outputDef.getInstanceDefMap().entrySet().stream().forEach(e -> {
            String key = e.getKey();
            List<OutputItemDef> value = e.getValue();
            System.out.println("key = " + key);
            System.out.println("value = " + value.size());
        });
    }

}
