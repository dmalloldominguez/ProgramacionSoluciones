package tema1;

import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        int number1 = scanner.nextInt();
        System.out.print("Introduce el segundo número: ");
        int number2 = scanner.nextInt();

        if (number1 > number2) {
            int subtraction = number1 - number2;
            System.out.println("Resta: " + subtraction);
        } else {
            int subtraction = number2 - number1;
            System.out.println("Resta: " + subtraction);
        }

        /*
        // This code gets the same result with only one line, do you understand it?
        System.out.println("Resta: " + Math.abs(number1-number2);
        */

    }
}