package cn.wyedward.Controller;

import cn.wyedward.domain.BlogProperties;
import cn.wyedward.domain.ConfigBean;
import cn.wyedward.domain.TestConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private BlogProperties blogProperties;
    @Autowired
    private ConfigBean configBean;
    @Autowired
    private TestConfigBean testConfigBean;
    @RequestMapping("/index")
    String index(){
        return blogProperties.getName()+"--"+blogProperties.getTitle()+":"
                +configBean.getName()+"--"+configBean.getTitle()+":"
                +testConfigBean.getName()+"--"+testConfigBean.getAge();
    }
}
