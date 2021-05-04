package com.skoti.learning.multipleconsumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skoti.learning.model.User;

@RestController
@RequestMapping("/produce")
public class ProducerController {

	@Autowired
	private TopicProducerService producerService;
	
	@PostMapping("/sendMsg")
	public void sendString(@RequestParam("msg") String message) {
		producerService.sendStringMessage(message);
	}
	
	@PostMapping("/sendUser")
	public void sendUser(@RequestBody User user) {
		producerService.sendUserMessage(user);
	}
}
