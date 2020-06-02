package com.xc.takeaway.service;

import com.xc.takeaway.reponsitory.FoodReponsitory;
import com.xc.takeaway.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class foodService {
    @Autowired
    FoodReponsitory foodReponsitory;

    //商家列表
    public List<Shop> shopList(){
        return foodReponsitory.shopList();
    }

    //菜列表
    public List<Food> foodList( Food food){
        return foodReponsitory.foodList(food);
    }

    //商家左侧列表
    public List<leftName> leftName(leftName leftName){
        return  foodReponsitory.leftName(leftName);
    }

    //菜品评论
    public List<foodComment> foodComment(foodComment foodComment){
        return foodReponsitory.foodComment(foodComment);
    }

    //商家评论
    public List<shopComment> shopComment(shopComment shopComment) {
        return foodReponsitory.shopComment(shopComment);
    }

    //商家信息
    public List<Shop> shopInfo(Shop shop) {
        return foodReponsitory.shopInfo(shop);
    }

    public List<Food> allFoods(){
        return foodReponsitory.allFoods();
    }

    public Integer updateFood(Food food){
       return foodReponsitory.updateFood(food);
    }

    public Integer deleteFood(Food food){
        return foodReponsitory.deleteFood(food);
    }

    public Integer insertFood(Food food){
        return  foodReponsitory.insertFood(food);
    }

    public List<Food> shopFoodlist(Food food){
        return foodReponsitory.shopFoodlist(food);
    }

    public List<Shop> shopFilter(Shop shop){
        return foodReponsitory.shopFilter(shop);
    }

    public Integer shopFooddelete(Food food){
        return foodReponsitory.shopFooddelete(food);
    }
}
