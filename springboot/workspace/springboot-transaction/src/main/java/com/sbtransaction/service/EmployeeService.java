package com.sbtransaction.service;

import com.sbtransaction.model.Employee;

public interface EmployeeService {
	void insertEmployee(Employee employee);
	void deleteEmployeeById(String empId);
}
