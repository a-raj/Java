package learn.maps;

import java.util.EnumMap;

public class EnumMapDemo {

	enum Size {
		SMALL,
		MEDIUM,
		LARGE
	}
	public static void main(String[] args) {
		EnumMap<Size, String> enumMap = new EnumMap<>(Size.class);
		
		enumMap.put(Size.LARGE, "C");
		enumMap.put(Size.MEDIUM, "Java");
		enumMap.put(Size.SMALL, "Python");
		
		enumMap.forEach((k, v) -> {
			System.out.println(k + " " + v);
		});
		
	}
	
}
