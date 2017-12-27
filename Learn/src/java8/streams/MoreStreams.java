package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
public class MoreStreams {
	
	public static void main(String[] args) {
		
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
		
		//given an ordered list find the double of the first even number greater than 3
		
		//Imperative style
		int result1 = 0;
		for(int e : numbers) {
			if(e > 3 && e % 2 ==0) {
				result1 = e * 2;
				break;
			}
		}
		System.out.println(result1);
		
		
		
		/*
		 * PERFORMANCE : very bad compare to above one
		 * 8 UNITS of work for the above for loop code
		 * 
		 * 
		 * 20 + 17 + 9 = 46 UNIT OF WORK in this code
		 * */
		System.out.println(
				numbers.stream()
						.filter(e -> e > 3)
						.filter(e -> e % 2 == 0)
						.map(e -> e * 2)
						.findFirst());
		
		
		/*
		 * Another approach
		 * 
		 * Two set of function
		 * Terminal operation :
		 * Intermediate operation : Intermediate operation are operation that are postponed for evaluation
		 * 
		 * In below example all the function are pipelined mean
		 * rather than applying one function on every element and then applying another function on filter element and so on what we do here is
		 * Applying all the operation on one element as many as I can apply
		 * And only when you are done with that element then take the next element and apply all the sequence of operations and so one.  
		 * 
		 * 
		 * So Cost of doing this same as doing it with for loop example
		 * 
		 *  LAZY EVALUATION
		 *  
		 *  This evaluation are only perform when you trigger the terminal operation findFirst()
		 *  If you never trigger the terminal you never evaluating this 
		 *  
		 *  TRY COMMENT OUT findFirst() and you will find that it didn't pass to any of the function at all
		 *  
		 *  LAZY EVALUATION is possible only if the function don't have side effect
		 *  
		 * */
		System.out.println(
				numbers.stream()
						.filter(MoreStreams::isGT3)
						.filter(MoreStreams::isEven)
						.map(MoreStreams::doubleIt)
						.findFirst());
		System.out.println("DONE");
		
		
		
		/*
		 * Characteristics of a Stream: 4 characteristics
		 * 								Size or un-size : bound less no limit to it 
		 * 								Order or UnOrder : first, last
		 * 								Distinct or Non-distinct : Stream might enforce distinct  
		 *  							Sorted or unsorted
		 * */
		
		
		List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
		
		numbers2.stream()
				.filter(e -> e % 2 == 0)
				.sorted()
				.forEach(System.out::println);
		//Sized, Ordered, Non-distinct, Sorted
		
		numbers2.stream()
			.filter(e -> e % 2 == 0)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		
		
		//Infinite Stream
		System.out.println(Stream.iterate(100, e -> e + 1));
		/*
		 * Start with 100, create a series
		 * 100, 101, 102, 103, ...
		 * Infinity with laziness 
		 */
		
		/*
		 * How to tell if a function is lazy is or eager
		 * Look for the return type of the function 
		 * 
		 * 
		 * Any function that return a stream from a stream is lazy
		 * Any function that return other that stream are eager e.g: sum()
		 * */
		
		
		
	}
	
	public static boolean isGT3(int number) {
		System.out.println("isGT3 " + number);
		return number > 3;
	}
	
	public static boolean isEven(int number) {
		System.out.println("isEven " + number);
		return number % 2 == 0;
	}
	
	public static int doubleIt(int number) {
		System.out.println("double " + number);
		return number * 2;
	}
	
	
	/*
	 * Given a number k, and a count n, find the total of double of n
	 * even numbers starting with k, where sqrt of each number is > 20
	 * 
	 * Imagine this problem with imperative style coding
	 * */
	public static int compute(int k, int n) {
		
		return Stream.iterate(k, e -> e + 1)  			//unbounded, lazy
				.filter(e -> e % 2 == 0)				//unbounded, lazy
				.filter(e -> Math.sqrt(e) > 20)			//unbounded, lazy
				.mapToInt(e -> e * 2)					//unbounded, lazy
				.limit(n)								//size, lazy
				.sum();									
	}

}
