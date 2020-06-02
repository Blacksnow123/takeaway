package com.xc.takeaway.utils;

import java.io.Serializable;

public class Shop implements Serializable {
    public String id;
    public String shop_score;
    public String taste_score;
    public String pack_score;
    public String shop_img;
    public String send_time;
    public String distance;
    public String sell_start;
    public String distribution_price;
    public String average;
    public String shop_num;
    public String send_score;
    public String shop_name;
    public String shop_type;
    public String shop_place;
    public String send_service;

    public String type_name;
    public String delete_flag;
    public String sell_count;

    public String getSell_count() {
        return sell_count;
    }

    public void setSell_count(String sell_count) {
        this.sell_count = sell_count;
    }

    public String getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(String delete_flag) {
        this.delete_flag = delete_flag;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getSend_service() {
        return send_service;
    }

    public void setSend_service(String send_service) {
        this.send_service = send_service;
    }

    public String getShop_place() {
        return shop_place;
    }

    public void setShop_place(String shop_place) {
        this.shop_place = shop_place;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShop_score() {
        return shop_score;
    }

    public void setShop_score(String shop_score) {
        this.shop_score = shop_score;
    }

    public String getTaste_score() {
        return taste_score;
    }

    public void setTaste_score(String taste_score) {
        this.taste_score = taste_score;
    }

    public String getPack_score() {
        return pack_score;
    }

    public void setPack_score(String pack_score) {
        this.pack_score = pack_score;
    }

    public String getShop_img() {
        return shop_img;
    }

    public void setShop_img(String shop_img) {
        this.shop_img = shop_img;
    }

    public String getSend_time() {
        return send_time;
    }

    public void setSend_time(String send_time) {
        this.send_time = send_time;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getSell_start() {
        return sell_start;
    }

    public void setSell_start(String sell_start) {
        this.sell_start = sell_start;
    }

    public String getDistribution_price() {
        return distribution_price;
    }

    public void setDistribution_price(String distribution_price) {
        this.distribution_price = distribution_price;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getShop_num() {
        return shop_num;
    }

    public void setShop_num(String shop_num) {
        this.shop_num = shop_num;
    }

    public String getSend_score() {
        return send_score;
    }

    public void setSend_score(String send_score) {
        this.send_score = send_score;
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

    @Override
    public String toString() {
        return "Shop{" +
                "id='" + id + '\'' +
                ", shop_score='" + shop_score + '\'' +
                ", taste_score='" + taste_score + '\'' +
                ", pack_score='" + pack_score + '\'' +
                ", shop_img='" + shop_img + '\'' +
                ", send_time='" + send_time + '\'' +
                ", distance='" + distance + '\'' +
                ", sell_start='" + sell_start + '\'' +
                ", distribution_price='" + distribution_price + '\'' +
                ", average='" + average + '\'' +
                ", shop_num='" + shop_num + '\'' +
                ", send_score='" + send_score + '\'' +
                ", shop_name='" + shop_name + '\'' +
                ", shop_type='" + shop_type + '\'' +
                ", shop_place='" + shop_place + '\'' +
                ", send_service='" + send_service + '\'' +
                ", type_name='" + type_name + '\'' +
                ", delete_flag='" + delete_flag + '\'' +
                ", sell_count='" + sell_count + '\'' +
                '}';
    }
}
