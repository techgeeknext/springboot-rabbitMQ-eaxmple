package com.techgeeknext.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.techgeeknext.model.Employee;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${techgeeknext.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${techgeeknext.rabbitmq.routingkey}")
	private String routingkey;	

	public void send(Employee empName) {
		amqpTemplate.convertAndSend(exchange, routingkey, empName);
		System.out.println("Send msg = " + empName);
	}
}