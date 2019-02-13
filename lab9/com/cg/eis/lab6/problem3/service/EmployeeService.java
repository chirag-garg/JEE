package com.cg.eis.lab6.problem3.service;

import com.cg.eis.lab6.problem3.exception.EmployeeException;

public interface EmployeeService {
	
	String creatEmployee(int id, String name, double salary) throws EmployeeException;
	
	String display(int id);
	
	String getInsuranceScheme(int id);
}