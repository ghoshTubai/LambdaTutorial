package com.ankur.javabrains.lambdatutorial;

import java.util.Arrays;
import java.util.List;

import com.ankur.javabrains.model.People;

public class StreamAllMatch {
	
	static int i=0;
	public static void main(String[] args) {
		List<People> list = Arrays.asList(new People("Ankur","India",29,72),
				new People("Sowmya","Pakistan",28,65),
				new People("Rohit","USA",31,80),
				new People("Samba","USA",29,70),
				new People("Kalyan","India",34,70),
				new People("Pita","Brazil",28,62),
				new People("Arijit","Sweden",29,61),
				new People("Partha","India",34,60),
				new People("Swadhin","USA",31,85)
				);
		System.out.println("Printing AllMatch :: "+list.stream().filter(p->p.getCountry().equals("USA")).allMatch(e->e.getCountry().equals("USA")));
		
		
		list.stream().forEach(System.out::println);
		System.out.println("\nallMatch returns whether all elements of this stream match the provided predicate");
		System.out.println("AllMatch returned "+list.stream().filter(p->p.getCountry().equals("USA")).allMatch(p->{
			boolean flag = p.getCountry().equals("USA");
			System.out.println("[allMatch - COUNTRY='US] pass #"+i++ +" | returns:"+flag);
			return flag;
		}));
	}
}
