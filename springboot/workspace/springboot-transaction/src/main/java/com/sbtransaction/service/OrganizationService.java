package com.sbtransaction.service;

import com.sbtransaction.model.Employee;
import com.sbtransaction.model.EmployeeHealthInsurance;

public interface OrganizationService {

	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance);
}
