package cn.wyedward.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/*自动加载application.application中定义的字段*/
@ConfigurationProperties(prefix = "wyedward.blog")
public class ConfigBean {
    private String name;

    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BlogProperties{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
