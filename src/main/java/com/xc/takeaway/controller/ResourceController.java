package com.xc.takeaway.controller;

import com.xc.takeaway.utils.UploadInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ResourceController {
    
    @Value("${resources.root}")
    private String rootResourcesPath;
    
    @Value("${resources.path}")
    private String resources;
    
    @Value("${resources.images}")
    private String imagesPath;
//    @Value("${server.servlet.context-path}")
    private String serverPath="";
    
    @RequestMapping(value = "uploadimage",method = RequestMethod.POST)
    public UploadInfo imgUpdate(MultipartFile file) {
        UploadInfo uploadInfo = new UploadInfo();
        if (file.isEmpty()) {
            uploadInfo.setMsg("上传失败");
            uploadInfo.setCode(200);
            return uploadInfo;
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 这里我使用随机字符串来重新命名图片
        fileName = Calendar.getInstance().getTimeInMillis() + Math.random() + suffixName;
        String urlPath = rootResourcesPath+resources+imagesPath + fileName;
        
        File dest = new File(urlPath);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            Map<String ,Object> map = new HashMap<String, Object>();
            map.put("src",serverPath+"/"+resources+imagesPath+fileName);
            map.put("saveSrc","/"+resources+imagesPath+fileName);
            map.put("title",fileName);
            uploadInfo.setCode(0);
            uploadInfo.setMsg("上传成功");
            uploadInfo.setData(map);
            return uploadInfo;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadInfo;
    }
}

