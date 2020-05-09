package cn.wyedward.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    private Logger log = LoggerFactory.getLogger(this.getClass());


  /*  @GetMapping("/info")
    public String info(){
        @SuppressWarnings("deprecation")
        ServiceInstance instance = client.getLocalServiceInstance();
        String info = "host£º" + instance.getHost() + "£¬service_id£º" + instance.getServiceId();
        log.info(info);
        return info;
    }*/

    @GetMapping("/info")
    public String hello() {
        return "hello world";
    }


}