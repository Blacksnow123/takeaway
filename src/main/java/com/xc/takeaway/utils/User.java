package com.xc.takeaway.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

public class User implements Serializable {
    public String id;
    public String user_name;
    public String user_password;
    public int delete_flag;
    public int role_flag;
    public String email;
    public String shop_num;
    public String shop_name;
    public String shop_type;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShop_num() {
        return shop_num;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_type() {
        return shop_type;
    }

    public void setShop_type(String shop_type) {
        this.shop_type = shop_type;
    }

    public void setShop_num(String shop_num) {
        this.shop_num = shop_num;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(int delete_flag) {
        this.delete_flag = delete_flag;
    }

    public int getRole_flag() {
        return role_flag;
    }

    public void setRole_flag(int role_flag) {
        this.role_flag = role_flag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", delete_flag=" + delete_flag +
                ", role_flag=" + role_flag +
                ", email='" + email + '\'' +
                ", shop_num='" + shop_num + '\'' +
                ", shop_name='" + shop_name + '\'' +
                ", shop_type='" + shop_type + '\'' +
                '}';
    }
}
