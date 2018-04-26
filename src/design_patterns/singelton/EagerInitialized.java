package design_patterns.singelton;

class EagerInitialized {

    private static final EagerInitialized INSTANCE = new EagerInitialized();

    private EagerInitialized() {
    }

    public static EagerInitialized getInstance() {
        return INSTANCE;
    }

    /*
    * Demerits
    * 1. Already initialized even if not in use
    * 2. Doesn't provide exception handling
    *
    * */
}
