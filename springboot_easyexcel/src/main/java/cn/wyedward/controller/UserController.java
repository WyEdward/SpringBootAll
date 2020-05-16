package cn.wyedward.controller;

import cn.wyedward.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/a")
    @ResponseBody
    public List<User> getAllUser(){
        List<User> userList = new ArrayList<>();
        for (int i=0;i<100;i++){
            User user = User.builder().name("张三"+ i).password("1234").age(i).build();
            userList.add(user);
        }
        return userList;
    }

}