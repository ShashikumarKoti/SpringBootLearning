package com.skoti.learning.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.skoti.learning.model.User;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = "test", groupId = "group_id")
	public void consumeMessage(User user) {
		System.out.println("Message received on topic: " + user);
	}
}
