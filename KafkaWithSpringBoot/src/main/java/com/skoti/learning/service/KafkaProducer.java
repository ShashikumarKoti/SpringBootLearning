package com.skoti.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.skoti.learning.model.User;

@Service
public class KafkaProducer {

	String topic = "test";
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendMessage(User user) {
		System.out.println("Sending message to topic...");
		kafkaTemplate.send(topic, user);
	}
}
