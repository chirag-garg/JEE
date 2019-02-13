package com.cg.eis.lab6.problem3.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.cg.eis.lab6.problem3.beans.Employee;
import com.cg.eis.lab6.problem3.exception.EmployeeException;
import com.cg.eis.lab6.problem3.service.EmployeeService;

public class Service implements EmployeeService{
	
	
	@Override
	public String creatEmployee(int id, String name, double salary) throws EmployeeException {
		
		String designation ;
		String insuranceScheme;
		if(salary < 3000) {
			throw new EmployeeException();
		}
		if(salary <5000) {
			designation = "Clerk";
			insuranceScheme = "No Scheme";
		}
		else if(salary <20000) {
			designation = "System Associate";
			insuranceScheme = "C Scheme";
		}
		else if(salary <40000) {
			designation = "Programmer";
			insuranceScheme = "B Scheme";
		}
		else {
			designation = "Manager";
			insuranceScheme = "A Scheme";
		}
		
		Employee emp = new Employee(id, name, salary, designation, insuranceScheme);		
		
		try {
			FileOutputStream fos = new FileOutputStream("EmployeeObject.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// write object to file
			oos.writeObject(emp);
			System.out.println("Done");
			// closing resources
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return "Employee added Successfully";
	}

	@Override
	public String display(int id) {
	
		try {
			FileInputStream is = new FileInputStream("EmployeeObject.ser");
			ObjectInputStream ois = new ObjectInputStream(is);
			
			Employee emp;
			while((emp = (Employee) ois.readObject()) != null) {
				if(emp.getId() == id) {
					return "Employee Name : " + emp.getName() + '\n' 
							+ "Employee Salary : "+ emp.getSalary() + '\n' 
							+ "Employee Designation : " + emp.getDesignation() + '\n' 
							+ "Employee Insurance Scheme : " + emp.getInsuranceScheme();
				}
			}			
			ois.close();
			is.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return "Employee id doesn't match to our Database";
	}

	@Override
	public String getInsuranceScheme(int id) {
		
		try {
			FileInputStream is = new FileInputStream("EmployeeObject.ser");
			ObjectInputStream ois = new ObjectInputStream(is);
			
			Employee emp;
			while((emp = (Employee) ois.readObject()) != null) {
				
				return "Employee Insurance Scheme : " + emp.getInsuranceScheme();
				
			}
			
			
			if(emp.getId() == id) {
				
			}
			
			ois.close();
			is.close();
			System.out.println(emp.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Employee id doesn't match to our Database";		
		
	}
 
	
	
}
