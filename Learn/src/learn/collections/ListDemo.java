package learn.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		
		List<Integer> listOfIntegers = Arrays.asList(1, 3, 5, 7, 9);

		//Array list is simplest of collections it got Resizable-array implementation of the List interface
		ArrayList<String> arrayListStrings = new ArrayList<>();
		arrayListStrings.ensureCapacity(100);
		
		listOfIntegers.forEach(System.out::println);
		
		LinkedList<Integer> linkedList = new LinkedList<>();
		
		List<String> listLinked = new LinkedList<>();
		
		linkedList.add(1);
		linkedList.add(3);
		linkedList.add(5);
		linkedList.add(7);
		
		linkedList.forEach(System.out::println);
		String message = linkedList.offerLast(9) 
				? "Successfully added"
				: "Not added";
		
		System.out.println(message);
		
		listLinked.add("Hello");
		//error cause it is specified by Deque as LinkedList implement both List and Deque interface
		//listLinked.offerLast("World")
	}
}
