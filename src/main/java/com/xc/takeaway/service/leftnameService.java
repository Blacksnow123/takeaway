package com.xc.takeaway.service;

import com.xc.takeaway.reponsitory.LeftNameReponsitory;
import com.xc.takeaway.utils.leftName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class leftnameService {

    @Autowired
    LeftNameReponsitory leftNameReponsitory;

    public List<leftName> leftNames (leftName leftName){
        return leftNameReponsitory.leftNames(leftName);
    }

    public Integer insertName(leftName leftName){
        return leftNameReponsitory.insertName(leftName);
    }
}
