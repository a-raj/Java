package reflection;

public class ClassDemo {
    private String privateString = null;
    public String publicString = "Public String";
    protected String protectedString = "Protected String";

    public ClassDemo(String privateString){
        this.privateString = privateString;
    }

    private ClassDemo() {}

    private void privateMethod() {
        System.out.println("A Private Method");
    }

    public void publicMethod() {
        System.out.println("A Public Method");
    }

    protected void protectedMethod() {
        System.out.println("A Protected Method");
    }

    void defaultMethod() {
        System.out.println("A Default Method");
    }



    public String getPrivateString() {
        return privateString;
    }

    public void setPrivateString(String privateString) {
        this.privateString = privateString;
    }

    public String getPublicString() {
        return publicString;
    }

    public void setPublicString(String publicString) {
        this.publicString = publicString;
    }

    public String getProtectedString() {
        return protectedString;
    }

    public void setProtectedString(String protectedString) {
        this.protectedString = protectedString;
    }

    public static void main(String[] args) {
        String s = "S";

    }
}
