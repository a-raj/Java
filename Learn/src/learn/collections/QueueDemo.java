package learn.collections;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class QueueDemo {
	
	//compare two string according to there length
	public static class StringLengthComparator implements Comparator<String>{

		@Override
		public int compare(String s1, String s2) {
			return s1.length() - s2.length();
		}
		
	}
	
	public static void main(String[] args) {
		Comparator<String> comparator = new StringLengthComparator();
		
		//PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator.
		PriorityQueue<String> priorityQueue = new PriorityQueue<>(10, comparator);
		
		priorityQueue.add("Zebra");
		priorityQueue.add("Ant");
		priorityQueue.add("Lion");
		priorityQueue.add("Anaconda");
		
		priorityQueue.forEach(System.out::println);
		
		
		//Double ended queue
		Deque<String> deque = new ArrayDeque<>();
		deque.add("Zebra");
		deque.add("Ant");
		deque.add("Lion");
		deque.add("Anaconda");
		System.out.println();
		deque.forEach(System.out::println);
		System.out.println(deque.getLast());
	}

}
