package com.techgeeknext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techgeeknext.model.Employee;
import com.techgeeknext.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/techgeeknext")
public class RabbitMQWebController {

	@Autowired
	private RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/rabbitmq/receive/message")
	public String consume(@RequestParam("empName") String empName,@RequestParam("empId") String empId) {
	
	Employee emp=new Employee();
	emp.setEmpId(empId);
	emp.setEmpName(empName);
		rabbitMQSender.send(emp);

		return "Message has been sent to the RabbitMQ techgeeknext successfully";
	}

}

