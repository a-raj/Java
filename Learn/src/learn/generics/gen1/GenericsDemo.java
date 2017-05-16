package learn.generics.gen1;

public class GenericsDemo {

	public static void main(String[] args) {
		
		Gen<Integer> objectInt = new Gen<Integer>(123);
		objectInt.showType();
		System.out.println("Value: " + objectInt.getObject());
		
		Gen<String> objectString = new Gen<String>("First Generics Test");
		objectString.showType();
		System.out.println("Value: " + objectString.getObject());
		
	}
	
}
