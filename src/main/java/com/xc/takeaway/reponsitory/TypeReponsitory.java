package com.xc.takeaway.reponsitory;

import com.xc.takeaway.utils.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeReponsitory {

    public List<Type> typeList();
}
