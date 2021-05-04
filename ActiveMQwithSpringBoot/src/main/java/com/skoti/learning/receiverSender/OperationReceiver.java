package com.skoti.learning.receiverSender;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OperationReceiver {

	@JmsListener(destination = "operations.queue")
	public void receiveOper(String scheduleOperation) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 	System.out.println("Received message: " + scheduleOperation);
	}
	
	@JmsListener(destination = "operationQueue")
	public void receiveOperDetails(String scheduleOperation) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 	System.out.println("Received message: " + scheduleOperation);
	}
}

