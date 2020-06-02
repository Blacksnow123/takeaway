package com.xc.takeaway.reponsitory;


import com.xc.takeaway.utils.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderReponsitory {
    public Integer insertOrder(Order order);
    public List<Order> selectObject(Order order);
    public List<Order> selectOrders();

    public Integer updateOrder(Order order);

    public List<Order> shoperOrders(Order order);

    public Integer acceptOrder(Order order);
}
