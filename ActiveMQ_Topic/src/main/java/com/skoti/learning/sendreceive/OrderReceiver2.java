package com.skoti.learning.sendreceive;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderReceiver2 {

	@JmsListener(destination = "topic.order")
	public void receiveOrder(String order) throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Order received by receiver2: " + order);
	}
	
}
