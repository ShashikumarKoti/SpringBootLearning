package com.skoti.learning.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class JmsConfig {
	
	@Value("${spring.activemq.broker-url}")
	private String BROKER_URL; 
	
	@Bean
	public Queue queue1() {
		return new ActiveMQQueue("operations.queue");
	}
	
	@Bean
	public Queue queue2() {
		return new ActiveMQQueue("operationQueue");
	}
	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
	    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
	    connectionFactory.setBrokerURL(BROKER_URL);
	    return connectionFactory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate(){
		return new JmsTemplate(connectionFactory());
	}

}
