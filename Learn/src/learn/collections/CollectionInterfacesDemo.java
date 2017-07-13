package learn.collections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class CollectionInterfacesDemo {

	public static void main(String[] args) {
		
		//Super Interface of all the collection Library
		Collection<Integer> collectionInt = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(collectionInt);
		
		List<Integer> listInt = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(listInt);
		
		Set<String> setStrings = new TreeSet<>();
		
		SortedSet<String> sortedSetStrings = new TreeSet<>();
		
		NavigableSet<String> navigableSet = new TreeSet<>();
		
		Queue<Integer> queueInt = new PriorityQueue<>();
		
		Deque<Integer> dequeInt = new ArrayDeque<>();
		
		
		
	}
}
