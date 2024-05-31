package examen3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        List<Figure> figures = new ArrayList<>();
        int option = 0;
        while (option != 5) {
            option = menu();
            switch (option) {
                case 1:
                    addFigure(figures);
                    break;
                case 2:
                    addAccessory(figures);
                    break;
                case 3:
                    showFigures(figures);
                    break;
                case 4:
                    showLimitedEditionFunkos(figures);
                    break;
            }
        }
    }

    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Añadir Figura");
        System.out.println("2. Añadir  Accesorio a Figura de Acción");
        System.out.println("3. Mostrar listado");
        System.out.println("4. Mostrar Funko Pops de edición limitada");
        System.out.println("5. Salir");
        int option = 0;
        while (option < 1 || option > 5) {
            System.out.print("Elige una opción válida: ");
            option = scanner.nextInt();
        }
        return option;
    }

    public static void addFigure(List<Figure> figures) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tipo de figura (accion/estatua/funko): ");
        String type = scanner.nextLine().toLowerCase();
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Año de lanzamiento: ");
        int year = scanner.nextInt();
        System.out.print("Precio base: ");
        double basePrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Estado precintada (1), en su embalaje original (2) o sin embalaje original (cualquier otro valor): ");
        int stateCode = scanner.nextInt();
        scanner.nextLine();
        State state = switch (stateCode) {
            case 1 -> State.SEALED;
            case 2 -> State.ORIGINAL_PACKAGE;
            default -> State.WITHOUT_ORIGINAL_PACKAGE;
        };

        switch (type) {
            case "funko" -> {
                System.out.print("Edición limitada (Sí/No): ");
                boolean limitedEdition = scanner.nextLine().equalsIgnoreCase("Sí");
                FunkoPop funkoPop = new FunkoPop(name, year, basePrice, state, limitedEdition);
                figures.add(funkoPop);
            }
            case "accion" -> {
                ActionFigure actionFigure = new ActionFigure(name, year, basePrice, state);
                figures.add(actionFigure);
            }
            case "estatua" -> {
                System.out.print("Franquicia: ");
                String franchise = scanner.nextLine();
                Statue statue = new Statue(name, year, basePrice, state, franchise);
                figures.add(statue);
            }
            default -> System.out.println("Tipo de figura no válido");
        }
    }

    public static void addAccessory(List<Figure> figures) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre de la figura de acción: ");
        String figureName = scanner.nextLine();
        for (Figure figure : figures) {
            if (figure instanceof ActionFigure) {
                ActionFigure actionFigure = (ActionFigure) figure;
                if (actionFigure.getName().equals(figureName)) {
                    System.out.print("Nombre del accesorio: ");
                    String name = scanner.nextLine();
                    System.out.print("Material del accesorio: ");
                    String material = scanner.nextLine();
                    System.out.print("Descripción del accesorio: ");
                    String description = scanner.nextLine();
                    Accessory accessory = new Accessory(name, material, description);
                    actionFigure.addAccessory(accessory);
                    System.out.println("Accesorio añadido");
                }
            }
        }
    }

    public static void showFigures(List<Figure> figures) {
        for (Figure figure : figures) {
            System.out.printf("Nombre: %s Precio %.2f € Precio real %.2f €\n", figure.getName(), figure.getBasePrice(), figure.getRealPrice());
        }
    }

    public static void showLimitedEditionFunkos(List<Figure> figures) {
        for (Figure figure : figures) {
            if (figure instanceof FunkoPop) {
                FunkoPop funkoPop = (FunkoPop) figure;
                if (funkoPop.getEdicionLimitada()) {
                    System.out.println(funkoPop.getName());
                }
            }
        }
    }

}

