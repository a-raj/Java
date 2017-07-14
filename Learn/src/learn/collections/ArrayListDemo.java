package learn.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo {
	
	public static void main(String[] args) {
		
		//Creation
		List<Integer> listOfIntegers = Arrays.asList(1, 3, 5, 7, 9);
		
		ArrayList<String> arrayListStrings = new ArrayList<>();
		arrayListStrings.ensureCapacity(100);
		
		listOfIntegers.forEach(System.out::println);
	}

}
