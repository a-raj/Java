package design_patterns.with_java_8;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class DecoratingUsingLambda {
    //Decorator Pattern

    private static void  printIt(int n, String msg, Function<Integer, Integer> function) {
        System.out.println("n " + " " + msg + " " +   function.apply(n));
    }

    public static void main1(String[] args) {
        Function<Integer, Integer> increment = e -> e + 1;

        printIt(5, "incremented", increment);
        printIt(10, "incremented", increment);

        Function<Integer, Integer> doubled = e -> e * 2;

        printIt(5, "doubled", doubled);
        printIt(10, "doubled", doubled);


        // No suppose we want to do both increment and double
        // what we can do is we can write another function
        Function<Integer, Integer> incDouble = e -> (e + 1) * 2;

        // but that is not how we should write it we can use andThen of Function

        printIt(5, "increment and doubled", increment.andThen(doubled));
    }

    // --------------------------------
    static class Camera {
        private Function<Color, Color> filter;

        public Camera(Function<Color, Color>... filters) {
           /* filter = input -> input;

            for (Function<Color, Color> aFilter : filters)
                filter = filter.andThen(aFilter);// combining filters
            */

           // making above code more functional
           /*filter = Stream.of(filters)
                   .reduce(input -> input, (aFilter, result) -> result.andThen(aFilter));
           */
           // making above code more readable
            filter = Stream.of(filters)
                    .reduce(Function.identity(), Function::andThen);
        }

        public Color snap(Color input) {
            return filter.apply(input);
        }
    }

    public static void printIt(Camera camera) {
        System.out.println(camera.snap((new Color(125, 125, 125))));
    }

    public static void main(String[] args) {
        printIt(new Camera());
        printIt(new Camera(Color::brighter));
        printIt(new Camera(Color::darker));
        // Now decorator comes into picture
        printIt(new Camera(Color::brighter, Color::darker));
    }

}
