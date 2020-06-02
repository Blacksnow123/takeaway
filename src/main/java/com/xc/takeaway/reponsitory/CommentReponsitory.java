package com.xc.takeaway.reponsitory;

import com.xc.takeaway.utils.shopComment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CommentReponsitory {

    public Integer insertComment(shopComment shopComment);
}
