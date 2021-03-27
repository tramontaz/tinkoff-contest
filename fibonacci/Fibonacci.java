package space.chemodurov.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    public static void main(String[] args) {
       try(var reader = new BufferedReader(new InputStreamReader(System.in))) {

           String inputStr = reader.readLine();
           if (inputStr == null || inputStr.length() == 0) return;

           Integer input = Integer.parseInt(inputStr);

           System.out.println(fib(input));

       } catch (IOException e) {
           e.printStackTrace();
       } catch (NumberFormatException e) {
           System.out.println("Not a number!");
       }

    }

    public static int fib(Integer input) {
        if (input < 2) {
            return input;
        }

        int f1 = 1;
        int f2 = 1;
        input = input - 2;

        while(input > 0) {
            int temp = f1;
            f1 = f2;
            f2 = f2 + temp;
            input--;
        }
        return f2;
    }
}
