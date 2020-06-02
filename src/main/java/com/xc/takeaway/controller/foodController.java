package com.xc.takeaway.controller;

import com.xc.takeaway.WebAPIResult;
import com.xc.takeaway.service.foodService;
import com.xc.takeaway.service.shopService;
import com.xc.takeaway.service.userService;
import com.xc.takeaway.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.SybaseAnywhereMaxValueIncrementer;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Api("商铺")
public class foodController {

    @Autowired
    foodService foodService;

    @Autowired
    shopService shopService;

    @Autowired
    userService userService;

    @RequestMapping(value = "/shopList",method = RequestMethod.POST)
    @ApiOperation("获取商家列表")
    public WebAPIResult shopList(){
        WebAPIResult webAPIResult=new WebAPIResult();
        List<Shop> list =foodService.shopList();
        System.out.println("商家列表");
        System.out.println(list);
        webAPIResult.setResult(0);
        webAPIResult.setData(list);
        return webAPIResult;
    }

    @RequestMapping(value = "/foodList",method = RequestMethod.POST)
    @ApiOperation("获取菜品列表")
    public WebAPIResult List(
            @RequestBody Food food
    ){
        WebAPIResult webAPIResult=new WebAPIResult();
//        System.out.println(food);

        List<Map<String,Object>> list=new ArrayList<>();

        leftName leftName =new leftName();
        foodComment foodComment=new foodComment();

        leftName.setShop_num(food.shop_num);
        List<leftName> leftNameList =foodService.leftName(leftName);
        System.out.println(leftNameList);

        for(int i=0;i<leftNameList.size();i++){
            Map<String,Object> map =new HashMap<>();
            String a=leftNameList.get(i).id;
            food.setLeft_name_id(a);
//            System.out.println(leftNameList.get(i).name);
            List<Food> foodList =foodService.foodList(food);
//            System.out.println(foodList);
            map.put("name",leftNameList.get(i).name);
            map.put("foodList",foodList);
            System.out.println(map);
            list.add(map);
        }
        System.out.println(list);
        webAPIResult.setResult(0);
        webAPIResult.setData(list);
        return webAPIResult;
    }

    @RequestMapping(value = "/foodComment",method = RequestMethod.POST)
    @ApiOperation("获取食物评论")
    public WebAPIResult foodComment(
            @RequestBody foodComment foodComment
    ){
        WebAPIResult webAPIResult=new WebAPIResult();
        System.out.println(foodComment);
        List<foodComment> list =foodService.foodComment(foodComment);
        System.out.println(list);
        webAPIResult.setResult(0);
        webAPIResult.setData(list);
        return webAPIResult;
    }

    @RequestMapping(value = "/shopComment",method = RequestMethod.POST)
    @ApiOperation("获取商家评论")
    public WebAPIResult shopComment(
            @RequestBody shopComment shopComment
    ){
        WebAPIResult webAPIResult=new WebAPIResult();
        List<shopComment> list =foodService.shopComment(shopComment);
        System.out.println(list);
        webAPIResult.setData(list);
        webAPIResult.setResult(0);
        return webAPIResult;
    }

    @RequestMapping(value = "/shopInfo",method = RequestMethod.POST)
    @ApiOperation("获取商家信息")
    public WebAPIResult shop(
            @RequestBody Shop shop
    ){
        WebAPIResult webAPIResult=new WebAPIResult();
        List<Shop> list =foodService.shopInfo(shop);
        System.out.println(list);
        webAPIResult.setData(list);
        webAPIResult.setResult(0);
        return webAPIResult;
    }

    @RequestMapping(value = "/updateShop",method = RequestMethod.POST)
    @ApiOperation("更新商家信息")
    public WebAPIResult updateShop(
            @RequestBody Shop shop
    ){
        System.out.println(shop);
        WebAPIResult webAPIResult=new WebAPIResult();

        int a=shopService.updateShop(shop);
        System.out.println(a);

        webAPIResult.setResult(0);
        webAPIResult.setData(a);

        return webAPIResult;
    }

    @RequestMapping(value = "/deleteShop",method = RequestMethod.POST)
    @ApiOperation("删除商家信息")
    public WebAPIResult deleteShop(
            @RequestBody Shop shop
    ){
        System.out.println(shop);
        WebAPIResult webAPIResult=new WebAPIResult();

        int a=shopService.deleteShop(shop);
        System.out.println(a);

        Food food=new Food();
        food.setShop_num(shop.shop_num);
        int b =foodService.shopFooddelete(food);
        System.out.println(b);

        if(a!=0&&b!=0){
            webAPIResult.setResult(0);
            webAPIResult.setData(a);
        }else{
            webAPIResult.setResult(1);
            webAPIResult.setMessage("删除出错");
        }
        return webAPIResult;
    }

    @RequestMapping(value = "/allFoods",method = RequestMethod.POST)
    @ApiOperation("获取所有食品")
    public WebAPIResult allFoods(){
        WebAPIResult webAPIResult=new WebAPIResult();

        List<Food> list=foodService.allFoods();
        System.out.println(list);

        webAPIResult.setResult(0);
        webAPIResult.setData(list);

        return webAPIResult;
    }

    @RequestMapping(value = "/shopFoodlist",method = RequestMethod.POST)
    @ApiOperation("获取本店所有食品")
    public WebAPIResult shopFoodlist(
            @RequestBody Food food
    ){
        WebAPIResult webAPIResult=new WebAPIResult();
//        System.out.println(food);
        List<Food> list=foodService.shopFoodlist(food);
//        System.out.println(list);

        webAPIResult.setResult(0);
        webAPIResult.setData(list);

        return webAPIResult;
    }

    @RequestMapping(value = "/updateFood",method = RequestMethod.POST)
    @ApiOperation("更新食品")
    public WebAPIResult updateFood(
            @RequestBody Food food
    ){
        WebAPIResult webAPIResult=new WebAPIResult();

        System.out.println(food);
        int a=foodService.updateFood(food);
        System.out.println(a);

        webAPIResult.setResult(0);
        webAPIResult.setData(a);

        return webAPIResult;
    }

    @RequestMapping(value = "/deleteFood",method = RequestMethod.POST)
    @ApiOperation("删除食品")
    public WebAPIResult deleteFood(
            @RequestBody Food food
    ){
        WebAPIResult webAPIResult=new WebAPIResult();

        food.setDelete_flag("1");
        System.out.println(food);
        int a=foodService.deleteFood(food);
        System.out.println(a);

        webAPIResult.setResult(0);
        webAPIResult.setData(a);

        return webAPIResult;
    }

    @RequestMapping(value = "/insertShop",method = RequestMethod.POST)
    @ApiOperation("添加商家")
    public WebAPIResult insertShop(
            @RequestBody Shop shop
    ){
        WebAPIResult webAPIResult=new WebAPIResult();


        String id;
        UUID uuid = UUID.randomUUID();
        id = uuid.toString();
        id = id.replace("-", "");
        int num = id.hashCode();
        num = num < 0 ? -num : num;
        id = String.valueOf(num);

        Random random=new Random();
        int distance =random.nextInt(20);
        int send_time=random.nextInt(60);

        String shop_num;
        UUID uuid1 = UUID.randomUUID();
        shop_num = uuid1.toString();
        shop_num = shop_num.replace("-", "");
        int a = id.hashCode();
        a = a < 0 ? -a : a;
        shop_num = String.valueOf(a);

        shop.setId(id);
        shop.setDistance(distance+"km");
        shop.setSend_time(send_time+"分钟");
        shop.setShop_num(shop_num);

        int b=shopService.insertShop(shop);

        webAPIResult.setResult(0);
        webAPIResult.setData(b);

        return webAPIResult;
    }



    @RequestMapping(value = "/insertSelfshop",method = RequestMethod.POST)
    @ApiOperation("商家自我添加")
    public WebAPIResult insertSelfshop(
            @RequestBody Shop shop
    ){
        WebAPIResult webAPIResult=new WebAPIResult();

        String myshop=shop.shop_num;
        System.out.println(myshop);



        String id;
        UUID uuid = UUID.randomUUID();
        id = uuid.toString();
        id = id.replace("-", "");
        int num = id.hashCode();
        num = num < 0 ? -num : num;
        id = String.valueOf(num);

        Random random=new Random();
        int distance =random.nextInt(20);
        int send_time=random.nextInt(60);

        String shop_num;
        UUID uuid1 = UUID.randomUUID();
        shop_num = uuid1.toString();
        shop_num = shop_num.replace("-", "");
        int a = id.hashCode();
        a = a < 0 ? -a : a;
        shop_num = String.valueOf(a);

        shop.setId(id);
        shop.setDistance(distance+"km");
        shop.setSend_time(send_time+"分钟");
        shop.setShop_num(shop_num);


        User user=new User();
        user.setId(myshop);
        user.setShop_num(shop_num);
        int result=userService.updateSelfshop(user);
        System.out.println(result);

        int b=shopService.insertSelfshop(shop);
        System.out.println(b);
        webAPIResult.setResult(0);
        webAPIResult.setCause(shop_num);
        webAPIResult.setData(b);

        return webAPIResult;
    }

    @RequestMapping(value = "/insertFood",method = RequestMethod.POST)
    @ApiOperation("添加食物")
    public WebAPIResult insertFood(
            @RequestBody Food food
    ){
        WebAPIResult webAPIResult=new WebAPIResult();


        String id;
        UUID uuid = UUID.randomUUID();
        id = uuid.toString();
        id = id.replace("-", "");
        int num = id.hashCode();
        num = num < 0 ? -num : num;
        id = String.valueOf(num);

        food.setFood_id(id);

        System.out.println(food);
        int a=foodService.insertFood(food);

        webAPIResult.setResult(0);
        webAPIResult.setData(a);

        return webAPIResult;
    }

    @RequestMapping(value = "/shopTypelist",method = RequestMethod.POST)
    @ApiOperation("根据商家评分排序获取商家列表")
    public WebAPIResult shopTypelist(
            @RequestBody Shop shop
    ){
        WebAPIResult webAPIResult=new WebAPIResult();
        List<Shop> list =shopService.shopTypelist(shop);
        System.out.println("商家列表");
        System.out.println(list);
        webAPIResult.setResult(0);
        webAPIResult.setData(list);
        return webAPIResult;
    }

    @RequestMapping(value = "/byAverage",method = RequestMethod.POST)
    @ApiOperation("根据平均排序获取商家列表")
    public WebAPIResult byAverage(
            @RequestBody Shop shop
    ){
        WebAPIResult webAPIResult=new WebAPIResult();
        List<Shop> list =shopService.byAverage(shop);
        System.out.println("商家列表");
        System.out.println(list);
        webAPIResult.setResult(0);
        webAPIResult.setData(list);
        return webAPIResult;
    }

    @RequestMapping(value = "/byDistance",method = RequestMethod.POST)
    @ApiOperation("根据距离排序获取商家列表")
    public WebAPIResult byDistance(
            @RequestBody Shop shop
    ){
        WebAPIResult webAPIResult=new WebAPIResult();
        List<Shop> list =shopService.byDistance(shop);
        System.out.println("商家列表");
        System.out.println(list);
        webAPIResult.setResult(0);
        webAPIResult.setData(list);
        return webAPIResult;
    }

    @RequestMapping(value = "/shopFilter",method = RequestMethod.POST)
    @ApiOperation("获取商家列表")
    public WebAPIResult shopFilter(
            @RequestBody Shop shop
    ){
        WebAPIResult webAPIResult=new WebAPIResult();
        System.out.println(shop);
        List<Shop> list =foodService.shopFilter(shop);
        System.out.println("商家模糊搜索");
        System.out.println(list);
        webAPIResult.setResult(0);
        webAPIResult.setData(list);
        return webAPIResult;
    }
}
