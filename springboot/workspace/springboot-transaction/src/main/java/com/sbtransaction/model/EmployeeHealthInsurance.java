package com.sbtransaction.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeHealthInsurance {

	@Id
	private String empId;
	
	private String healthInsuranceSchemeName;
	private String coverageAmount;
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getHealthInsuranceSchemeName() {
		return healthInsuranceSchemeName;
	}
	public void setHealthInsuranceSchemeName(String healthInsuranceSchemeName) {
		this.healthInsuranceSchemeName = healthInsuranceSchemeName;
	}
	public String getCoverageAmount() {
		return coverageAmount;
	}
	public void setCoverageAmount(String coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	
	
}
