package com.skoti.learning.multipleconsumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.skoti.learning.model.User;

@Service
public class TopicConsumerService {

	@KafkaListener(topics="${general.topic.name}", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Message received from general topic: " + message);
	}
	
	@KafkaListener(topics="${user.topic.name}", groupId = "group_id")
	public void consume(User user) {
		System.out.println("Message received from User topic: " + user);
	}
}
