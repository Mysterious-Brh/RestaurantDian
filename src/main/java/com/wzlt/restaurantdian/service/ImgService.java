package com.wzlt.restaurantdian.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

public interface ImgService {
    @Async
    void uploadImg(MultipartFile file);
}
