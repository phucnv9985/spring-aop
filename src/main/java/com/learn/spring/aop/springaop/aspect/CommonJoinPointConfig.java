package com.learn.spring.aop.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

	@Pointcut("execution(* com.learn.spring.aop.springaop.data.*.*(..))")
	public void dataLayerExecution() {}
	
	@Pointcut("execution(* com.learn.spring.aop.springaop.business.*.*(..))")
	public void businessLayerExecution() {}
	
	
	@Pointcut("com.learn.spring.aop.springaop.aspect.CommonJoinPointConfig.dataLayerExecution() || com.learn.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()")
	public void allLayerExecution() {}
	
	@Pointcut("bean(*dao*)")
	public void beanContainingDao() {}
	
	@Pointcut("within(com.learn.spring.aop.springaop.data..*)")
	public void dataLayerExecutionWithWithin() {}
}
