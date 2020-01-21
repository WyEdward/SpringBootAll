package cn.wyedward.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*手动加载application.application中定义的字段*/
@Component
public class BlogProperties {
    @Value("${wyedward.blog.name}")
    private String name;

    @Value("${wyedward.blog.title}")
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
