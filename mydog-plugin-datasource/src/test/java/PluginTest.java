import org.huangpu.mydog.core.MyDogPlugin;
import org.huangpu.mydog.core.plugins.SPIUtils;
import org.junit.Test;

import java.util.List;

/**
 * Created by shenli on 2017/6/12.
 */
public class PluginTest {

    @Test
    public void test(){
        List<Object> objects = SPIUtils.loadList(MyDogPlugin.class);
        System.out.println("objects = " + objects);
    }
}
