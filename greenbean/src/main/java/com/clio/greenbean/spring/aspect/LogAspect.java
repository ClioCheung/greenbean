package com.clio.greenbean.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * created by 吾乃逆世之神也 on 2019/11/16
 */
@Aspect
@Component
public class LogAspect {
    
    @Pointcut("within(com.clio.greenbean..*)")
    public void globalPointcut(){
    }
    
    @AfterThrowing(pointcut = "globalPointcut()",throwing = "throwable")
    public void printExceptionInfo(JoinPoint joinPoint,Throwable throwable){
        Logger logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
        logger.error(throwable.getMessage(),throwable);
    }
    
}
