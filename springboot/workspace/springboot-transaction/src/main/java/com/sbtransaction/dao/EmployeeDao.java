package com.sbtransaction.dao;

import com.sbtransaction.model.Employee;

public interface EmployeeDao {
	void insertEmployee(Employee employee);
	void deleteEmployeeById(String empId);
}
