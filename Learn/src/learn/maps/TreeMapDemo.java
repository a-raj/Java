package learn.maps;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import learn.collections.QueueDemo;

public class TreeMapDemo {
	
	public static void main(String[] args) {
		
		Comparator<String> comparator = new QueueDemo.StringLengthComparator();
		 
		//Use natural order sorting or the comparator we provide
		//Insert, Delete and find in O(log(n))
		TreeMap<String, Integer> treemap = new TreeMap<>(comparator);
		
		treemap.put("Short", 123);
		treemap.put("very long", 147);
		treemap.put("medium", 159);
		
		Set<Map.Entry<String, Integer>> set = treemap.entrySet();
		
		set.forEach(System.out::println);
		 
		 
	}

}
