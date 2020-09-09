package design_patterns.with_java_8;

import java.util.function.Consumer;

public class MethodChainingExample {

    static class Mailer {

        public Mailer from(String address) {
            System.out.println("form");
            return this;
        }
        public Mailer to(String address) {
            System.out.println("to");
            return this;
        }
        public Mailer subject(String line) {
            System.out.println("subject");
            return this;
        }
        public Mailer body(String text) {
            System.out.println("body");
            return this;
        }
        public static void sent(Consumer<Mailer> block) {
            Mailer mailer = new Mailer();

            block.accept(mailer);
            System.out.println("...sending...");
        }

    }

    public static void main(String[] args) {
        Mailer.sent(mailer ->
                mailer.from("abc@test.com")
                        .to("venkets@test.com")
                        .subject("Your Code doesn't suck")
                        .body("...details..."));
    }
}
