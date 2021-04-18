package com.sbtransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sbtransaction.model.Employee;
import com.sbtransaction.model.EmployeeHealthInsurance;
import com.sbtransaction.service.EmployeeService;
import com.sbtransaction.service.OrganizationService;

@SpringBootApplication
public class SpringbootTransactionApplication {

	@Autowired
	EmployeeService employeeService;
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootTransactionApplication.class, args);
		OrganizationService organizationService=context.getBean(OrganizationService.class);
		
		Employee emp=new Employee();
		emp.setEmpId("emp101");
		emp.setEmpName("SAM");
		
		EmployeeHealthInsurance employeeHealthInsurance=new EmployeeHealthInsurance();
		employeeHealthInsurance.setEmpId("emp101");
		employeeHealthInsurance.setHealthInsuranceSchemeName("Premium");
		employeeHealthInsurance.setCoverageAmount("20000");
		
		organizationService.joinOrganization(emp, employeeHealthInsurance);
		
	}

}
