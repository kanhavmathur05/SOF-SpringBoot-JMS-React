package com.sbtransaction.dao.impl;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.sbtransaction.dao.EmployeeDao;
import com.sbtransaction.model.Employee;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao{

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	@Override
	public void insertEmployee(Employee employee) {
		String sql="INSERT INTO employee"+"(empId,empName) VALUES (?,?)";
		getJdbcTemplate().update(sql,new Object[] {employee.getEmpId(), employee.getEmpName()});
	}

	@Override
	public void deleteEmployeeById(String empId) {
		String sql="DELETE from Employee WHERE empId = ?";
		getJdbcTemplate().update(sql, new Object[] {empId});
	}

}
