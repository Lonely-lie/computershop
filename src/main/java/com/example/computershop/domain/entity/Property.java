package com.example.computershop.domain.entity;

import java.time.LocalDateTime;

public class Property {
    private Integer id;
    private Integer pro_type_id;
    private String name;
    private LocalDateTime updateTime =LocalDateTime.now();
    private LocalDateTime createTime =LocalDateTime.now();
    private boolean isDelete;

    public Property() {
    }

    public Property(Integer id, Integer pro_type_id, String name, LocalDateTime updateTime, LocalDateTime createTime, boolean isDelete) {
        this.id = id;
        this.pro_type_id = pro_type_id;
        this.name = name;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPro_type_id() {
        return pro_type_id;
    }

    public void setPro_type_id(Integer pro_type_id) {
        this.pro_type_id = pro_type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", pro_type_id=" + pro_type_id +
                ", name='" + name + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", isDelete=" + isDelete +
                '}';
    }
}
