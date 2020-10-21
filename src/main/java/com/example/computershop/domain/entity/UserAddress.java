package com.example.computershop.domain.entity;

import java.time.LocalDateTime;

public class UserAddress {

    private Integer id;   //收货信息ID

    private String cel_phone;   //联系电话
    private String contact_name;     //收货人姓名
    private String big_address;    //收货范围
    private String detail_address;    //具体地址

    private Integer user_id;    //外键uid，指向用户表id字段
    private boolean is_default;        //是否为默认地址

    private LocalDateTime updateTime =LocalDateTime.now();  //更新时间
    private LocalDateTime createTime =LocalDateTime.now();  //创建时间
    private boolean isDelete;                               //删除状态


    public UserAddress() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCel_phone() {
        return cel_phone;
    }

    public void setCel_phone(String cel_phone) {
        this.cel_phone = cel_phone;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getBig_address() {
        return big_address;
    }

    public void setBig_address(String big_address) {
        this.big_address = big_address;
    }

    public String getDetail_address() {
        return detail_address;
    }

    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public void setIs_default(boolean is_default) {
        this.is_default = is_default;
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

    public UserAddress(Integer id, String cel_phone, String contact_name, String big_address, String detail_address, Integer user_id, boolean is_default, LocalDateTime updateTime, LocalDateTime createTime, boolean isDelete) {
        this.id = id;
        this.cel_phone = cel_phone;
        this.contact_name = contact_name;
        this.big_address = big_address;
        this.detail_address = detail_address;
        this.user_id = user_id;
        this.is_default = is_default;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.isDelete = isDelete;
    }
}
