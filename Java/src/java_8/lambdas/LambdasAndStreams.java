package java_8.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import static java.util.stream.Collectors.*;

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
		 *  Read more about parallelStream
		 *  Use it very carefully It is like a bulldozer 
		 * 
		 *  ParallelStream says I don't mind using a lot of thread and a lot of resources so I can get the answer faster.
		 * 
		 *  Use ParallelStream when it make sense to use it 
		 *  1. When the problem in hand is  actually parallelisable
		 *  2. When you are willing to spend a lot of Resources to get the result faster
		 *  3. When the data size is big enough you get the benefit in performance
		 *  4. When the task computation is big enough you get the benefit in performance
		 *  
		 *  
		 *  Make sure the performance is good not just use it 
		 * 
		 * */
		System.out.println(
				numbers.parallelStream()
						.filter(e -> e % 2 == 0)
						.mapToInt(e -> e*2)
						.sum());
		
		/*
		 * STREAMS
		 * 
		 * Non mutating pipeline 
		 * 
		 * Some common function in Streams
		 * 
		 * 1. filter : I'm gonna take the value in streams and block some and take some 
		 * 			   input: Stream<T> filter take Predicate<T> filter function take the predicate of type T
		 * 
		 * 2. map : map is a transformation function
		 * 			no of input = output, but no guarantee on the type of output wrt input
		 * 
		 * 			Parameter : Stream<T> map takes Function<T,R> to return Stream<R>
		 * 			Receive a parameter a function that will take the value from the Collection that is coming in and return the output to the Stream   
		 * 			
		 *   Both filter and map stay within their swimlanes
		 *   Reduce cut across the swimlane  
		 *   
		 * 3. reduce : take an initial value, take that value for the operation and produces the result for particular computation and it goes on the same way
		 * 				reduce on Stream<T> takes two parameters:
		 * 				1. first parameter is of type T
		 * 				2. second parameter is of type BiFunction<R, T, R> to produce a result of R, R is the input and the output type
		 * 
		 * 
		 * 4. collect : 
		 * */
		
		
		List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
		
		//double the even values and put that into a list.
		
		//Wrong way to do this
		List<Integer> doubleOfEven = new ArrayList<>();
		
		numbers2.stream()
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2)
				.forEach(doubleOfEven::add);
		
		//Mutability is OK, Sharing is nice, Sharing Mutability is DEVILS WORK
		
		
		
		/* 
		 * collect function that take safety for us
		 **/
		List<Integer> doubleOfEven2 = new ArrayList<>();
		
		numbers2.stream()
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2)
				.collect(toList());
		
		System.out.println(doubleOfEven2);
		
		
		/*
		 * collect : collect is a reduce function 
		 * 			toList()
		 * 			toSet()
		 * 			toMap()
		 * */
		
		
	}
}
	