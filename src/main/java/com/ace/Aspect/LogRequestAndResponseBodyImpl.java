package com.ace.Aspect;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ace.dto.request.DomainRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Aspect
@Component
public class LogRequestAndResponseBodyImpl {

	
	private static final Logger log = LoggerFactory.getLogger(LogRequestAndResponseBodyImpl.class);
	@Before("@annotation(LogRequestAndResponseBody)")
	public void before(JoinPoint joinPoint) {
		log.info("----------------------------------------------------------------------------------------------------------------");
		Object[] obj = joinPoint.getArgs();
		List<Object> list = Arrays.asList(obj);
		for (Object object : list) {		
				//very important converting string formate json to horizontal formate json String
				Gson gson = new GsonBuilder().setPrettyPrinting().create();		
				//DomainRequest objRequest = (DomainRequest) object;
				String json = gson.toJson(object);		
				log.debug("REQUEST BODY  :-  " + json);	
		}
		
	}

	@AfterReturning(pointcut="@annotation(LogRequestAndResponseBody)", returning="result")
	public void After(JoinPoint joinPoint, Object result) {
		//log.debug("return from method :-" + joinPoint.getSourceLocation().getWithinType().getName() +"."+ joinPoint.getSignature().getName());
	 
			Gson gson = new GsonBuilder().setPrettyPrinting().create();		
			//DomainRequest objRequest - (DomainRequest) result;
			String json = gson.toJson(result); 
			  log.debug("RESPONSE BODY :-  " +json);
		 
		  log.info("----------------------------------------------------------------------------------------------------------------");	 

	}
}
