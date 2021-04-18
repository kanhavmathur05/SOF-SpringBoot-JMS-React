package com.resttemplateexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

	private int id;

	private String empName;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
}
