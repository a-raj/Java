package learn.generics;

public class GenericMethodDemo {

	/**
	 * Type is declared before the return type of the function
	 * T is upper bond for V this mean V must be either type T or a sub class of T
	 * Hence isIn can be only called with argument that are comparable with each other
	 * 
	 * */
	static <T, V extends T> boolean isIn(T x, V[] arr){
		for(int i = 0; i < arr.length; i++){
			if(x.equals(arr[i]))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Integer numbers[] = {1, 2, 3, 4, 5};
		
		if(isIn(2,numbers)){
			System.out.println("2 is in numbers");
		}
		
		if(!isIn(10, numbers))
			System.out.println("10 is not in numbers");
		
		String strings[] = {"Hello", "World", "Generic", "Method"};
		
		if(isIn("Hello", strings)){
			System.out.println("Hello is in strings");
		}
	}
}
