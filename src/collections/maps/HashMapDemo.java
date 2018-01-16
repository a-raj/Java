package collections.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
	
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Ten", 10);
		map.put("random", 45726);
		
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		
		set.forEach(System.out::println);
		
		for(Map.Entry<String, Integer> mapEntry: set) {
			System.out.print(mapEntry.getKey());
			System.out.println(" " + mapEntry.getValue());
		}
		
	}

}
