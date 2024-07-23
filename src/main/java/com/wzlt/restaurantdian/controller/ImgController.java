package com.wzlt.restaurantdian.controller;

import com.wzlt.restaurantdian.service.ImgService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/img/")
public class ImgController {
    @Resource
    private ImgService imgService;
    // 上传图片进行指定缩略
    @PostMapping("upload")
    public String uploadImg(@RequestParam("img") MultipartFile file){
        imgService.uploadImg(file);
        return "success";
    }
}
