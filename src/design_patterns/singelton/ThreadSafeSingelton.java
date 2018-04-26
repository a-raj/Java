package design_patterns.singelton;

public class ThreadSafeSingelton {

    private static ThreadSafeSingelton instance;

    private ThreadSafeSingelton() {}

    static synchronized ThreadSafeSingelton getInstance(){
        if (instance == null)
            instance = new ThreadSafeSingelton();

        return instance;
    }

    /*
    * DISADVANTAGES
    *
    * 1. Slow because of synchronized
    * */

}
