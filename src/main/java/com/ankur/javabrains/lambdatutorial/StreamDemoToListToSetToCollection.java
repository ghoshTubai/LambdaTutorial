package com.ankur.javabrains.lambdatutorial;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ankur.javabrains.model.Person;

public class StreamDemoToListToSetToCollection {

	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person("Ankur","India"),
				new Person("Sowmya","Pakistan"),
				new Person("Rohit","USA"),
				new Person("Samba","USA"),
				new Person("Kalyan","India"),
				new Person("Pita","Brazil"),
				new Person("Arijit","Sweden"),
				new Person("Partha","India"),
				new Person("Swadhin","USA"),
				new Person("Rohit","USA"));
		System.out.println("Use Collectors.toList in order to obtain the USA based person.....");
		System.out.println(list.stream().filter(e->e.getCountry().equalsIgnoreCase("USA"))
				.collect(Collectors.toList()));
		System.out.println("Use Collectors.toSet in order to obtain the USA based person.....");
		System.out.println(list.stream().filter(e->e.getCountry().equalsIgnoreCase("USA"))
				.collect(Collectors.toSet()));						
	}

}

