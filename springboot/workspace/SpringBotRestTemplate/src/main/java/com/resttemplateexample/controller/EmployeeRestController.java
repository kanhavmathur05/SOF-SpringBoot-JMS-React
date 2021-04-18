package com.resttemplateexample.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.resttemplateexample.model.Employee;

@RestController
public class EmployeeRestController {

	@Autowired
	RestTemplate restTemplate;
	
	String url="http://localhost:8080/api/v1/employees";
	String url2="http://localhost:8080/api/v1/employee/";
	String url3="";
	
	@GetMapping(value = "/restTemp/employees")
	public String getEmployees()
	{
		System.out.println("Inside getEmployees method of spring boot rest template application");
		
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(headers);
		
		ResponseEntity<String> responseEntity=restTemplate
				.exchange(url, HttpMethod.GET,entity,String.class);
		return responseEntity.getBody();
	}
	
	@GetMapping("/restTemp/employee/{id}")
	public String getEmployee(@PathVariable("id") int id)
	{
		System.out.println("Inside getEmployee method");
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(headers);
		
		ResponseEntity<String> responseEntity=restTemplate
				.exchange(url2+id,HttpMethod.GET,entity,String.class);
		
		return responseEntity.getBody();
	}
	
	@PostMapping("/restTemp/employee")
	public String createEmployee(@RequestBody Employee employee) {
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Employee> entity=new HttpEntity<Employee>(employee,headers);
		
		ResponseEntity<String> responseEntity=restTemplate
				.exchange(url, HttpMethod.POST,entity,String.class);
		
		return responseEntity.getBody();
	}
	
	@PutMapping(value = "restTemp/employees/{id}")
	public String updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Employee> entity = new HttpEntity<Employee>(employee,headers);
		
		ResponseEntity<String> responseEntity=restTemplate.exchange(url2+id, HttpMethod.PUT,entity,String.class);
		
		return responseEntity.getBody();
	}
	
	@DeleteMapping("/restTemp/employees/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Employee> entity=new HttpEntity<Employee>(headers);
		ResponseEntity<String> responseEntity=restTemplate.exchange(url2+id, HttpMethod.DELETE
				,entity,String.class);
		return responseEntity.getBody();
	}
}
