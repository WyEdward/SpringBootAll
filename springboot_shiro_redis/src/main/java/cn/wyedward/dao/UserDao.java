package cn.wyedward.dao;

import cn.wyedward.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    /*@Select("select * from user where username=#{username}")
    @Results(id = "user",value= {
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "username", column = "username", javaType = String.class),
            @Result(property = "password", column = "password", javaType = String.class),
            @Result(property = "createTime", column = "create_time", javaType = Date.class),
            @Result(property = "status", column = "status", javaType = String.class)
    })*/
    User findUserByName(String username);
}
