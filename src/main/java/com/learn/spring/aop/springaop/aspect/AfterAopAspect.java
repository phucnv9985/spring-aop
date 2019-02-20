package com.learn.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// AOP
// Configuration
@Aspect
@Configuration
public class AfterAopAspect {
	
    private Logger logger = LoggerFactory.getLogger(AfterAopAspect.class);

    //execution(* PACKAGE.*.*(..))
    @AfterReturning(pointcut="com.learn.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()", returning="result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
    	logger.info("Using businessLayerExecution: {} returned with value {}", joinPoint, result);
    }
    
    @AfterThrowing(value="com.learn.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()", throwing="exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
    	logger.info("Using businessLayerExecution: {} throws exception {}", joinPoint, exception);
    }
    
    @After("com.learn.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()")
    public void after(JoinPoint joinPoint) {
    	logger.info("Using businessLayerExecution: after execution of {}", joinPoint);
    }
}
