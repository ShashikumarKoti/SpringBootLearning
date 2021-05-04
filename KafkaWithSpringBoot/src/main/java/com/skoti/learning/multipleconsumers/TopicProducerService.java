package com.skoti.learning.multipleconsumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.skoti.learning.model.User;

@Service
public class TopicProducerService {

	@Value("${general.topic.name}")
	private String generalTopicName;
	
	@Value("${user.topic.name}")
	private String userTopicName;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaStringTemplate;
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaUserTemplate;
	
	public void sendStringMessage(String message) {
		kafkaStringTemplate.send(generalTopicName,message);
	}
	
	public void sendUserMessage(User user) {
		kafkaUserTemplate.send(userTopicName,user);
	}
}
