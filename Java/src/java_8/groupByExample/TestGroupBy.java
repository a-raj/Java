package java_8.groupByExample;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.*;

public class TestGroupBy {
	
	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();
		
		persons.add(new Person("Manish", Gender.MALE, 30));
		persons.add(new Person("Priya", Gender.FEMALE, 26));
		persons.add(new Person("Manya", Gender.FEMALE, 25));
		persons.add(new Person("Tari", Gender.MALE, 30));
		
		
		//given a list of people, create a map where
		//there name is the key and value is all the people with that name
		
		System.out.println(
					persons.stream()
							.collect(groupingBy(Person::getName))
				);
		
		/*
		 * 
		 * GROUPING & MAPPING
		 * Given a list of people, create a map where
		 * there name is the key and value is all the ages of people with that name
		 * 
		 * 
		 * While you are grouping I wanna perform mapping
		 * get the person and get the age of it and get the list of it
		 * */
		System.out.println(
				persons.stream()
						.collect(groupingBy(Person::getName,
								mapping(Person::getAge, toList())))
			);
	
	}
}
