package com.panda.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    /**
     * 加载spring自带的logger日志记录
     */
    private static final Logger logger=LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 定义一个切点
     */
    @Pointcut("execution(public * com.panda.girl.controller.GirlController.girlList(..))")
    public void log(){}

    @Before("log()")
    public void logBefore(JoinPoint joinPoint){
        //获得请求内容
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        logger.info("url={}",request.getRequestURI());
        logger.info("method={}",request.getMethod());
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void logAfter(){
        logger.info("goodbye log");
    }
    //方法返回后获得response的object对象
    @AfterReturning(returning = "object",pointcut="log()")
    public void logAfterReturn(Object object){
        logger.info("response={}",object.toString());
    }
}
