package com.sbtransaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sbtransaction.dao.HealthInsuranceDao;
import com.sbtransaction.model.EmployeeHealthInsurance;
import com.sbtransaction.service.HealthInsuranceService;

@Service
public class HealthInsuranceServiceImpl implements HealthInsuranceService{

	@Autowired
	HealthInsuranceDao healthInsuranceDao;
	
	@Override
//	@Transactional(propagation = Propagation.REQUIRED)
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance) {
		healthInsuranceDao.registerEmployeeHealthInsurance(employeeHealthInsurance);
	}

	@Override
	public void deleteEmployeeHealthInsuranceById(String empId) {
		healthInsuranceDao.deleteEmployeeHealthInsuranceById(empId);
	}

}
