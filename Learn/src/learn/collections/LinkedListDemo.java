package learn.collections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Doubly-linked list implementation of the List and Deque interfaces.
 * */
public class LinkedListDemo {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> linkedList = new LinkedList<>();
		
		List<String> listLinked = new LinkedList<>();
		Deque<String> dequeList = new LinkedList<>();
		
		linkedList.add(1);
		linkedList.add(3);
		linkedList.add(5);
		linkedList.add(7);
		
		linkedList.forEach(System.out::println);
		String message = linkedList.offerLast(9) 
				? "Successfully added"
				: "Not added";
		
		System.out.println(message);
		
	}

}
