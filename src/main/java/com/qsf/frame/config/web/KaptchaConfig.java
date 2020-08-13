package com.qsf.frame.config.web;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 * 验证码的配置
 * @Author QSF
 * @Date 2020/8/13 10:37
 * @Version 1.0
 */
public class KaptchaConfig {
    @Bean(name = "captchaProducer")
    public DefaultKaptcha getKaptchaBean()
    {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", "yes");
        properties.setProperty("kaptcha.border.color", "205,170,120");
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        properties.setProperty("kaptcha.image.width", "200");
        properties.setProperty("kaptcha.image.height", "60");
        properties.setProperty("kaptcha.textproducer.font.size", "50");
        properties.setProperty("kaptcha.session.key", "kaptchaCode");
        properties.setProperty("kaptcha.textproducer.char.spac", "30");
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        properties.setProperty("kaptcha.textproducer.font.names", "Arial,Courier");
        properties.setProperty("kaptcha.noise.color", "white");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

    @Bean(name = "captchaProducerMath")
    public DefaultKaptcha getKaptchaBeanMath()
    {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", "yes");
        properties.setProperty("kaptcha.border.color", "105,179,90");
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        properties.setProperty("kaptcha.image.width", "160");
        properties.setProperty("kaptcha.image.height", "90");
        properties.setProperty("kaptcha.textproducer.font.size", "50");
        properties.setProperty("kaptcha.session.key", "kaptchaCodeMath");
        properties.setProperty("kaptcha.textproducer.impl", "com.lhf.springboot.support.KaptchaTextCreator");
        properties.setProperty("kaptcha.textproducer.char.spac", "30");
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        properties.setProperty("kaptcha.textproducer.font.names", "Arial,Courier");
        properties.setProperty("kaptcha.noise.color", "white");
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");
        properties.setProperty("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.ShadowGimpy");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
