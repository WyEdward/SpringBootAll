package cn.wyedward.domain;

import java.io.Serializable;

public class Permission implements Serializable {
    private static final long serialVersionUID = 7160557680614732403L;
    private int id;
    private String url; //url地址
    private String name; //url描述

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
