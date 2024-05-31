package examen3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2 {
    final static String FILE_NAME = "funkos.txt";

    public static void main(String[] args) {
        List<FunkoPop> funkos = new ArrayList<>();
        readFunkos(funkos);
        for (FunkoPop funko : funkos) {
            System.out.println(funko);
        }
        int option = 0;
        while (option != 4) {
            option = menu();
            switch (option) {
                case 1:
                    addFunko(funkos);
                    break;
                case 2:
                    deleteFunko(funkos);
                    break;
                case 3:
                    showStats(funkos);
                    break;
            }
        }

    }

    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Añadir Funko Pop");
        System.out.println("2. Borrar Funko Pop");
        System.out.println("3. Mostrar estadísticas");
        System.out.println("4. Salir");
        int option = 0;
        while (option < 1 || option > 4) {
            System.out.print("Elige una opción válida: ");
            option = scanner.nextInt();
        }
        return option;
    }

    public static void readFunkos(List<FunkoPop> funkos) {
        try {
            List<String> lines = Files.readAllLines(Path.of(FILE_NAME));
            for (String line : lines) {
                String[] parts = line.split("#");
                String name = parts[0];
                int year = Integer.parseInt(parts[1]);
                boolean specialEdition = parts[2].equalsIgnoreCase("SÍ");
                double basePrice = Double.parseDouble(parts[3]);
                State state;
                switch (parts[4]) {
                    case "EMBALAJE ORIGINAL":
                        state = State.ORIGINAL_PACKAGE;
                        break;
                    case "SIN EMBALAJE ORIGINAL":
                        state = State.WITHOUT_ORIGINAL_PACKAGE;
                        break;
                    default:
                        state = State.SEALED;
                }
                funkos.add(new FunkoPop(name, year, basePrice, state, specialEdition));
            }
        } catch (Exception e) {
            System.out.println("Error al leer el fichero");
        }
    }

    public static void writeFunkos(List<FunkoPop> funkos) {
        try {
            List<String> lines = new ArrayList<>();
            for (FunkoPop funko : funkos) {
                String specialEdition = funko.getEdicionLimitada() ? "SÍ" : "NO";
                String state;
                switch (funko.getState()) {
                    case ORIGINAL_PACKAGE:
                        state = "EMBALAJE ORIGINAL";
                        break;
                    case WITHOUT_ORIGINAL_PACKAGE:
                        state = "SIN EMBALAJE ORIGINAL";
                        break;
                    default:
                        state = "PRECINTADA";
                }
                lines.add(funko.getName() + "#" + funko.getYear() + "#" + specialEdition + "#" + funko.getBasePrice() + "#" + state);
            }
            Files.write(Path.of(FILE_NAME), lines);
        } catch (Exception e) {
            System.out.println("Error al escribir el fichero");
        }
    }

    public static void addFunko(List<FunkoPop> funkos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Añadir Funko Pop");
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Año de lanzamiento: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Edición especial (Sí/No): ");
        boolean specialEdition = scanner.nextLine().equalsIgnoreCase("Sí");
        System.out.print("Precio base: ");
        double basePrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Estado (precintada, en su embalaje original, sin embalaje original): ");
        State state;
        switch (scanner.nextLine().toLowerCase()) {
            case "precintada":
                state = State.SEALED;
                break;
            case "en su embalaje original":
                state = State.ORIGINAL_PACKAGE;
                break;
            default:
                state = State.WITHOUT_ORIGINAL_PACKAGE;
        }
        funkos.add(new FunkoPop(name, year, basePrice, state, specialEdition));
        writeFunkos(funkos);
    }

    public static void deleteFunko(List<FunkoPop> funkos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Borrar Funko Pop");
        for (int i = 0; i < funkos.size(); i++) {
            System.out.println((i + 1) + ". " + funkos.get(i).getName());
        }
        System.out.print("Elige un Funko Pop a borrar: ");
        int option = scanner.nextInt();
        funkos.remove(option - 1);
        writeFunkos(funkos);
    }

    public static void showStats(List<FunkoPop> funkos) {
        double totalBasePrice = 0;
        int newestYear = Integer.MIN_VALUE;
        int oldestYear = Integer.MAX_VALUE;
        for (FunkoPop funko : funkos) {
            totalBasePrice += funko.getBasePrice();
            if (funko.getYear() > newestYear) {
                newestYear = funko.getYear();
            }
            if (funko.getYear() < oldestYear) {
                oldestYear = funko.getYear();
            }
        }
        System.out.println("Número total de Funko Pop: " + funkos.size());
        System.out.println("Año del Funko Pop más nuevo: " + newestYear);
        System.out.println("Año del Funko Pop más antiguo: " + oldestYear);
        System.out.println("Media de precio base de los Funko Pop: " + totalBasePrice / funkos.size());
    }
}
