package learn.generics.boundedType;

public class TestGeneris {

	public static void main(String[] args) {
		
		Integer intArray[] = {123, 234, 345};
		GenericsNumber<Integer> genInt = new GenericsNumber<Integer>(intArray);
		System.out.println("Average of Integer array "+ genInt.average() + " and the Sum is " + genInt.sum());
		
		Double doubleArray[] = {1.1, 2.2, 3.3, 4.4};
		GenericsNumber<Double> genDouble = new GenericsNumber<Double>(doubleArray);
		System.out.println("Average of double array " + genDouble.average());
		
		Long longArray[] = {123L, 234L, 345L};
		GenericsNumber<Long> genLong = new GenericsNumber<Long>(longArray);
		System.out.println("Average of long array " + genLong.average());
		
		
		//Testing Wildcard argument
		if(genDouble.sameAverage(genInt))
			System.out.println("Average of genDouble and genInt are same.");
		else 
			System.out.println("Average of gen Double and genInt are different");
		
		if(genInt.sameAverage(genLong))
			System.out.println("Average of genInt and genLong are Same");
	}
}
