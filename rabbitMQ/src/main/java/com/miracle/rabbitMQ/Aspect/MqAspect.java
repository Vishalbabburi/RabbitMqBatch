package com.miracle.rabbitMQ.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MqAspect {
	Logger log=LoggerFactory.getLogger(MqAspect.class);
	@Around("execution(* com.miracle.rabbitMQ.producers.*.*(..))")
	 public Object forPublishmethods(ProceedingJoinPoint jp) throws Throwable {
		MethodSignature methodName =(MethodSignature) jp.getSignature();
		long start= System.currentTimeMillis();
		 Object result=jp.proceed();
		 long end =System.currentTimeMillis();
		 long executionTime=end-start;
		 log.info("Publish method "+methodName.getName()+" took "+executionTime+" milli seconds to execute");
		 return result;
	}
	
	@Around("execution(* com.miracle.rabbitMQ.consumers.*.*(..))")
	 public Object forConsumermethods(ProceedingJoinPoint jp) throws Throwable {
		MethodSignature methodName =(MethodSignature) jp.getSignature();
		long start= System.currentTimeMillis();
		 Object result=jp.proceed();
		 long end =System.currentTimeMillis();
		 long executionTime=end-start;
		 log.info("Consumer method "+methodName.getName()+" took "+executionTime+" milli seconds to execute");
		 return result;
	}
}
