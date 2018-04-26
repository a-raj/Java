package design_patterns.singelton;

class BillPughSingelton {

    /*
    * When the singleton class is loaded,
    * SingletonHelper class is not loaded into memory and only when someone calls the getInstance method,
    * this class gets loaded and creates the Singleton class instance.
    * */

    private BillPughSingelton() {}

    private static class SingeltonHelper {
        private static final BillPughSingelton INSTANCE = new BillPughSingelton();
    }

    static BillPughSingelton getInstance() {
        return SingeltonHelper.INSTANCE;
    }
}
