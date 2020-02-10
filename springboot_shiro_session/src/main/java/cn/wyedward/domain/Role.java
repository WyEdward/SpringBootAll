package cn.wyedward.domain;

import java.io.Serializable;

public class Role implements Serializable {
    private static final long serialVersionUID = -227437593919820521L;
    private int id;
    private String name; //角色名字
    private String memo; //角色描述

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
