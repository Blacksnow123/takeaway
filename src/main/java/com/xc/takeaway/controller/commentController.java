package com.xc.takeaway.controller;

import com.xc.takeaway.WebAPIResult;
import com.xc.takeaway.reponsitory.CommentReponsitory;
import com.xc.takeaway.service.commentService;
import com.xc.takeaway.service.shopService;
import com.xc.takeaway.utils.Shop;
import com.xc.takeaway.utils.shopComment;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@Api("评论")
public class commentController {
    @Autowired
    commentService commentService;

    @Autowired
    shopService shopService;

    @RequestMapping(value = "/insertComment",method = RequestMethod.POST)
    public WebAPIResult insertComment(
            @RequestBody shopComment shopComment
    ){
        WebAPIResult webAPIResult=new WebAPIResult();

        String id;
        UUID uuid = UUID.randomUUID();
        id = uuid.toString();
        id = id.replace("-", "");
        int num = id.hashCode();
        num = num < 0 ? -num : num;
        id = String.valueOf(num);

        shopComment.setId(id);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        shopComment.setComment_time(df.format(new Date()));

        System.out.println(shopComment);
        int a=commentService.insertComment(shopComment);

        webAPIResult.setData(a);

        //更新评分
        Shop shop=new Shop();
        shop.setShop_num(shopComment.getShop_num());
        List<Shop> list1=shopService.oneShop(shop);

        DecimalFormat count = new DecimalFormat("#.0");

        Double p=Double.parseDouble(list1.get(0).pack_score);
        Double t=Double.parseDouble(list1.get(0).taste_score);
        Double s=Double.parseDouble(list1.get(0).send_score);
        Double sc=Double.parseDouble(list1.get(0).shop_score);

        String pack_score=count.format((p+Double.parseDouble(shopComment.pack_score))/2);
        String taste_score=count.format((t+Double.parseDouble(shopComment.taste_score))/2);
        String send_score=count.format((s+Double.parseDouble(shopComment.send_score))/2);
        String shop_score=count.format((sc+Double.parseDouble(shopComment.shop_score))/2);

        Shop lastshop=new Shop();

        lastshop.setId(list1.get(0).id);
        lastshop.setPack_score(pack_score);
        lastshop.setTaste_score(taste_score);
        lastshop.setSend_score(send_score);
        lastshop.setShop_score(shop_score);

        int b=shopService.updateScore(lastshop);

        if(a==1&&b==1){
            webAPIResult.setResult(0);
        }
        return  webAPIResult;
    }

}
