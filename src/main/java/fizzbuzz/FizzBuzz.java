package fizzbuzz;

import java.util.function.Predicate;
import static fizzbuzz.Printer.kirjuta;

public class FizzBuzz {

    private final static String fizz = "フィズ";
    private final static String buzz = "バズ";
    private final static String fizzbuzz = fizz + buzz;

    private static void fizzbuzz(int max) {
        Predicate<Integer> divisibleByThree = divisibleBy(3);
        Predicate<Integer> divisibleByFive = divisibleBy(5);

        for (int i = 0; i < max; i++) {
            if (divisibleByFive.test(i) && divisibleByThree.test(i)) {
                kirjuta(fizzbuzz);
            } else if (divisibleByFive.test(i)) {
                kirjuta(buzz);
            } else if (divisibleByThree.test(i)) {
                kirjuta(fizz);
            } else {
                System.out.println("-");
            }
        }
    }

    private static Predicate<Integer> divisibleBy(Integer divisor) {
        return i -> i % divisor == 0;
    }


    public static void main(String[] args) {
        fizzbuzz(100);
    }


}
