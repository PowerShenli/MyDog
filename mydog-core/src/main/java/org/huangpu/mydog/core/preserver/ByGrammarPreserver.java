package org.huangpu.mydog.core.preserver;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.huangpu.mydog.core.Preserver;
import org.huangpu.mydog.core.enums.OutputFormat;
import org.huangpu.mydog.core.outputitem.GrammarOutputItem;
import org.huangpu.mydog.core.utils.SqlExecutor;
import org.huangpu.mydog.core.plugins.GenerateContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by shenli on 2017/4/22.
 */
public class ByGrammarPreserver implements Preserver<GrammarOutputItem> {

    private static final Logger LOG = LoggerFactory.getLogger(ByGrammarPreserver.class);

    @Override
    public void persistent(GrammarOutputItem outputItem) {
        OutputFormat outputFormat = outputItem.getOutputFormat();
        // 连接数据库执行SQL
        //if (outputFormat.equals(OutputFormat.SQL)) {
            String code = outputItem.getGrammar().getCode();

            Map<String, Map<String, JSONObject>> propMap = GenerateContext.get("props");
            JSONObject datasource = propMap.get("datasource").get("tomcatDatasource");
            JSONObject connectionProps = datasource.getJSONObject("connectionProps");

            int execute = SqlExecutor.execute(
                    connectionProps.getString("spring.datasource.url"),
                    connectionProps.getString("spring.datasource.username"),
                    connectionProps.getString("spring.datasource.password"),
                    code);

            LOG.debug("execute rows = " + execute);
        //} else {
        // 生成SQL文件
            File dest = new File(outputItem.getOutputPath() + outputItem.getOutputName());
            try {
                FileUtils.writeStringToFile(dest, outputItem.getOutputContent(), "UTF-8");
                LOG.debug("dest = " + dest.getAbsolutePath());
            } catch (IOException e) {
                LOG.error("writeStringToFile failed.", e);
            }
        //}

    }

}
