package learn.dynamicMethodDispatch;

public class DynamicMethodDispatch {
	
	public static void main(String[] args) {
		
		A a = new C();
		
		/*
		 * Dynamic method dispatch at the lowest level of the hierarchy.
		 * There is no method called className in the Class C so its find the method in class B which is at the next level of the hierarchy.
		 * */
		a.className();
		
		A a1 = new B();
		a1.className();
	}

}
