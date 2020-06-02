package com.xc.takeaway.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xc.takeaway.WebAPIResult;
import com.xc.takeaway.service.orderService;
import com.xc.takeaway.service.shopService;
import com.xc.takeaway.utils.Food;
import com.xc.takeaway.utils.Order;
import com.xc.takeaway.utils.Shop;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@Api("订单接口")
public class orderController {
    @Autowired
    orderService orderService;
    @Autowired
    shopService shopService;

    @ApiOperation("插入订单")
    @RequestMapping(value = "/insertOrder",method = RequestMethod.POST)
    public WebAPIResult insertOrder(
            @RequestBody String foodList
            ){
        WebAPIResult webAPIResult=new WebAPIResult();

        System.out.println(foodList);
        int start=foodList.indexOf('[');
        int end=foodList.indexOf(']')+1;

        String a=foodList.substring(start,end);
        System.out.println(a);
        List<Food> list= JSONArray.toList(JSONArray.fromObject(a),Food.class);



//        System.out.println("list");
//        System.out.println(list);
        //随机id
        String id;
        UUID uuid = UUID.randomUUID();
        id = uuid.toString();
        id = id.replace("-", "");
        int num = id.hashCode();
        num = num < 0 ? -num : num;
        id = String.valueOf(num);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        String totalPrice="";
        //店铺id
        String shop_num=list.get(0).shop_num;
        String extraInfo="";
        //
        String b=foodList.substring(end+1);
//        int a=orderService.insertOrder();
        int infostart=b.indexOf(',');
        //备注信息
        extraInfo=b.substring(13,infostart-1);
//        System.out.println("111");
//        System.out.println(extraInfo);

        String c=b.substring(infostart+14);

        int priceend=c.indexOf(',');
        String a1=c.substring(0,priceend);

        totalPrice=a1;

//        System.out.println(totalPrice);

        String a2=c.substring(priceend+17);
        int location =a2.indexOf(",");
        String a4= a2.substring(0,location-1);
//        System.out.println(a4);


        int last=a2.indexOf('}');

        String a3=a2.substring(location+9,last-1);

        System.out.println(a3);

        Shop myshop =new Shop();
        myshop.setShop_num(shop_num);
        List<Shop> shopList= shopService.oneShop(myshop);
        int mysellcount =Integer.parseInt(shopList.get(0).getSell_count());
        String shop_img=shopList.get(0).shop_img;

        //更新平均
        int myaverage=Integer.parseInt(shopList.get(0).getAverage());
        int average1=Integer.parseInt(totalPrice)+myaverage/2;

        //更新销量
        int count=list.size()+mysellcount;
        System.out.println("count:");
        System.out.println(count);
        Shop shopCount =new Shop();
        shopCount.setShop_num(shop_num);
        shopCount.setSell_count(Integer.toString(count));
        shopCount.setAverage(Integer.toString(average1));
        int mycount=shopService.shopCount(shopCount);





        Order order=new Order();
        order.setOrder_id(id);
        order.setShop_num(shop_num);
        order.setOrder_time(df.format(new Date()));
        order.setTotal_price(totalPrice);
        order.setPay_state("0");
        order.setFood_info(a);
        order.setExtra_info(extraInfo);
        order.setLocation(a4);
        order.setUser_name(a3);
        order.setShop_img(shop_img);
        System.out.println(order);

        int result=orderService.insertOrder(order);
        System.out.println(result);
        if (result==1){
            webAPIResult.setResult(0);
        }else{
            webAPIResult.setResult(1);
        }
        return webAPIResult;
    }

    @ApiOperation("获取用户所有订单")
    @RequestMapping(value = "/allOrders",method = RequestMethod.POST)
    public WebAPIResult selectOrder (
            @RequestBody Order order
    ){
        WebAPIResult webAPIResult=new WebAPIResult();

        List<Order> list=orderService.selectObject(order);
//        System.out.println(list);

        webAPIResult.setResult(0);
        webAPIResult.setData(list);
        return webAPIResult;
    }

    @ApiOperation("获取商家所有订单")
    @RequestMapping(value = "/shoperOrders",method = RequestMethod.POST)
    public WebAPIResult shoperOrders (
            @RequestBody Order order
    ){
        WebAPIResult webAPIResult=new WebAPIResult();
//        System.out.println(order);
        List<Order> list=orderService.shoperOrders(order);
//        System.out.println(list);

        webAPIResult.setResult(0);
        webAPIResult.setData(list);
        return webAPIResult;
    }

    @ApiOperation("获取所有订单")
    @RequestMapping(value = "/Orders",method = RequestMethod.POST)
    public WebAPIResult orders (
    ){
        WebAPIResult webAPIResult=new WebAPIResult();

        List<Order> list=orderService.selectOrders();
//        System.out.println(list);

        webAPIResult.setResult(0);
        webAPIResult.setData(list);
        return webAPIResult;
    }

    @ApiOperation("更新收货状态")
    @RequestMapping(value = "/updateOrder",method = RequestMethod.POST)
    public WebAPIResult updateOrder (
            @RequestBody Order order
    ){
        WebAPIResult webAPIResult=new WebAPIResult();
        System.out.println(order);
        order.setConfirm_state("0");
        int a=orderService.updateOrder(order);
        webAPIResult.setResult(0);
        webAPIResult.setData(a);
        return webAPIResult;
    }

    @ApiOperation("更新接受状态")
    @RequestMapping(value = "/acceptOrder",method = RequestMethod.POST)
    public WebAPIResult acceptOrder (
            @RequestBody Order order
    ){
        WebAPIResult webAPIResult=new WebAPIResult();
        System.out.println(order);
        order.setAccept_state("1");
        int a=orderService.acceptOrder(order);
        webAPIResult.setResult(0);
        webAPIResult.setData(a);
        return webAPIResult;
    }

}
