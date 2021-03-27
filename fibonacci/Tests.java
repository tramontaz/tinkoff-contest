package space.chemodurov.lab;

public class Tests {

    public static void main(String[] args) {

        test(0);
        test(1);
        test(2);
        test(3);
        test(5);
        test(5);
        test(10);
        test(44);
        test(45);

    }

    private static void test(Integer input) {

        System.out.printf("Input: %d.%n", input);
        System.out.printf("Fibonacci: %d.%n", Fibonacci.fib(input));

    }
}