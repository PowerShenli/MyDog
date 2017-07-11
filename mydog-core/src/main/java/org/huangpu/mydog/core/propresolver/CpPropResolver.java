package org.huangpu.mydog.core.propresolver;

import org.huangpu.mydog.core.MetaDataPropResolver;
import org.huangpu.mydog.core.Metadata;
import org.huangpu.mydog.core.plugins.GenerateContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by shenli on 2017/7/11.
 */
public class CpPropResolver implements MetaDataPropResolver {

    private String copyFrom;
    private String copyTo;

    public CpPropResolver(String copyFrom,String copyTo){
        this.copyFrom = copyFrom;
        this.copyTo = copyTo;
    }

    @Override
    public void resolve() {
        Map<String,List<Metadata>> metaMap = GenerateContext.get("metadataMapList");
        List<Metadata> entityMetaList = metaMap.get(copyFrom);
        List<Metadata> entityUIMetaList = metaMap.get(copyTo);
        List<Metadata> nUiMetaList = new ArrayList<>();
        nUiMetaList.addAll(entityMetaList);
        nUiMetaList.addAll(entityUIMetaList);
        metaMap.put(copyTo, nUiMetaList);
    }
}
