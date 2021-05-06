package com.skoti.learning;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.skoti.learning.aspect.LoggingAdvice;

@SpringBootApplication
public class LoggingUsingAopApplication {

	 private static final Logger logger = org.slf4j.LoggerFactory.getLogger(LoggingAdvice.class); 
	
	public static void main(String[] args) {
		logger.info("this is a info message");
	      logger.warn("this is a warn message");
	      logger.error("this is a error message");
		SpringApplication.run(LoggingUsingAopApplication.class, args);
	}

}
