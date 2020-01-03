package com.ace.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ace.controller.CustomerController;

@Aspect
@Component
public class LogExecutionTimeImpl {
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long executionTime = System.currentTimeMillis() - start;
		log.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
		return proceed;
	}
}
