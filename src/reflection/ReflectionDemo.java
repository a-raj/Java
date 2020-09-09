package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReflectionDemo {
    public static void main(String[] args) {

        Class classDemoClass = ClassDemo.class;

        printGetterAndSetter(classDemoClass);

        // Accessing Private fields
        ClassDemo classDemo = new ClassDemo("The Private Value");
        try {
            // To access a private field you will need to call the Class.getDeclaredField(String name) or Class.getDeclaredFields() method
            Field field = ClassDemo.class.getDeclaredField("privateString");

            /*
            * turn off the access checks for this particular Field instance, for reflection only.
            * Now you can access it even if it is private, protected or package scope, even if the caller is not part of those scopes.
            * You still can't access the field using normal code. The compiler won't allow it.
            * */
            field.setAccessible(true);

            String fieldValue = (String) field.get(classDemo);
            System.out.println("Field Value: " + fieldValue);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private static void printGetterAndSetter(Class aClass) {
        Method[] methods = aClass.getMethods();

        for (Method method : methods) {

            if (isGetter(method)) System.out.println("Getter: " + method);
            else if (isSetter(method)) System.out.println("Setter: " + method);

        }
    }


    // A getter method have its name start with "get", take 0 parameters, and returns a value.
    private static boolean isGetter(Method method) {
        return method.getName().startsWith("get") &&
                method.getParameterTypes().length == 0 &&
                !void.class.equals(method.getReturnType());
    }


    // A setter method have its name start with "set", and takes 1 parameter.
    private static boolean isSetter(Method method) {
        return method.getName().startsWith("set") &&
                method.getParameterTypes().length == 1;
    }

}
