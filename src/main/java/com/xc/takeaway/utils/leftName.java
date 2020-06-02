package com.xc.takeaway.utils;

import java.io.Serializable;

public class leftName implements Serializable {
    public String id;
    public String name;
    public String shop_num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShop_num() {
        return shop_num;
    }

    public void setShop_num(String shop_num) {
        this.shop_num = shop_num;
    }

    @Override
    public String toString() {
        return "leftName{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", shop_num='" + shop_num + '\'' +
                '}';
    }
}
