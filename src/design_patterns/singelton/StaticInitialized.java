package design_patterns.singelton;

class StaticInitialized {
    /*
    * Same as Eager initialize
    * Except the exception handling part
    * */
    private static StaticInitialized instance;

    private StaticInitialized() {
    }

    static {
        try {
            instance = new StaticInitialized();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
    public static StaticInitialized getInstance() {
        return instance;
    }

}
