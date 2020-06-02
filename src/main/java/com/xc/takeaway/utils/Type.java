package com.xc.takeaway.utils;

import java.io.Serializable;

public class Type implements Serializable {

    public String id;
    public String type_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    @Override
    public String toString() {
        return "shop_type{" +
                "id='" + id + '\'' +
                ", type_name='" + type_name + '\'' +
                '}';
    }
}
