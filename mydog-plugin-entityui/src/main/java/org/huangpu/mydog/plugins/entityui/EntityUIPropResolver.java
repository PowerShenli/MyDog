package org.huangpu.mydog.plugins.entityui;

import org.huangpu.mydog.core.MetaDataPropResolver;
import org.huangpu.mydog.core.Metadata;
import org.huangpu.mydog.core.plugins.GenerateContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by shenli on 2017/6/14.
 */
public class EntityUIPropResolver implements MetaDataPropResolver {

    private static final Logger LOG = LoggerFactory.getLogger(EntityUIPropResolver.class);

    @Override
    public void resolve() {
        Map<String,List<Metadata>> metaMap = GenerateContext.get("metadataMapList");
        List<Metadata> entityMetaList = metaMap.get("entity");
        List<Metadata> entityUIMetaList = metaMap.get("entityui");
        List<Metadata> nUiMetaList = new ArrayList<>();
        nUiMetaList.addAll(entityMetaList);
        nUiMetaList.addAll(entityUIMetaList);
        metaMap.put("entityui", nUiMetaList);
    }
}
