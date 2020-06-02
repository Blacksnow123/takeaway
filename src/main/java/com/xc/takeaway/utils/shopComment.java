package com.xc.takeaway.utils;

import java.io.Serializable;

public class shopComment implements Serializable {
    public String id;
    public String shop_num;
    public String user_name;
    public String comment_time;
    public String content;
    public String title;

    public String pack_score;
    public String taste_score;
    public String shop_score;
    public String send_score;

    public String getPack_score() {
        return pack_score;
    }

    public void setPack_score(String pack_score) {
        this.pack_score = pack_score;
    }

    public String getTaste_score() {
        return taste_score;
    }

    public void setTaste_score(String taste_score) {
        this.taste_score = taste_score;
    }

    public String getShop_score() {
        return shop_score;
    }

    public void setShop_score(String shop_score) {
        this.shop_score = shop_score;
    }

    public String getSend_score() {
        return send_score;
    }

    public void setSend_score(String send_score) {
        this.send_score = send_score;
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

    public void setShop_num(String shop_num) {
        this.shop_num = shop_num;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "shopComment{" +
                "id='" + id + '\'' +
                ", shop_num='" + shop_num + '\'' +
                ", user_name='" + user_name + '\'' +
                ", comment_time='" + comment_time + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", pack_store='" + pack_score + '\'' +
                ", taste_score='" + taste_score + '\'' +
                ", shop_score='" + shop_score + '\'' +
                ", send_score='" + send_score + '\'' +
                '}';
    }
}
