package com.ankur.javabrains.lambdatutorial;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
		List<Person> usaList = list.stream().filter(e->e.getCountry().equals("USA")).collect(toList());
		System.out.println(usaList);
		Map<String,List<Person>> usaMapList =list.stream().collect(groupingBy(p->p.getCountry(),toList()));
		System.out.println(usaMapList.get("USA"));
		System.out.println("Use Collectors.toSet in order to obtain the USA based person.....");
		Set<Person> usaSet=	list.stream().filter(p->p.getCountry().equals("USA")).collect(toSet());
		System.out.println(usaSet);
		Map<String,Set<Person>> usaMapSet=list.stream().collect(groupingBy(p->p.getCountry(),toSet()));
		System.out.println(usaMapSet.get("USA"));
		System.out.println("use Collectors.toCollection(ArrayList::nrw) in order to obtain the ArrayList of US based person....");
		ArrayList<Person> usaArrayList = list.stream().filter(e->e.getCountry().equals("USA")).collect(Collectors.toCollection(ArrayList::new));
		System.out.println(usaArrayList);
							
	}

}

