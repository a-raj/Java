package java8.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdasAndStreams {

	public static void main(String[] args) {
	
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		for(int i = 0; i < numbers.size(); i++)
			System.out.print(numbers.get(i) + " ");
		System.out.println();
		
		for(int e : numbers)
			System.out.print(e + " ");
		System.out.println();
		
		
		//internal iterators
		numbers.forEach(new Consumer<Integer>() {
			public void accept(Integer value) {
				System.out.print(value + " ");
			}
		});
		System.out.println();
		
		//With Lambdas
		
		/*
		 * Take a collection of numbers (numbers.forEach)'
		 * You gonna get a integer (Integer value)
		 * Take that integer print the value
		 * */
		numbers.forEach((Integer value) -> System.out.print(value + " "));
		System.out.println();
		
		/*
		 *  Type integer is obvious so remove it
		 *  Java 8 has type interface, but only for lambda expressions.
		 *  Parenthesis is optional, but only for one parameter lambdas.
		 * */
		numbers.forEach(value -> System.out.print(value + " "));
		
		System.out.println();
		
		//Method reference syntax ::
		
		/*
		 * Method reference are useful only when you don't want to manipulate the value, just pass throughEk
		 * can be used with static method also
		 * */
		numbers.forEach(System.out::println);
		
		numbers.stream()
						.map(e -> e.toString())
						.map(String::toString)
						.forEach(System.out::println);
		
		
		/*
		 * We got the stream and we call the reduce function and
		 * reduce function says It take 2 parameters
		 * First is 0 our initial value and the second is lambda expression
		 * Lambda expression says take value total and element and call the sum function on Integer and 
		 * pass the total and element and get the total
		 * 
		 * ORDER is very important in method references
		 * */
		System.out.println(
				numbers.stream()
							.reduce(0,(total, e) -> Integer.sum(total, e)));
		
		
		//Method reference with two argument 
		System.out.println(
				numbers.stream()
							.reduce(0, Integer::sum));
		
		
		/*
		 * First parameter is target and 2nd is parameter is argument 
		 * In above both are argument
		 * */
		System.out.println(
					numbers.stream()
								.map(String::valueOf)
								.reduce("", (carry, str) -> carry.concat(str) )
				);
		
		
		//Method reference
		System.out.println(
				numbers.stream()
							.map(String::valueOf)
							.reduce("", String::concat)
			);
		
		/*
		 * Limitation of method references
		 * TWO limitation
		 * 1. You can't use them if you are doing any manipulation of data
		 * 2. If there is conflict between a static and instance method
		 * In other word if compiler tries to substitute it with a method if it find there is one method it happy
		 * If it finds two method that can potentially use it, It gives an error 
		 * 
		 * */
		
		
		//IMPERATIVE STYLE CODING
		//double the numbers which are even and get the sum of it
		int result = 0;
		
		for(int e : numbers) {
			if(e % 2 == 0) {
				result += e*2;
			}
		}
		System.out.println(result);
		
		//DECLARITIVE STYLE CODING OR FUNCTIONAL
		
		/*
		 * Think about stream as a fancy iterator
		 * Iterator give us next element the next element ...
		 * 
		 * 
		 * What filter tool says here 
		 * It says given an element, element modulo 2 equals to zero 
		 * It says only give me number equls to zero and block everything else.
		 *  
		 * */
		System.out.println(
			numbers.stream()							//Given a collection		THIS
					.filter(e -> e % 2 == 0)			//Filter the value          IS
					.map(e -> e*2)						//Double them				CALLED
					.reduce(0, Integer::sum));			//and reduce it				FUNCTION
														//							COMPOSITION	
		
		System.out.println(
				numbers.stream()
						.filter(e -> e % 2 == 0)
						.mapToInt(e -> e*2)
						.sum());
		
		/*
		 * Read more about parallelStream
		 * */
		System.out.println(
				numbers.parallelStream()
						.filter(e -> e % 2 == 0)
						.mapToInt(e -> e*2)
						.sum());
	}
}
