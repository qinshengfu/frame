package com.qsf.frame.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @Author QSF
 * @Date 2020/8/13 10:28
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class HttpAspect {
    @Pointcut("execution(public * com.qsf.frame.controller.*.*.*(..))"+
            "&&!execution(public * com.qsf.frame.controller.captchacontroller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void Before(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //返回访问的url
        log.info("url={}", request.getRequestURL());
        //返回请求方式
        log.info("method={}", request.getMethod());
        //返回ip地址
        log.info("ip={}", request.getRemoteAddr());
        // 返回方法所在的包名、类名和方法名
        log.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //获取带参方法的参数
        log.info("args={}", joinPoint.getArgs());

    }

    @After("log()")
    public void doAfter() {
        log.info("2222222");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        log.info("response={}", object.toString());
    }
}
