package com.xc.takeaway.utils;

import java.io.Serializable;

public class Order implements Serializable {
    public String order_id;
    public String shop_num;
    public String order_time;
    public String total_price;
    public String pay_state;
    public String food_info;
    public String extra_info;
    public String shop_name;
    public String location;
    public String user_name;
    public String confirm_state;
    public String shop_img;

    public String accept_state;

    public String getAccept_state() {
        return accept_state;
    }

    public void setAccept_state(String accept_state) {
        this.accept_state = accept_state;
    }

    public String getShop_img() {
        return shop_img;
    }

    public void setShop_img(String shop_img) {
        this.shop_img = shop_img;
    }

    public String getConfirm_state() {
        return confirm_state;
    }

    public void setConfirm_state(String confirm_state) {
        this.confirm_state = confirm_state;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getShop_num() {
        return shop_num;
    }

    public void setShop_num(String shop_num) {
        this.shop_num = shop_num;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getPay_state() {
        return pay_state;
    }

    public void setPay_state(String pay_state) {
        this.pay_state = pay_state;
    }

    public String getFood_info() {
        return food_info;
    }

    public void setFood_info(String food_info) {
        this.food_info = food_info;
    }

    public String getExtra_info() {
        return extra_info;
    }

    public void setExtra_info(String extra_info) {
        this.extra_info = extra_info;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", shop_num='" + shop_num + '\'' +
                ", order_time='" + order_time + '\'' +
                ", total_price='" + total_price + '\'' +
                ", pay_state='" + pay_state + '\'' +
                ", food_info='" + food_info + '\'' +
                ", extra_info='" + extra_info + '\'' +
                ", shop_name='" + shop_name + '\'' +
                ", location='" + location + '\'' +
                ", user_name='" + user_name + '\'' +
                ", confirm_state='" + confirm_state + '\'' +
                ", shop_img='" + shop_img + '\'' +
                ", accept_state='" + accept_state + '\'' +
                '}';
    }
}
