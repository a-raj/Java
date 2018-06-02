package collections.maps;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import collections.QueueDemo;

public class TreeMapDemo {
	
	public static void main(String[] args) {
		
		Comparator<String> comparator = new QueueDemo.StringLengthComparator();
		 
		//Use natural order sorting or the comparator we provide
		//Insert, Delete and find in O(log(n))
		TreeMap<String, Integer> treeMap = new TreeMap<>(comparator);
		
		treeMap.put("Short", 123);
		treeMap.put("very long", 147);
		treeMap.put("medium", 159);
		
		Set<Map.Entry<String, Integer>> set = treeMap.entrySet();
		
		set.forEach(System.out::println);
		 
		 
	}

}
