package com.xc.takeaway.controller;

import com.xc.takeaway.WebAPIResult;
import com.xc.takeaway.service.shopService;
import com.xc.takeaway.utils.Shop;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("店铺")
@RestController
public class shopOrder {

    @Autowired
    shopService shopService;

    @ApiOperation("美食店铺")
    @RequestMapping(value = "/shopListbyType",method = RequestMethod.POST)
    public WebAPIResult shoplist(
            @RequestBody Shop shop
    ){
        WebAPIResult webAPIResult=new WebAPIResult();
        List<Shop> list=shopService.shoplist(shop);

        webAPIResult.setResult(0);
        webAPIResult.setData(list);

        return webAPIResult;
    }
}
