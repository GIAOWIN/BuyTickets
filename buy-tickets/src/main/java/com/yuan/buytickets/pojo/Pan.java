package com.yuan.buytickets.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 网盘类
 *
 * @author Yuan-9826
 */
@Table(name = "pan")
public class Pan {
    /**
     * ID无意义
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    /**
     * 网盘路径
     */
    String url;
    /**
     * 网盘密码
     */
    String password;
    /**
     * 描述
     */
    String describe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Pan{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", password='" + password + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
