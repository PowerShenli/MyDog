package org.huangpu.mydog.core.utils;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * Created by shenli on 2016/11/19.
 */
public class TemplateUtils {

    private static final Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
    private static final StringTemplateLoader stringLoader = new StringTemplateLoader();
    private static final Logger LOG = LoggerFactory.getLogger(TemplateUtils.class);

    static{
        cfg.setTemplateLoader(stringLoader);
    }

    public static String render(String tmpKey, String tmpCtx, Map<String, Object> param) {
        Object templateSource = stringLoader.findTemplateSource(tmpKey);
        if(templateSource == null){
            stringLoader.putTemplate(tmpKey, tmpCtx);
//            LOG.debug("put tmp key = " + tmpKey + ", value = " + tmpCtx);
        }
        String rst = "";
        try {
            Template temp = cfg.getTemplate(tmpKey,"UTF-8");
            temp.setOutputEncoding("UTF-8");
            StringWriter out = new StringWriter(2048);

            temp.process(param, out);
            rst = out.toString();
            out.flush();

        }catch (IOException| TemplateException e) {
            LOG.error("process templage failed",e);
        }
        return rst;

    }

}
