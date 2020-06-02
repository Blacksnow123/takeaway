package com.xc.takeaway.utils;

import java.io.Serializable;

public class Food implements Serializable {
    public  String sell_count;
    public String food_id;
    public String food_name;
    public String shop_num;
    public String food_img;
    public String food_price;
    public String shop_name;
    public String food_extra;
    public String left_name_id;
    public String count;

    public String shop_place;
    public String taste_score;
    public String left_name;

    public String delete_flag;

    public String getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(String delete_flag) {
        this.delete_flag = delete_flag;
    }

    public String getShop_place() {
        return shop_place;
    }

    public void setShop_place(String shop_place) {
        this.shop_place = shop_place;
    }

    public String getTaste_score() {
        return taste_score;
    }

    public void setTaste_score(String taste_score) {
        this.taste_score = taste_score;
    }

    public String getLeft_name() {
        return left_name;
    }

    public void setLeft_name(String left_name) {
        this.left_name = left_name;
    }

    public String getSell_count() {
        return sell_count;
    }

    public void setSell_count(String sell_count) {
        this.sell_count = sell_count;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getId() {
        return sell_count;
    }

    public void setId(String id) {
        this.sell_count = id;
    }

    public String getFood_id() {
        return food_id;
    }

    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getShop_num() {
        return shop_num;
    }

    public void setShop_num(String shop_num) {
        this.shop_num = shop_num;
    }

    public String getFood_img() {
        return food_img;
    }

    public void setFood_img(String food_img) {
        this.food_img = food_img;
    }

    public String getFood_price() {
        return food_price;
    }

    public void setFood_price(String food_price) {
        this.food_price = food_price;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getFood_extra() {
        return food_extra;
    }

    public void setFood_extra(String food_extra) {
        this.food_extra = food_extra;
    }

    public String getLeft_name_id() {
        return left_name_id;
    }

    public void setLeft_name_id(String left_name_id) {
        this.left_name_id = left_name_id;
    }

    @Override
    public String toString() {
        return "Food{" +
                "sell_count='" + sell_count + '\'' +
                ", food_id='" + food_id + '\'' +
                ", food_name='" + food_name + '\'' +
                ", shop_num='" + shop_num + '\'' +
                ", food_img='" + food_img + '\'' +
                ", food_price='" + food_price + '\'' +
                ", shop_name='" + shop_name + '\'' +
                ", food_extra='" + food_extra + '\'' +
                ", left_name_id='" + left_name_id + '\'' +
                ", count='" + count + '\'' +
                ", shop_place='" + shop_place + '\'' +
                ", taste_score='" + taste_score + '\'' +
                ", left_name='" + left_name + '\'' +
                ", delete_flag='" + delete_flag + '\'' +
                '}';
    }
}
