package com.skoti.learning.sendreceive;

import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skoti.learning.model.Order;

@RestController
@RequestMapping("/orders")
public class OrderSender {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Topic topic;
	

	@PostMapping("/save")
	public String sendOrder(@RequestBody Order order) throws JsonProcessingException {
		System.out.println("Sending order to topic");
		ObjectMapper mapper = new ObjectMapper();
		String orderDetails = mapper.writeValueAsString(order);
		jmsTemplate.convertAndSend(topic, orderDetails);
		return "Order sent successfully";
	}
}
