package examen2;

import java.util.ArrayList;
import java.util.Scanner;

public class PizzaPOS {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        int option = 0;
        while (option != 7) {
            option = menu();
            switch (option) {
                case 1:
                    products.add(readPizza());
                    break;
                case 2:
                    products.add(readDrink());
                    break;
                case 3:
                    products.add(readDessert());
                    break;
                case 4:
                    deleteProduct(products);
                    break;
                case 5:
                    showTicket(products);
                    break;
                case 6:
                    showTotal(products);
                    break;
            }
        }

    }

    public static int menu() {
        System.out.println("MENÚ");
        System.out.println("1. Añadir Pizza");
        System.out.println("2. Añadir Bebida");
        System.out.println("3. Añadir Postre");
        System.out.println("4. Borrar producto");
        System.out.println("5. Mostrar ticket");
        System.out.println("6. Mostrar total");
        System.out.println("7. Salir");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        while (option < 1 || option > 7) {
            System.out.println("Opción no válida");
            option = scanner.nextInt();
        }
        return option;
    }

    public static Pizza readPizza() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre de la pizza: ");
        String name = scanner.nextLine();
        System.out.print("¿Es gratis? (s/n): ");
        boolean free = scanner.nextLine().equalsIgnoreCase("s");
        System.out.print("Número de ingredientes: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] ingredients = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrediente " + (i + 1) + ": ");
            ingredients[i] = scanner.nextLine();
        }
        return new Pizza(name, free, ingredients);
    }

    public static Drink readDrink() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre de la bebida: ");
        String name = scanner.nextLine();
        System.out.print("¿Es gratis? (s/n): ");
        boolean free = scanner.nextLine().equalsIgnoreCase("s");
        System.out.print("¿Es alcohólica? (s/n): ");
        boolean alcoholic = scanner.nextLine().equalsIgnoreCase("s");
        System.out.print("Tamaño (1. Pequeña, 2. Mediana, 3. Grande): ");
        int size = scanner.nextInt();
        scanner.nextLine();
        Drink.Size drinkSize = Drink.Size.SMALL;
        switch (size) {
            case 2:
                drinkSize = Drink.Size.MEDIUM;
                break;
            case 3:
                drinkSize = Drink.Size.LARGE;
                break;
        }
        return new Drink(name, free, drinkSize, alcoholic);
    }

    public static Dessert readDessert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre del postre: ");
        String name = scanner.nextLine();
        System.out.print("¿Es gratis? (s/n): ");
        boolean free = scanner.nextLine().equalsIgnoreCase("s");
        return new Dessert(name, free);
    }

    public static void deleteProduct(ArrayList<Product> products) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Número de producto a borrar: ");
        int n = scanner.nextInt();
        if (n >= 0 && n < products.size()) {
            products.remove(n);
        }
    }
    public static void showTicket(ArrayList<Product> products) {
        for (Product product : products) {
            System.out.println(product.getConcept() + " - " + product.getPrice() + " €");
        }
    }

    public static void showTotal(ArrayList<Product> products) {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        System.out.println("Total: " + total + " €");
    }
}
