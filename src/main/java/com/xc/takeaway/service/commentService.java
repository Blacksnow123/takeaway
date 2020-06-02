package com.xc.takeaway.service;

import com.xc.takeaway.reponsitory.CommentReponsitory;
import com.xc.takeaway.utils.shopComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class commentService {
    @Autowired
    CommentReponsitory commentReponsitory;

    public Integer insertComment(shopComment shopComment){
        return commentReponsitory.insertComment(shopComment);
    }
}
