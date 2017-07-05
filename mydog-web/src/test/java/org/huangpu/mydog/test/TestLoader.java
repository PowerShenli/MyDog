package org.huangpu.mydog.test;

import java.util.List;
import java.util.Map;

import org.huangpu.mydog.core.Metadata;
import org.huangpu.mydog.core.MyDogPlugin;
import org.huangpu.mydog.core.plugins.GenerateContext;
import org.huangpu.mydog.plugins.datasource.DatasourcePlugin;
import org.huangpu.mydog.plugins.entity.EntityPlugin;
import org.huangpu.mydog.plugins.entityui.EntityUIPlugin;
import org.huangpu.mydog.plugins.project.ProjectPlugin;
import org.junit.Test;

public class TestLoader {

	@Test
	public void test01() {
		Map<String,MyDogPlugin> mydogPluginMap = GenerateContext.getPluginMap();
		System.out.println(mydogPluginMap);
		mydogPluginMap.entrySet().stream().forEach(entry->{
			entry.getValue().init();
			System.out.println(entry.getKey());
			if(entry.getKey().equals("datasource"))
				System.out.println(((DatasourcePlugin)entry.getValue()).getDependencyProps());
			else if(entry.getKey().equals("entityui"))
				System.out.println(((EntityUIPlugin)entry.getValue()).getDependencyProps());
			else if(entry.getKey().equals("project"))
				System.out.println(((ProjectPlugin)entry.getValue()).getDependencyProps());
			else if(entry.getKey().equals("entity"))
				System.out.println(((EntityPlugin)entry.getValue()).getDependencyProps());
		});
		/*System.out.println(((DatasourcePlugin)GenerateContext.getPluginByMetadataType("datasource")).getDependencyProps());
	*/
	}
	
}
