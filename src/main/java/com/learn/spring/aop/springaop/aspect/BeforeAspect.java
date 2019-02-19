package com.learn.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// AOP
// Configuration
@Aspect
@Configuration
public class BeforeAspect {
	
    private Logger logger = LoggerFactory.getLogger(BeforeAspect.class);

    //execution(* PACKAGE.*.*(..))
    @Before("com.learn.spring.aop.springaop.aspect.CommonJoinPointConfig.dataLayerExecution()")
    public void before(JoinPoint joinPoint) {
    	logger.info(" Intercepted method calls using dataLayerExecution - {}", joinPoint);
    }
}
