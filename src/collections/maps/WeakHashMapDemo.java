package collections.maps;

import java.util.WeakHashMap;

public class WeakHashMapDemo {

	public static void main(String[] args) {
		WeakHashMap<Data, String> weakHashMap = new WeakHashMap<>();
		Data data = new Data(12);
		weakHashMap.put(data, "Some String");
		
		data = null;
		
		for(int i = 1; i < 100000; i++) {
			if(!weakHashMap.isEmpty()) {
				System.out.println("At iteration "+ i +  " the map still hold the reference on data object");
			}
			else {
				System.out.println("data  Object has been finally garbage collected at iteration "+ i +" hence the map is now empty");
				break;
			}
		}
	}
	
	static class Data{
		int someNumber;
		Data(int someNumber){
			this.someNumber = someNumber;
		}
	}
}
