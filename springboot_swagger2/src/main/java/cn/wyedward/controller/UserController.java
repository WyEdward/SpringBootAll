package cn.wyedward.controller;

import cn.wyedward.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "用户controller")
@Controller
@RequestMapping("user")
public class UserController {
    @ApiIgnore
    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @ApiOperation(value = "获取用户信息", notes = "根据用户id获取用户信息")
    @GetMapping("/{id}")
    @ResponseBody
    public User getUserById(@PathVariable(value = "id") Long id){
        User user = new User();
        user.setId(id);
        user.setName("wyedward");
        user.setAge(22);
        return user;
    }
    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @GetMapping("/list")
    @ResponseBody
    public List<User> getUserList(){
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setId(1l);
        user1.setName("wyedward");
        user1.setAge(22);
        User user2 = new User();
        user2.setId(2l);
        user2.setName("scott");
        user2.setAge(21);
        list.add(user1);
        list.add(user2);
        return list;
    }

    @ApiOperation(value = "新增用户", notes = "根据用户实体创建用户")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> addUser(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        map.put("result","success");
        return map;
    }

    @ApiOperation(value = "删除用户", notes = "根据用户id删除用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    @ResponseBody
    public Map<String, Object> addUser(@PathVariable(value = "id") Long id){
        Map<String, Object> map = new HashMap<>();
        map.put("result","success");
        return map;
    }


    @ApiOperation(value = "更新用户", notes = "根据用户id删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User"),
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path")
    })
    @PutMapping("/{id}")
    @ResponseBody
    public Map<String, Object> updateUser(@PathVariable(value = "id") Long id, @RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        map.put("result","success");
        return map;
    }
}
