package com.xc.takeaway.service;

import com.xc.takeaway.reponsitory.ShopReponsitory;
import com.xc.takeaway.utils.Shop;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class shopService {
    @Autowired
    ShopReponsitory shopReponsitory;

    public List<Shop> shoplist(Shop shop){
        return shopReponsitory.shoplist(shop);
    }

    public Integer updateShop(Shop shop){
        return shopReponsitory.updateShop(shop);
    }

    public Integer deleteShop(Shop shop){
        return shopReponsitory.deleteShop(shop);
    }

    public Integer insertShop(Shop shop){
        return shopReponsitory.insertShop(shop);
    }

    public List<Shop> oneShop(Shop shop){
        return shopReponsitory.oneShop(shop);
    }

    public Integer updateScore(Shop shop){
        return  shopReponsitory.updateScore(shop);
    }

    public Integer insertSelfshop(Shop shop){
        return shopReponsitory.insertSelfshop(shop);
    }

    public Integer shopCount(Shop shop){
        return shopReponsitory.shopCount(shop);
    }

    public List<Shop> shopTypelist(Shop shop){
        return shopReponsitory.shopTypelist(shop);
    }
    public List<Shop> byAverage(Shop shop){
        return  shopReponsitory.byAverage(shop);
    }
    public List<Shop> byDistance(Shop shop){
        return shopReponsitory.byDistance(shop);
    }
}
