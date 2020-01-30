package cn.wyedward.domain;

import cn.wyedward.config.UserDeserializer;
import cn.wyedward.config.UserSerializer;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;
//@JsonIgnoreProperties({ "password", "age" }) //忽略一组属性，作用于类上
//@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class) //指定一个命名策略
//@JsonSerialize(using = UserSerializer.class)
//@JsonDeserialize(using = UserDeserializer.class)
public class User implements Serializable{
    private static final long serialVersionUID = 6222176558369919436L;

    public interface UserNameView {};
    public interface AllUserFieldView extends UserNameView {};

    @JsonView(UserNameView.class)
    private String userName;
    @JsonView(AllUserFieldView.class)
    private int age;

    //@JsonIgnore   //忽略属性
    @JsonView(AllUserFieldView.class)
    private String password;

    //@JsonProperty("bth")  //输出的时候改名
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //用于日期格式化
    @JsonView(AllUserFieldView.class)
    private Date birthday;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
