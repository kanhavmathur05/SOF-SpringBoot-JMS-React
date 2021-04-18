DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS employeeHealthInsurance;

CREATE TABLE employee (
empId varchar(10) NOT NULL,
empName varchar(100) NOT NULL 
);

CREATE TABLE employeeHealthInsurance (
empId varchar(10) NOT NULL,
healthInsuranceSchemeName varchar(100) NOT NULL,
coverageAmount varchar(100) NOT NULL
);