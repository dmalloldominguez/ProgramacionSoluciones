package tema1;

import java.util.Random;
import java.util.Scanner;

public class Exercise30 {
    public static void main(String[] args) {
        System.out.println("Calculadora. Acepta: + - / * %");

        Scanner scanner = new Scanner(System.in);
        boolean validOperator = true;
        while (validOperator) {
            System.out.print("Introduce primer operando: ");
            double operand1 = scanner.nextDouble();
            System.out.print("Introduce operador: ");
            String operador = scanner.next();
            System.out.print("Introduce segundo operando: ");
            double operand2 = scanner.nextDouble();
            double result = operand1;
            if (operador.equals("+")) {
                result += operand2;
            } else if (operador.equals("-")) {
                result -= operand2;
            } else if (operador.equals("*")) {
                result *= operand2;
            } else if (operador.equals("/")) {
                result /= operand2;
            } else if (operador.equals("%")) {
                result %= operand2;
            } else {
                validOperator = false;
            }
            if (validOperator) System.out.println("Resultado: " + result);
        }
    }
}
