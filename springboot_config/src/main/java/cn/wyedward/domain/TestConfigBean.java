package cn.wyedward.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 注解@PropertySource("classpath:test.properties")指明了使用哪个配置文件。
 * 要使用该配置Bean，同样也需要在入口类里
 * 使用注解@EnableConfigurationProperties({TestConfigBean.class})来启用该配置。
 */
@Configuration
@ConfigurationProperties(prefix = "test")
@PropertySource("classpath:test.properties")
@Component
public class TestConfigBean {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestConfigBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
