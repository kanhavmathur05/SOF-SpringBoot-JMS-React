package com.exceptionhandler.service;

import java.util.List;
import java.util.Optional;

import com.exceptionhandler.model.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee employee);
	List<Employee> getEmployeeList();
	Optional<Employee> getEmployee(int id);
	void deleteEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
}
 