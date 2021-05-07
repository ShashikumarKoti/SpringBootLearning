package com.skoti.learning.receiverSender;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skoti.learning.entity.ScheduleOperation;

@RestController
@RequestMapping("/operations")
public class OperationSender {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queue1;
	
	@Autowired
	private Queue queue2;

	/*
	 * 
	 */
	@PostMapping("/save")
	public String sendOperDetails(@RequestBody ScheduleOperation scheduleOperation) throws JsonProcessingException {
		System.out.println("Sending message....");
		ObjectMapper mapper = new ObjectMapper();
		String operation = mapper.writeValueAsString(scheduleOperation);
		jmsTemplate.convertAndSend(queue1, 	operation);
		jmsTemplate.convertAndSend(queue2, 	operation);
		return "Message sent successfully";
	}
}
