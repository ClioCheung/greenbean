package com.clio.greenbean.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * created by 吾乃逆世之神也 on 2019/11/16
 */
@Aspect
@Component
public class TestAspect {
    
    // @Pointcut("within(com.clio.greenbean.spring.controller..*)")
    @Pointcut("execution(* com.clio.greenbean.spring.controller.*.*(..))")
    public void makePointcut(){
    }
    
    @Before("makePointcut()")
    public void printStarLog(JoinPoint joinPoint){
        Class<?> targetClass = joinPoint.getSignature().getDeclaringType();
        Logger logger = LoggerFactory.getLogger(targetClass);
        logger.debug(joinPoint.getSignature().getName() + " + beforePointcut +++");
    }
    
    @After("makePointcut()")
    public void printAfterLog(JoinPoint joinPoint){
        Object targetObject = joinPoint.getTarget();
        Class<?> targetClass = targetObject.getClass();
        Logger logger = LoggerFactory.getLogger(targetClass);
        logger.debug(joinPoint.getSignature().getName() + " +++ afterPointcut +");
    }
}
