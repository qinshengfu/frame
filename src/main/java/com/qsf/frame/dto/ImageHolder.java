package com.qsf.frame.dto;

import lombok.Data;

import java.io.InputStream;

/**
 * 处理图片
 * @Author QSF
 * @Date 2020/8/13 10:53
 * @Version 1.0
 */
@Data
public class ImageHolder {
    private String imageName;
    private InputStream image;

    public ImageHolder(String imageName, InputStream image) {
        this.imageName = imageName;
        this.image = image;
    }
}
