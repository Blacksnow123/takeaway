package com.xc.takeaway.reponsitory;

import com.xc.takeaway.utils.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface FoodReponsitory {
    List<Shop> shopList ();
    List<Food> foodList(Food food);
    List<foodComment> foodComment(foodComment foodComment);

    List<leftName> leftName(leftName leftName);

    List<shopComment> shopComment(shopComment shopComment);

    List<Shop> shopInfo(Shop shop);

    List<Food> allFoods();

    Integer updateFood(Food food);

    Integer deleteFood(Food food);

    Integer insertFood(Food food);

    List<Food> shopFoodlist(Food food);

    List<Shop> shopFilter(Shop shop);

    Integer shopFooddelete(Food food);
}
