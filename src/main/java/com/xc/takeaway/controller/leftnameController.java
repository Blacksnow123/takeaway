package com.xc.takeaway.controller;

import com.xc.takeaway.WebAPIResult;
import com.xc.takeaway.service.leftnameService;
import com.xc.takeaway.utils.leftName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Api("商铺左侧栏")
public class leftnameController {

    @Autowired
    leftnameService leftnameService;

    @RequestMapping(value = "/leftnames",method = RequestMethod.POST)
    public WebAPIResult leftnames(
            @RequestBody leftName leftName
    ){
        WebAPIResult webAPIResult=new WebAPIResult();

        List<leftName> list=leftnameService.leftNames(leftName);

        webAPIResult.setResult(0);
        webAPIResult.setData(list);
        return webAPIResult;
    }

    @RequestMapping(value = "/insertName",method = RequestMethod.POST)
    public WebAPIResult insertName(
            @RequestBody leftName leftName
    ){
        WebAPIResult webAPIResult=new WebAPIResult();
        System.out.println(leftName);
        String id;
        UUID uuid = UUID.randomUUID();
        id = uuid.toString();
        id = id.replace("-", "");
        int num = id.hashCode();
        num = num < 0 ? -num : num;
        id = String.valueOf(num);

        leftName.setId(id);

        int a=leftnameService.insertName(leftName);

        webAPIResult.setResult(0);
        webAPIResult.setData(a);
        return webAPIResult;
    }
}
