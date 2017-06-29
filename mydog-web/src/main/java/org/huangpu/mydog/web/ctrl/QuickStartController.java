package org.huangpu.mydog.web.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shenli on 2017/6/15.
 */
@Controller
@RequestMapping(value = "/QuickStart")
public class QuickStartController {

    public String index(){
        return "quick_start";
    }
    
    
    
}
