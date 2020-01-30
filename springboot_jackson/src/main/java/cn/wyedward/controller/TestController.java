package cn.wyedward.controller;

import cn.wyedward.domain.User;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    ObjectMapper mapper;
    //@JsonView(User.UserNameView.class)
    //@JsonView(User.AllUserFieldView.class)
    @RequestMapping("/getuser")
    @ResponseBody
    public User getUser(){
        User user = new User();
        user.setUserName("wyedward");
        user.setBirthday(new Date());
        return user;
    }
    
    /*序列化 - 将java对象序列化为Json格式的字符串*/
    /*主要使用ObjectMapper中的 writeValueAsString方法*/
    @RequestMapping("/serialization")
    @ResponseBody
    public String serialization(){
        try {
            User user = new User();
            user.setUserName("wyedward");
            user.setBirthday(new Date());
            String str = mapper.writeValueAsString(user);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*反序列化  使json格式的字符串反序列化为java对象*/
    /*主要使用ObjectMapper中的 readTree方法*/
    @RequestMapping("/readjsonstring")
    @ResponseBody
    public String readJsonString(){
        try {
            String json = "{\"name\":\"wyedward\",\"age\":26}";
            JsonNode node = mapper.readTree(json);
            String name = node.get("name").asText();
            int age = node.get("age").asInt();
            return name + " " + age;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /*反序列化多级json格式字符村*/
    @RequestMapping("/readjsonstring2")
    @ResponseBody
    public String readJsonstring2(){
        try {
            String json = "{\"name\":\"wyedward\",\"hobby\":{\"first\":\"sleep\",\"secong\":\"eat\"}}";
            JsonNode node = mapper.readTree(json);
            JsonNode hobby = node.get("hobby");
            String first = hobby.get("first").asText();
            return first;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*绑定对象  --可以将java对象和Json数据进行绑定*/
    /*主要使用ObjectMapper中的 readValue方法*/
    @RequestMapping("/readjsonasObject")
    @ResponseBody
    public String readJsonAsObject(){
        try {
            String json = "{\"userName\":\"wyedward\",\"age\":26}";
            User user = mapper.readValue(json, User.class);
            String name = user.getUserName();
            int age = user.getAge();
            return name + " " + age;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*集合的反序列化  1、直接使用RequeestBody 将json格式映射到集合对象中*/
    //Spring Boot 能自动识别出List对象包含的是User类，因为在方法中定义的泛型的类型会被保留在字节码中
    @RequestMapping("/updateuser")
    @ResponseBody
    public int updateUser(@RequestBody List<User> list){
        return list.size();
    }

    /*
    * 这是因为在运行时刻，泛型己经被擦除了（不同于方法参数定义的泛型，不会被擦除）。
    * 为了提供泛型信息，Jackson提供了JavaType ，用来指明集合类型，
    * */
    @RequestMapping("/customize")
    @ResponseBody
    public String customize() throws JsonParseException, JsonMappingException, IOException {
        String jsonStr = "[{\"userName\":\"wyedward\",\"age\":26},{\"userName\":\"scott\",\"age\":27}]";
        JavaType type = mapper.getTypeFactory().constructParametricType(List.class, User.class);
        List<User> list = mapper.readValue(jsonStr, type);
        String msg = "";
        for (User user : list) {
            msg += user.getUserName();
        }
        return msg;
    }
}
