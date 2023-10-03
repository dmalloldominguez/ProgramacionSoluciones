package tema0;

import java.util.Scanner;

public class Exercise7 {
    // Comentario de ejemplo
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escribe la cara del dado: ");
        int face = scanner.nextInt();
        if (face >= 1 && face <= 6) {
            System.out.print("La cara opuesta es " + (7 - face));
        } else {
            System.out.println("No es un valor válido");
        }
    }
}
