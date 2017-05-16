package learn.generics.gen1;

public class Gen<T> {

	T object;
	
	Gen(T object){
		this.object = object;
	}
	
	T getObject(){
		return object;
	}
	
	void showType(){
		System.out.println("Type of T is " + object.getClass().getName());
	}
}
