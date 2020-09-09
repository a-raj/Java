package design_patterns.with_java_8;

import java.util.function.Supplier;

public class LazyMethodExample {

    public static void main(String[] args) {
        int x = 4;
        int temp = compute(x);
        if (x > 5 && temp > 7)
            System.out.println("Path 1" + temp);
        else
            System.out.println("Path 2");

        // What happening in the above code is we are calling compute even when it is not needed, to solve this we will use lambda

        Lazy<Integer> lazy = new Lazy<>(() -> compute(x));

        if (x > 5 && lazy.get() > 7)
            System.out.println("Path 1" + lazy.get());
        else
            System.out.println("Path 2");

        //so we can use Supplier to postpone evaluations until a later time so again we lambda is rescuing us.
        // Same lazy can be used for implementing virtual proxy
        //if an object is going to hold on to a reference to a object which is heavyweight we can use a lazy to put reference so the object comes to life
        //if and only if we need it
    }

    private static int compute(int n) {
        System.out.println("Called..");
        return n*2;
    }

    // Delegating using lambdas expression until needed
    static class Lazy<T> {
        private T instance;
        private Supplier<T> supplier;

        public Lazy(Supplier<T> theSupplier) {
            supplier = theSupplier;
        }
        public T get() {
            if (instance == null) {
                instance = supplier.get();
                supplier = null;
            }
            return instance;
        }
    }
}
