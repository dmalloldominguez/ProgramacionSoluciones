package examen1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        char option;
        char[] examTemplate = null;
        do {
            option = readOption();

            switch (option) {
                case 'a':
                    processModuleGrades();
                    break;
                case 'b':
                    examTemplate = readExamTemplate();
                    break;
                case 'c':
                    if (examTemplate != null) {
                        System.out.println("Nota del estudiante (sobre 10): " + correctExam(examTemplate));
                    } else {
                        System.out.println("No se ha introducido la plantilla del examen");
                    }
                    break;
                case 'd':
                    readCycleGrades();
                    break;
                case 'e':
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (option != 'e');

    }

    public static int readValidInt(int min, int max)  {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        while (number < min || number > max) {
            System.out.println("Número no válido. Inténtelo de nuevo.");
            number = scanner.nextInt();
        }
        return number;
    }
    private static char readOnlyabcd() {
        Scanner scanner = new Scanner(System.in);
        char answer = scanner.next().charAt(0);
        while (answer != 'a' && answer != 'b' && answer != 'c' && answer != 'd') {
            System.out.println("Respuesta no válida. Inténtelo de nuevo.");
            answer = scanner.next().charAt(0);
        }
        return answer;
    }
    private static char readOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menú:");
        System.out.println("(a) Introducir notas del módulo");
        System.out.println("(b) Introducir plantilla del examen");
        System.out.println("(c) Corregir un examen");
        System.out.println("(d) Introducir notas del ciclo");
        System.out.println("(e) Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.next().charAt(0);
    }

    private static void processModuleGrades() {
        int numStudents;
        int passCount = 0;

        System.out.print("Introduce el número de estudiantes: ");
        numStudents = readValidInt(0, Integer.MAX_VALUE);

        for (int i = 1; i <= numStudents; i++) {
            System.out.print("Introduce nota del estudiante " + i + ": ");
            int gradeOutOf50 = readValidInt(0, 50);
            double gradeOutOf10 = gradeOutOf50 * 10.0 / 50;
            System.out.println("Nota sobre 10: " + gradeOutOf10);

            if (gradeOutOf10 > 5) {
                passCount++;
            }
        }

        System.out.println("Total de aprobados: " + passCount);
    }
    private static char[] readExamTemplate() {
        System.out.print("Introduce el número de preguntas del examen: ");
        int numQuestions = readValidInt(0, Integer.MAX_VALUE);
        char[] examTemplate = new char[numQuestions];
        for (int i = 0; i < numQuestions; i++) {
            System.out.print("Introduce la respuesta para la pregunta " + (i + 1) + " (a, b, c, d): ");
            examTemplate[i] = readOnlyabcd();
        }

        System.out.println("Plantilla del examen guardada con éxito.");
        return examTemplate;
    }

    private static double correctExam(char[] examTemplate) {
        int numQuestions = examTemplate.length;
        char[] studentAnswers = new char[numQuestions];

        System.out.println("Introduce las respuestas del estudiante:");
        for (int i = 0; i < numQuestions; i++) {
            System.out.print("Respuesta para la pregunta " + (i + 1) + " (a, b, c, d): ");
            studentAnswers[i] = readOnlyabcd();
        }

        return calculateExamGrade(examTemplate, studentAnswers);
    }

    private static double calculateExamGrade(char[] examTemplate, char[] studentAnswers) {
        int correctCount = 0;

        for (int i = 0; i < examTemplate.length; i++) {
            if (studentAnswers[i] == examTemplate[i]) {
                correctCount++;
            }
        }
        double rawGrade = correctCount - ((examTemplate.length - correctCount) / 3.0);
        return Math.max(0, rawGrade * 10.0 / examTemplate.length);
    }

    private static void readCycleGrades() {
        int numStudents = readValidInt(0, Integer.MAX_VALUE);
        int numSubjects = readValidInt(0, Integer.MAX_VALUE);

        int[][] grades = new int[numStudents][numSubjects];

        for (int i = 0; i < grades.length; i++) {
            System.out.println("Notas del estudiante " + (i + 1) + ":");
            for (int j = 0; j < grades[i].length; j++) {
                System.out.print("Nota de la asignatura " + (j + 1) + ": ");
                grades[i][j] = readValidInt(0, 10);
            }
        }

        for (int i = 0; i < grades.length; i++) {
            for (int j = 0; j < grades[i].length; j++) {
                if (grades[i][j] == 10) {
                    System.out.println("El estudiante " + (i + 1) + " es candidato a mención honorífica.");
                    break;
                }
            }
        }
    }
}
