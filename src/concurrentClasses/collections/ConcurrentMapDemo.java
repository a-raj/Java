package concurrentClasses.collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentMapDemo {
	
	public static void main(String[] args) {
		
		/*
		 * ConcurrentMap and its implementation ConcurrentHashMap
		 * */
		ConcurrentMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
		concurrentHashMap.put("One", 1);
		concurrentHashMap.putIfAbsent("Two", 2);
		concurrentHashMap.putIfAbsent("One", 1);
		concurrentHashMap.forEach((k,v) -> System.out.println(k +" , " + v));
		
		/*
		 * ConcurrentNavigableMap and its implementation ConcurrentSkipListMap
		 * */
		ConcurrentNavigableMap<String, Integer> concurrentNavigableMap = new ConcurrentSkipListMap<>();
		concurrentNavigableMap.put("One", 1);
		concurrentNavigableMap.put("Two", 2);
		concurrentNavigableMap.put("Three", 3);
		concurrentNavigableMap.put("Four", 4);
		concurrentNavigableMap.put("Five", 5);
		concurrentNavigableMap.put("Six", 6);

		System.out.println("ConcurrentNavigableMap");
		concurrentNavigableMap.forEach((k,v) -> System.out.println(k +" , " + v));
		
		System.out.println("Head Map");
		concurrentNavigableMap.headMap("Three", true).forEach((k,v) -> System.out.println(k +" , " + v));
		
	}

}
