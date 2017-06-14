import org.huangpu.mydog.core.utils.DDLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shenli on 2017/6/7.
 */
public class TestDDLUtils {

    @Test
    public void test() {
        Assert.assertEquals(DDLUtils.package2Path("com.dj.bj"),"com/dj/bj");
        Assert.assertEquals(DDLUtils.getTbName("User"),"tbl1_user");
        Assert.assertEquals(DDLUtils.path2Package("aaa/bbb/ccc"),"aaa.bbb.ccc");
        Assert.assertEquals(DDLUtils.getColumnName("UserNameAndPassWord"),"user_name_and_pass_word");
        Assert.assertEquals(DDLUtils.getColumnName("idUserNameAndPassWord"),"id_user_name_and_pass_word");
    }
}
