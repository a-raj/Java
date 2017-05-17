package learn.generics.boundedType;
/**
 * A Generics example with bounded type
 * Super class is upper bound
 * T must be either a superclass(Number), or a class derived from superclass(Number) like Integer, Double.
 * */
public class GenericsNumber<T extends Number> {

	T[] number; //array of Number or sub classes.
	
	public GenericsNumber(T[] number) {
		this.number = number;
	}
	
	double average(){
		
		return sum()/number.length;
	}
	
	double sum(){
		double sum = 0.0;
		for(int i = 0; i < number.length; i++){
			//Number class define the doubleValue() method and this method is available to all numeric wrapper classes 
			sum += number[i].doubleValue();
		}
		return sum;
	}
	/**
	 * Determines if two averages are same irrespective of there type(Integer or Double) by using Wildcard(?) argument
	 * ? represents an unknown type
	 * Wildcard simply matches any valid {@link GenericsNumber} objects
	 * */
	boolean sameAverage(GenericsNumber<?> genericsNumber){
		if(average() == genericsNumber.average())
			return true;
		return false;
	}
}
