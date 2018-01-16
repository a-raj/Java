package collections.maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapDemo {

	public static void main(String[] args) {
		
		//Normal LinkedHashMap which maintain the insertion order
		LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("Ten", 10);
		linkedHashMap.put("Nine", 9);
		linkedHashMap.put("eight", 8);
		linkedHashMap.put("random", 456);
		
		//Normal LinkedHashMap doesn't modify when we access some key value
		//It maintain insertion order
		linkedHashMap.forEach((k, v) -> {
			System.out.println(k + " : " + v);
		});
		System.out.println(linkedHashMap.get("random"));
		
		linkedHashMap.forEach((k, v) -> {
			System.out.println(k + " : " + v);
		});
		
		
		//With Access order it follows LRU list recently used
		LinkedHashMap<String, Integer> linkedHashMapWithAccessOrder = new LinkedHashMap<>(10, 0.5f, true);
		
		linkedHashMapWithAccessOrder.putAll(linkedHashMap);
		
		Set<Map.Entry<String, Integer>> setWithAccessOrder = linkedHashMapWithAccessOrder.entrySet();
		System.out.println("\nLinked Hash Map With Access Order");
		setWithAccessOrder.forEach(System.out::println);
		
		//Access something
		System.out.println(linkedHashMapWithAccessOrder.get("Ten"));
		System.out.println(linkedHashMapWithAccessOrder.get("Nine"));
		
		linkedHashMapWithAccessOrder.forEach((k, v) -> {
			System.out.println(k + " : " + v);
		});
		
		
	}
	
}
