package com.skoti.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skoti.learning.model.User;
import com.skoti.learning.service.KafkaProducer;

@RestController
@RequestMapping("/kafkaproducer")
public class KafkaProducerController {

	@Autowired
	private KafkaProducer kafkaProducer;
	
	@PostMapping("/createUser")
	public void produceMessage(@RequestBody User user) {
		kafkaProducer.sendMessage(user);
	}
}
