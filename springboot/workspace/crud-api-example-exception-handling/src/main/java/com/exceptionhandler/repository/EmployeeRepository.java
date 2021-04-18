package com.exceptionhandler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exceptionhandler.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
