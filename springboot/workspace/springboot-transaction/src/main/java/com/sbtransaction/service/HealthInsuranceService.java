package com.sbtransaction.service;

import com.sbtransaction.model.EmployeeHealthInsurance;

public interface HealthInsuranceService {

	void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance);

	void deleteEmployeeHealthInsuranceById(String empId);
}
