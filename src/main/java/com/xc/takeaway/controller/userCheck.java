package com.xc.takeaway.controller;

import com.xc.takeaway.WebAPIResult;
import com.xc.takeaway.service.userService;
import com.xc.takeaway.token.TokenUtils;
import com.xc.takeaway.utils.Shop;
import com.xc.takeaway.utils.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@RestController
@Api(tags = "TakeAway")
public class userCheck {

    @Autowired
    userService userService;


    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    @ApiOperation(tags = "身份验证",value ="身份验证")
    @RequestMapping(value = "/userCheck",method = RequestMethod.POST)
    public WebAPIResult userCheck(@RequestBody User user){
        WebAPIResult webAPIResult = new WebAPIResult();
        System.out.println("身份验证接收到的对象为：");
        System.out.println(user);

        int a=userService.userCheck (user);
        if(a==1){
            //生成token
            String token= TokenUtils.getToken(user.getUser_name());
            System.out.println("生成的token为：");
            System.out.println(token);
            //存储token到session
            session = request.getSession();
            session.setAttribute("token", token);

            webAPIResult.setResult(0);
            webAPIResult.setToken(token);
            System.out.println(webAPIResult);
        }else{
            webAPIResult.setResult(1);
            webAPIResult.setMessage("用户名或密码错误");
        }
        return webAPIResult;
    }

    @ApiOperation(tags = "身份验证",value ="身份验证")
    @RequestMapping(value = "/adminCheck",method = RequestMethod.POST)
    public WebAPIResult adminCheck(@RequestBody User user){
        WebAPIResult webAPIResult = new WebAPIResult();
        System.out.println("身份验证接收到的对象为：");
        System.out.println(user);

        List<User> list=userService.adminCheck(user);

        if(list.size()==1){
            //生成token
            String token= TokenUtils.getToken(user.getUser_name());
            System.out.println("生成的token为：");
            System.out.println(token);
            //存储token到session
            session = request.getSession();
            session.setAttribute("token", token);

            webAPIResult.setResult(0);
            webAPIResult.setData(list);
            webAPIResult.setToken(token);
            System.out.println(webAPIResult);
        }else{
            webAPIResult.setResult(1);
            webAPIResult.setMessage("用户名或密码错误");
        }
        return webAPIResult;
    }

    @ApiOperation("用户注册")
    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)
    public WebAPIResult userRegister(@RequestBody User user){
        WebAPIResult webAPIResult = new WebAPIResult();
        //随机id
        String id;
        UUID uuid = UUID.randomUUID();
        id = uuid.toString();
        id = id.replace("-", "");
        int num = id.hashCode();
        num = num < 0 ? -num : num;
        id = String.valueOf(num);

        System.out.println(user);
        user.setId(id);
        int a=userService.userRegister(user);
        if(a==1){
            webAPIResult.setResult(0);
        }else{
            webAPIResult.setResult(1);
            webAPIResult.setMessage("注册失败");
        }
        return webAPIResult;
    }

    @ApiOperation("商家注册")
    @RequestMapping(value = "/shoperRegister",method = RequestMethod.POST)
    public WebAPIResult shoperRegister(@RequestBody User user){
        WebAPIResult webAPIResult = new WebAPIResult();
        //随机id
        String id;
        UUID uuid = UUID.randomUUID();
        id = uuid.toString();
        id = id.replace("-", "");
        int num = id.hashCode();
        num = num < 0 ? -num : num;
        id = String.valueOf(num);

        System.out.println(user);
        user.setId(id);
        int a=userService.shoperRegister(user);
        if(a==1){
            webAPIResult.setResult(0);
        }else{
            webAPIResult.setResult(1);
            webAPIResult.setMessage("注册失败");
        }
        return webAPIResult;
    }


    @ApiOperation("用户数量")
    @RequestMapping(value = "/userCount",method = RequestMethod.POST)
    public WebAPIResult userCount() {
        WebAPIResult webAPIResult=new WebAPIResult();
        int a=userService.userCount();
        webAPIResult.setResult(0);
        webAPIResult.setData(a);

        return webAPIResult;
    }

    @ApiOperation("管理员数量")
    @RequestMapping(value = "/adminCount",method = RequestMethod.POST)
    public WebAPIResult adminCount() {
        WebAPIResult webAPIResult=new WebAPIResult();
        int a=userService.adminCount();
        webAPIResult.setResult(0);
        webAPIResult.setData(a);

        return webAPIResult;
    }

    @ApiOperation("用户信息")
    @RequestMapping(value = "/allUsers",method = RequestMethod.POST)
    public WebAPIResult allUsers(
            @RequestBody User user
    ) {
        System.out.println(user);
        WebAPIResult webAPIResult=new WebAPIResult();
        List<User> list=userService.allUsers(user);
        webAPIResult.setResult(0);
        webAPIResult.setData(list);

        return webAPIResult;
    }

    @ApiOperation("店铺信息")
    @RequestMapping(value = "/allshops",method = RequestMethod.POST)
    public WebAPIResult allshops(
            @RequestBody User user
    ) {
//        System.out.println(shop);
        WebAPIResult webAPIResult=new WebAPIResult();
        List<Shop> list=userService.allshops(user);
        webAPIResult.setResult(0);
        webAPIResult.setData(list);
        System.out.println("所有商家");
        System.out.println(list);
        return webAPIResult;
    }

    @ApiOperation("重置密码")
    @RequestMapping(value = "/reset",method = RequestMethod.POST)
    public WebAPIResult reset(
            @RequestBody User user
    ) {
        System.out.println(user);
        WebAPIResult webAPIResult=new WebAPIResult();
        int a=userService.reset(user);
        webAPIResult.setResult(0);
        webAPIResult.setData(a);
        System.out.println("修改标记");
        System.out.println(a);
        return webAPIResult;
    }
}
