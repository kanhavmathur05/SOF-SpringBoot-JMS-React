package com.exceptionhandler.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exceptionhandler.exception.ResourceNotFoundException;
import com.exceptionhandler.model.Employee;
import com.exceptionhandler.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@ApiOperation(value = "Get List of employees from the company",
			response = Iterable.class, tags = "getAllEmployees")
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getEmployeeList();
	}

	@ApiOperation(value = "Get Employee by ID from the Company Records", 
			response = Employee.class, tags="getEmployeeId")
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") int empId)
			throws ResourceNotFoundException {
		Employee employee = employeeService.getEmployee(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not found for this id :: " + empId));
		return ResponseEntity.ok().body(employee);
	}

	@ApiOperation(value = "Add employee to the company",
			response = Employee.class, tags = "postEmployee")
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@ApiOperation(value = "Update Employee in the company records",
			response = Employee.class, tags = "putEmployee")
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") int empId,
			@Validated @RequestBody Employee empDetails) throws ResourceNotFoundException {
		Employee employee = employeeService.getEmployee(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for Id :: " + empId));
		employee.setEmpName(empDetails.getEmpName());
		employee.setFirstName(empDetails.getFirstName());
		employee.setLastName(empDetails.getLastName());
		employee.setEmail(empDetails.getEmail());

		final Employee updatedEmployee = employeeService.updateEmployee(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@ApiOperation(value = "Delete Employee from the company",
			response = Employee.class, tags="deleteEmployee")
	@DeleteMapping("employee/{id}")	
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") int empId) throws ResourceNotFoundException {
		Employee employee = employeeService.getEmployee(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for Id :: " + empId));
		employeeService.deleteEmployee(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
