package cn.wyedward.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity //声明实体类，和数据表映射
@Table(name="jpaTest") //指定对应数据表，省略的话默认表名为类名小写
public class JpaTest implements Serializable{
    private static final long serialVersionUID = 6480254097793678525L;
    @Id //声明为该表主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键自增策略
    private int id;
    @Column(name = "jpa_name",length = 50) //设置列名及长度
    private String jpaName;
    @Column(name = "last_name",length = 50) //设置列名及长度
    private String lastName;

    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJpaName() {
        return jpaName;
    }

    public void setJpaName(String jpaName) {
        this.jpaName = jpaName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "JpaTest{" +
                "id=" + id +
                ", jpaName='" + jpaName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
