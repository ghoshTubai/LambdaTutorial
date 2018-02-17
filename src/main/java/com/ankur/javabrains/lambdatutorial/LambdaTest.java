package com.ankur.javabrains.lambdatutorial;
import com.ankur.javabrains.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

import javax.swing.border.EmptyBorder;

public class LambdaTest {
	
	List<Employee> employeeList=initializeEmployee();
	public static void main(String[] args) {
		LambdaTest test = new LambdaTest();
		System.out.println(test.getEmployeeListOACompany(test.employeeList, "SYNTEL"));
	}
	
	/*
	 * Return list of Employee Belongs to a particular employee
	 */
	public List<Employee> getEmployeeListOACompany(List<Employee> list, String comanyName){
				
		return list.stream().filter(e->e.getCompany().equals(comanyName)).collect(Collectors.toList());
	}
	
	public int getEmployeeCountOfACompany(List<Employee> list, String comanyName) {
		return (int)list.stream().filter(e->e.getCompany().equals(comanyName)).count();
	}
	
	public Employee getMaxSalaryPersonOfACompany(List<Employee> list, String compnayName) {
		return list.parallelStream().filter(e->e.getCompany().equalsIgnoreCase(compnayName)).
				max((e1,e2)-> e1.getSalary()-e2.getSalary()).get();
	}
	
	public List<Employee> getEmployeeList() {
		return employeeList;
	}


	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}


	private List<Employee> initializeEmployee(){
		List<Employee> list =
				Arrays.asList(new Employee("Ankur", "23GY76","TCS", 68800, "397690"),
						new Employee("Abhishek", "5YTG56","AMEX", 60000, "397713"),
						new Employee("Sowmya", "UTV45T","INFOSYS", 67000, "487654"),
						new Employee("Kalyan", "66TTRE","SYNTEL", 68666, "500765"),
						new Employee("Moupriya", "90GF43","GOOGLE", 87067, "397731"),
						new Employee("Pitambar", "746FDH","AMEX", 70456, "500345"),
						new Employee("Vishwas", "TT32VY","INFOSYS", 66545, "567453"),
						new Employee("Rohit", "34TF57","TCS", 90000, "323456")) ;
		return list;
	}

}
