package com.skoti.learning.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.skoti.learning.config.MessagingConfig;
import com.skoti.learning.dto.OrderStatus;

@Component
public class User {
	
	@RabbitListener(queues= MessagingConfig.QUEUE)
	public void consumeMessageFromQueue(OrderStatus orderstatus) {
		System.out.println("Message receieved from queue: "+ orderstatus);
	}
}
