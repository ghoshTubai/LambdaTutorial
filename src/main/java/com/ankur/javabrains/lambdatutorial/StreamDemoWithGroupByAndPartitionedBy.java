package com.ankur.javabrains.lambdatutorial;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;

import com.ankur.javabrains.model.Employee;
		

public class StreamDemoWithGroupByAndPartitionedBy {

	public static void main(String[] args) {
				List<Employee> list = Arrays.asList(new Employee("Ankur", "23GY76","TCS", 68800, "397690"),
				new Employee("Abhishek", "5YTG56","AMEX", 60000, "397713"),
				new Employee("Sowmya", "UTV45T","INFOSYS", 67000, "487654"),
				new Employee("Kalyan", "66TTRE","SYNTEL", 68666, "500765"),
				new Employee("Moupriya", "90GF43","GOOGLE", 87067, "397731"),
				new Employee("Pitambar", "746FDH","AMEX", 70456, "500345"),
				new Employee("Vishwas", "TT32VY","INFOSYS", 66545, "567453"),
				new Employee("Rohit", "34TF57","TCS", 90000, "323456")) ;
		
		System.out.println("Obtained TCS and non TCS based employee using Partition by......");
		System.out.println(list.stream().collect(partitioningBy((Employee e)->e.getCompany().equalsIgnoreCase("TCS"))));
		System.out.println("Obtained TCS and non TCS based employee using group by......");
		System.out.println(list.stream().collect(groupingBy((Employee e)->e.getCompany().equalsIgnoreCase("TCS"))));
		System.out.println("count TCS and non TCS based employee using Partition by......");
		System.out.println(list.stream().collect(partitioningBy((Employee e)->e.getCompany().equalsIgnoreCase("TCS"), counting())));
		System.out.println("count TCS and non TCS based employee using group by......");
		System.out.println(list.stream().collect(groupingBy((Employee emp)->emp.getCompany().equalsIgnoreCase("TCS"), counting())));
		System.out.println("Obtained Employee of each Company and count them using group by");
		System.out.println(list.stream().collect(groupingBy((Employee e)-> e.getCompany())));
		System.out.println(list.stream().collect(groupingBy((Employee e)-> e.getCompany(),counting())));
		System.out.println("Obtained TCS and non TCS based employee and map their name to upper case using Partition by......");
		Predicate<Employee> pred = (Employee e)->e.getCompany().equalsIgnoreCase("TCS");
		System.out.println(list.stream().collect(partitioningBy(pred, mapping((Employee e)->e.getName().toUpperCase(), toList()))));
		System.out.println("Obtained TCS and non TCS based employee and map their name to upper case using grouping by......");
		System.out.println(list.stream().collect(groupingBy((Employee e)->e.getCompany(), mapping((Employee e)->e.getName().toUpperCase(), toList()))));
	}
	
}
