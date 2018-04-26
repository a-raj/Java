package design_patterns.singelton;

import java.lang.reflect.Constructor;

public class ReflectionSingletonTest {

    public static void main(String[] args) {

        BillPughSingelton instanceOne = BillPughSingelton.getInstance();
        BillPughSingelton instanceTwo = null;

        try {
            Constructor[] constructors = instanceOne.getClass().getDeclaredConstructors();

            for (Constructor constructor : constructors) {
                //this will destroy the singelton pattern
                constructor.setAccessible(true);

                instanceTwo = (BillPughSingelton) constructor.newInstance();
                break;

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

}
