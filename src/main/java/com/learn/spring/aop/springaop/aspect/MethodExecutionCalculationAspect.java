package com.learn.spring.aop.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// AOP
// Configuration
@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
	
    private Logger logger = LoggerFactory.getLogger(MethodExecutionCalculationAspect.class);

    //execution(* PACKAGE.*.*(..))
    @Around("com.learn.spring.aop.springaop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    	// startTime = x
    	long startTime = System.currentTimeMillis();
    	// allow execution of method
    	Object ob = joinPoint.proceed();
    	// endTime = y
    	long timeTaken = System.currentTimeMillis() - startTime;
    	logger.info("Using trackTimeAnnotation: Time taken by {} is {}", joinPoint, timeTaken);
    	return ob;
    }
}
