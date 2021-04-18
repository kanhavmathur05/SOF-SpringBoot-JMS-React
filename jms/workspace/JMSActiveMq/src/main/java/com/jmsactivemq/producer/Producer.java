package com.jmsactivemq.producer;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmsactivemq.dto.Employee;

@RestController
@RequestMapping("/produce")
public class Producer {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queue;
	
	@PostMapping("/message")
	public Employee sendMessage(@RequestBody Employee employee) {
		String empjson;
		try {
			ObjectMapper mapper=new ObjectMapper();
			empjson=mapper.writeValueAsString(employee);
			jmsTemplate.convertAndSend(queue,empjson);
		}
		catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		return employee;
	}
}
