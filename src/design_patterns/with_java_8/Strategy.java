package design_patterns.with_java_8;

import java.util.List;
import java.util.function.Predicate;

public class Strategy {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9, 10);
        //Sum of all numbers
        System.out.println(totalValue(numbers, e -> true));
        // Sum of Even nos.
        System.out.println(totalValue(numbers, e -> e % 2 == 0));

        // Sum of odd numbers
        System.out.println(totalValue(numbers, e -> e % 2 != 0));
    }

    //Strategy Patter, strategy is to determining what value to total
    // Single function for all the sum
    private static Integer totalValue(List<Integer> numbers, Predicate<Integer> selector) {
        return  numbers.stream()
                .filter(selector)
                .mapToInt(e -> e)
                .sum();
    }






}
