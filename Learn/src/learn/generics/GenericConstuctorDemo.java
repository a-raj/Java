package learn.generics;

public class GenericConstuctorDemo {
	
	private double val;
	
	/**
	 * Generic constructor with upper bound {@link Number}
	 * It creates objects of  {@link Number} class or subclasses of Number class
	 * */
	<T extends Number> GenericConstuctorDemo(T arg) {
		val = arg.doubleValue();
	}
	
	void showVal(){
		System.out.println("Value: " + val);
	}
	
	
	public static void main(String[] args) {
		GenericConstuctorDemo int1 = new GenericConstuctorDemo(1000);
		GenericConstuctorDemo double1 = new GenericConstuctorDemo(100.99);
		
		int1.showVal();
		double1.showVal();
	}

}
