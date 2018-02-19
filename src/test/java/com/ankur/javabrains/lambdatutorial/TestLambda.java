package com.ankur.javabrains.lambdatutorial;
import com.ankur.javabrains.model.Employee;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLambda {
	
	static List<Employee> list;
	static LambdaTest test;
	
	@BeforeClass
		public static void initialize() {
		
		list = Arrays.asList(new Employee("Ankur", "23GY76","TCS", 68800, "397690"),
				new Employee("Abhishek", "5YTG56","AMEX", 60000, "397713"),
				new Employee("Sowmya", "UTV45T","INFOSYS", 67000, "487654"),
				new Employee("Kalyan", "66TTRE","SYNTEL", 68666, "500765"),
				new Employee("Moupriya", "90GF43","GOOGLE", 87067, "397731"),
				new Employee("Pitambar", "746FDH","AMEX", 70456, "500345"),
				new Employee("Vishwas", "TT32VY","INFOSYS", 66545, "567453"),
				new Employee("Rohit", "34TF57","TCS", 90000, "323456")) ;
		
				test = new LambdaTest();
	}
	@AfterClass
		public static void destroy() {
		list = null;
	}
	@Test
	public void test() {
		List<Employee> emp = Arrays.asList(new Employee("Kalyan", "66TTRE","SYNTEL", 68666, "500765"));
		Employee empMaxSalary = new Employee("Rohit", "34TF57","TCS", 90000, "323456");
		assertEquals(emp, test.getEmployeeListOACompany(list, "SYNTEL"));
		assertEquals(empMaxSalary, test.getMaxSalaryPersonOfACompany(list, "TCS"));	
	}
	@Test
	public void getEmployeeCountOfACompany() {
		assertEquals(2, test.getEmployeeCountOfACompany(list, "TCS"));
		assertEquals(2, test.getEmployeeCountOfACompany(list, "INFOSYS"));
		assertEquals(2, test.getEmployeeCountOfACompany(list, "AMEX"));
		assertEquals(1, test.getEmployeeCountOfACompany(list, "GOOGLE"));
	}
	@Test
	public void getEmployeeOfAComaneySortedByMaxSalary() {
		List<Employee> emp = Arrays.asList(new Employee("Rohit", "34TF57","TCS", 90000, "323456"),
				new Employee("Ankur", "23GY76","TCS", 68800, "397690"));
		assertEquals(emp, test.getEmployeeListOfACompanySortedBySalary(list, "TCS"));
	}
	
}
