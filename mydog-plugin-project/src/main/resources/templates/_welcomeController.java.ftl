<#assign prj=project["mydogProj"]/>

package ${prj["basePackage"]}.ctrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/")
public class WelcomeController{

    @RequestMapping(value = "/")
    @ResponseBody
    public String index() {
        System.out.println("WelcomeController.index");
        return "<h1>welcome! </h1>"+
                "<p><h2>this is MyDog default page.</h2>";
    }

}