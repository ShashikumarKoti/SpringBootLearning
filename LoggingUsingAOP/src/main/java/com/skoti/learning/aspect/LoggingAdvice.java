package com.skoti.learning.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Aspect
public class LoggingAdvice {

	Logger log = org.slf4j.LoggerFactory.getLogger(LoggingAdvice.class);
	
	@Pointcut(value="execution(* com.skoti.learning.service.ProductService.*(..))")
	public void myPointcut() {
		
	}
	
	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String className = pjp.getTarget().getClass().toString();
		String methodName = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		
		log.info("Method invoked " + className + " : " + methodName + "()" + " arguments: "
				+ mapper.writeValueAsString(args));
		
		Object responseObject = pjp.proceed();
		log.info(className + " : "+ methodName+"()" + " Response: "+ mapper.writeValueAsString(responseObject));
		return responseObject;
	}
	
}
