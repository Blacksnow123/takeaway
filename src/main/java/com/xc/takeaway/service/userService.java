package com.xc.takeaway.service;

import com.xc.takeaway.reponsitory.UserReponsitory;
import com.xc.takeaway.utils.Shop;
import com.xc.takeaway.utils.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class userService {

    @Autowired
    UserReponsitory userReponsitory;
    //登录验证
    public Integer userCheck(User user){
       return userReponsitory.userCheck(user);
    }
    //用户注册
    public Integer userRegister(User user){
        return userReponsitory.userRegister(user);
    }

    public List<User> adminCheck (User user){
        return userReponsitory.adminCheck(user);
    }

    public Integer userCount(){
        return userReponsitory.userCount();
    }
    public Integer adminCount(){
        return userReponsitory.adminCount();
    }

    public List<User> allUsers(User user){
        return userReponsitory.allUsers(user);
    }

    public List<Shop> allshops(User user){
        return userReponsitory.allshops(user);
    }

    public Integer shoperRegister(User user){
        return userReponsitory.shoperRegister(user);
    }

    public Integer updateSelfshop(User user){
        return userReponsitory.updateSelfshop(user);
    }
    public Integer reset (User user){
        return userReponsitory.reset(user);
    }
}
