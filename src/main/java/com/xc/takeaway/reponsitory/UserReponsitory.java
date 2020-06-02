package com.xc.takeaway.reponsitory;

import com.xc.takeaway.utils.Shop;
import com.xc.takeaway.utils.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserReponsitory {

    Integer userCheck (User user);
    Integer userRegister(User user);
    List<User> adminCheck (User user);
    Integer userCount();
    Integer adminCount();

    public List<User> allUsers(User user);


    public List<Shop> allshops(User user);

    Integer shoperRegister(User user);
    public Integer updateSelfshop(User user);

    Integer reset (User user);
}
