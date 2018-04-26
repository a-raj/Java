package design_patterns.singelton;

public class DoubleCheckLockingSingelton {

    /*
    * Fails because of java memory model
    * Suppose a thread in inside the if block it goes for the object creation an in between thread is stopped,
    * then half constructed object will be set as an instance.
    * */

    private static DoubleCheckLockingSingelton instance;

    private DoubleCheckLockingSingelton() {}

    static DoubleCheckLockingSingelton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLockingSingelton.class) {
                if (instance == null)
                    instance = new DoubleCheckLockingSingelton();
            }
        }
        return instance;
    }
}
