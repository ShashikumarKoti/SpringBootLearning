package com.skoti.learning.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/hystrixdemo")
public class HystrixController {

	@PostMapping("/greet")
	@HystrixCommand(fallbackMethod = "fallback_greet", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") })
	public String greet() throws InterruptedException {
		Thread.sleep(5000);
		return "Hello Mr.Shashikumar";
	}
	
	
	public String fallback_greet() {
		return "Kindly try after sometime as there is an outage!!";
	}
}
