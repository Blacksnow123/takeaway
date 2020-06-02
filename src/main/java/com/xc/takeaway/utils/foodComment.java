package com.xc.takeaway.utils;

import java.io.Serializable;

public class foodComment implements Serializable {

    public String id;
    public String food_id;
    public String user_name;
    public String comment_time;
    public String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFood_id() {
        return food_id;
    }

    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "foodComment{" +
                "id='" + id + '\'' +
                ", food_id='" + food_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", comment_time='" + comment_time + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
