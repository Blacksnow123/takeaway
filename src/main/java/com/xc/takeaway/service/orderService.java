package com.xc.takeaway.service;

import com.xc.takeaway.reponsitory.OrderReponsitory;
import com.xc.takeaway.utils.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderService {
    @Autowired
    OrderReponsitory orderReponsitory;

    public Integer insertOrder(Order order){
        return  orderReponsitory.insertOrder(order);
    }

    public List<Order> selectObject(Order order){
        return orderReponsitory.selectObject(order);
    }

    public List<Order> selectOrders(){
        return orderReponsitory.selectOrders();
    }

    public Integer updateOrder(Order order){
        return orderReponsitory.updateOrder(order);
    }

    public List<Order> shoperOrders(Order order){
        return orderReponsitory.shoperOrders(order);
    }

    public Integer acceptOrder(Order order){
        return orderReponsitory.acceptOrder(order);
    }
}
