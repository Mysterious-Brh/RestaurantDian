package com.wzlt.restaurantdian.service.impl;

import com.wzlt.restaurantdian.service.ImgService;
import com.wzlt.restaurantdian.utils.PictureHandle;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImgServiceImpl implements ImgService {
    @Override
    @Async
    public void uploadImg(MultipartFile file) {
        //获取文件名
        String fileName = file.getOriginalFilename();
        //判空，可抛出自定义异常
        Optional.ofNullable(fileName).orElseThrow();
        //获取后缀
        String suffix = fileName.substring(fileName.indexOf("."));
        File sourceFile = null;
        try {
            //创建临时文件
            sourceFile = File.createTempFile(UUID.randomUUID().toString().replace("-",""), suffix);
            //将上传文件传输给临时文件,因为方法为异步时，multipartFile对象会在Controller层接口返回时被回收
            file.transferTo(sourceFile);
        } catch (IOException e) {
            System.out.println("图片传输失败  ："+e.getMessage());
        }
        //创建目标文件
        File targetFile = new File("D:/pictures/"+ UUID.randomUUID().toString().replace("-","")+suffix);
        //进行缩略操作
        try {
            PictureHandle.outputQuality(sourceFile,targetFile);
        } catch (IOException e) {
            System.out.println("图片处理失败  ："+e.getMessage());
        }
        //删除临时文件
        if (sourceFile != null) {
            sourceFile.delete();
        }
    }
}
