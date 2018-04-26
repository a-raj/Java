package design_patterns.singelton;

class LazyInitialize {

    /*
    * Good for single threaded environment
    * */

    private static LazyInitialize instance;

    private LazyInitialize() {}

    public static LazyInitialize getInstance(){
        if (instance == null) {
            instance = new LazyInitialize();
        }
        return instance;
    }
}
