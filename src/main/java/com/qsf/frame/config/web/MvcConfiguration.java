package com.qsf.frame.config.web;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 开启Mvc,自动注入spring容器。
 * @Author QSF
 * @Date 2020/8/13 10:33
 * @Version 1.0
 */
public class MvcConfiguration implements WebMvcConfigurer, ApplicationContextAware {

    private static String winUploadPath;
    private static String linuxUploadPath;
    @SuppressWarnings("unused")
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Value("${win.base.upload.path}")
    public void setWinUploadPath(String winUploadPath) {
        MvcConfiguration.winUploadPath = winUploadPath;
    }

    @Value("${linux.base.upload.path}")
    public void setLinuxUploadPath(String linuxUploadPath) {
        MvcConfiguration.linuxUploadPath = linuxUploadPath;
    }


    /**
     * 静态资源配置
     *
     * @param registry
     */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
//            registry.addResourceHandler("/upload/**").addResourceLocations("file:F:/ep/image/upload/");
            registry.addResourceHandler("/upload/**").addResourceLocations("file:/" + winUploadPath);
        } else {
//            registry.addResourceHandler("/upload/**").addResourceLocations("file:/Users/ep/image/upload/");
            registry.addResourceHandler("/upload/**").addResourceLocations("file:" + linuxUploadPath);
        }
    }
}
