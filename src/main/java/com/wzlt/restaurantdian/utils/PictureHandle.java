package com.wzlt.restaurantdian.utils;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;

public class PictureHandle {
    /**
     * 要创建分辨率为原始图片 50% 的缩略图
     */
    public static void halfResolution(File source, File target) throws IOException {
        Thumbnails
                //传入源文件
                .of(source)
                //设置分辨率比例因子，不能小于0.0
                .scale(0.5d)
                //目标文件
                .toFile(target);
    }

    /**
     * 创建分辨率为640x480的略缩图，并在此基础上，保留原始图像的纵横比
     */
    public static void formatResolution(File source,File target) throws IOException {
        Thumbnails
                //传入源文件
                .of(source)
                //生成缩略图的宽高
                .size(640,480)
                //保留原始图像纵横比
                .keepAspectRatio(true)
                //目标文件
                .toFile(target);
    }

    /**
     *  保持原始分辨率，减低图片质量
     */
    public static void outputQuality(File source,File target) throws IOException {
        Thumbnails
                //传入源文件
                .of(source)
                //原始分辨率
                .scale(1.0d)
                //输出图片质量，该值介于 double 和 1.0d 和 0.0d之间，值越高质量越高
                .outputQuality(0.5d)
                //目标文件
                .toFile(target);
    }
}
