package com.xc.takeaway.service;

import com.xc.takeaway.reponsitory.TypeReponsitory;
import com.xc.takeaway.utils.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class typeService {

    @Autowired
    TypeReponsitory typeReponsitory;

    public List<Type> typeList(){
        return  typeReponsitory.typeList();
    }
}
