package learn.generics.boundedType;

/*
 * A Generics example with bounded type
 * */
/**
 * T must be either a Number, or a class derived from Number.
 * */
public class GenericsNumber<T extends Number> {

	T[] number; //array of Number or sub class.
	
	public GenericsNumber(T[] number) {
		this.number = number;
	}
	
	double average(){
		
		return sum()/number.length;
	}
	
	double sum(){
		double sum = 0.0;
		for(int i = 0; i < number.length; i++){
			sum += number[i].doubleValue();
		}
		return sum;
	}
}
