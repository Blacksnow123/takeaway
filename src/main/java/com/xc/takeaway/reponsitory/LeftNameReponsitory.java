package com.xc.takeaway.reponsitory;

import com.xc.takeaway.utils.leftName;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LeftNameReponsitory {

    public List<leftName> leftNames (leftName leftName);
    public Integer insertName(leftName leftName);
}
