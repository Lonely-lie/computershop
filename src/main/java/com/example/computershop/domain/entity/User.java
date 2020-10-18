package com.example.computershop.domain.entity;

import java.time.LocalDateTime;

public class User {
    private Integer id; //用户ID
    private String name;//用户名称
    private String password;//用户密码
    private String img_url;//用户头像地址
    private boolean sex;//用户性别
    private String salt;
    private LocalDateTime updateTime =LocalDateTime.now();//创建时间
    private LocalDateTime createTime =LocalDateTime.now();//更新时间
    private boolean isDelete;//删除状态

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public User(Integer id, String name, String password, String img_url, boolean sex, String salt, LocalDateTime updateTime, LocalDateTime createTime, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.img_url = img_url;
        this.sex = sex;
        this.salt = salt;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.isDelete = isDelete;
    }
}
