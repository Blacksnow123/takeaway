package com.xc.takeaway.controller;

import com.xc.takeaway.WebAPIResult;
import com.xc.takeaway.service.typeService;
import com.xc.takeaway.utils.Type;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("店铺类型")
@RestController
public class typeController {
    @Autowired
    typeService typeService;

    @RequestMapping(value = "/typerList",method = RequestMethod.POST)
    public WebAPIResult typeList(){
        WebAPIResult webAPIResult=new WebAPIResult();

        List<Type> list =typeService.typeList();

        webAPIResult.setResult(0);
        webAPIResult.setData(list);

        return webAPIResult;
    }
}
