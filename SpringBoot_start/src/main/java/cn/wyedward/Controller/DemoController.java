package cn.wyedward.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
@ResponseBody
    使用此注解之后不会再走视图处理器，而是直接将数据写到输入流中
 */
@Controller
public class DemoController {
    @RequestMapping("/index")
    @ResponseBody
    String index(){
        return "hello SpringBoot";
    }
}
