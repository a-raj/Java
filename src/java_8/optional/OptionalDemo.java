package java_8.optional;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        // CREATING OPTIONAL

        // 1. Creating an empty optional
        Optional<User> userOptional = Optional.empty();

        User user = new User("Thor", 250);

        // 2. Creating with non-null value, it will throw null pointer exception if user is null
        Optional<User> userOptionalNonNull = Optional.of(user);


        // 3. Creating optional with value which may be null
        Optional<User> optionalMayBeNull = Optional.ofNullable(user);


        // CHE

    }
}


class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
