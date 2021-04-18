package com.sbtransaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbtransaction.model.Employee;
import com.sbtransaction.model.EmployeeHealthInsurance;
import com.sbtransaction.service.EmployeeService;
import com.sbtransaction.service.HealthInsuranceService;
import com.sbtransaction.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService{

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	HealthInsuranceService healthInsuranceService;
	
	@Override
//	@Transactional(propagation = Propagation.REQUIRED)
	@Transactional(propagation = Propagation.REQUIRES_NEW)	
	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) {
		employeeService.insertEmployee(employee);

//		if(employee.getEmpId().equals("emp101")) {
//			throw new RuntimeException("Throwing exception to rollback");
//		}

		healthInsuranceService.registerEmployeeHealthInsurance(employeeHealthInsurance);
	}

}
