package tema1;

import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escribe una cantidad en $:");
        double dollars = scanner.nextDouble();
        double euros = dollars * 0.95;
        System.out.println("Son " + euros + "€");
    }
}
