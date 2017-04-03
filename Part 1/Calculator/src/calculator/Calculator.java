/*
 * Napisać program realizujący funkcje prostego kalkulatora, pozwalającego na wykonywanie
 * operacji dodawania, odejmowania, mnożenia i dzielenia na dwóch liczbach
 * rzeczywistych. Program ma identyfikować sytuację wprowadzenia błędnego
 * symbolu działania oraz próbę dzielenia przez zero. Zastosować instrukcję switch
 * do wykonania odpowiedniego działania w zależności od wprowadzonego symbolu
 * operacji. Scenariusz działania programu:
 * a) Program wyświetla informację o swoim przeznaczeniu.
 * b) Wczytuje pierwszą liczbę.
 * c) Wczytuje symbol operacji arytmetycznej: +, -, *, /.
 * d) Wczytuje drugą liczbę.
 * e) Wyświetla wynik lub - w razie konieczności - informację o niemożności wykonania
 * działania.
 * f) Program kończy swoje działanie po naciśnięciu przez użytkownika klawisza
 * Enter.
 */
package calculator;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class Calculator {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        calculate();
    }

    public static void calculate() {
        int arg1 = getIntInput("Please input the first argument");
        String symbol = getStringInput("Please input the operation symbol(accepted symbols are +, -, * and :)");
        int arg2 = getIntInput("Please input the second argument");

        switch (symbol) {
            case "+":
                System.out.printf("%d + %d = %d", arg1, arg2, arg1 + arg2);
                break;
            case "-":
                System.out.printf("%d - %d = %d", arg1, arg2, arg1 - arg2);
                break;
            case "*":
                System.out.printf("%d * %d = %d", arg1, arg2, arg1 * arg2);
                break;
            case ":":
                if (arg2 != 0) {
                    System.out.printf("%d : %d = %.2f", arg1, arg2, (float)arg1 / arg2);
                } else {
                    System.out.println("You cannot divide by 0, please try again");
                    calculate();
                }
                break;
            default:
                System.out.println("Incorrect symbol, please try again");
                calculate();
                break;
        }
    }

    public static int getIntInput(String message) {
        while (true) {
            int input;
            try {
                System.out.println(message);
                input = scanner.nextInt();
                return input;
            } catch (Exception e) {
                System.out.println("Incorrect input, try again");
                scanner.next();
            }
        }
    }

    public static String getStringInput(String message) {
        while (true) {
            String input;
            try {
                System.out.println(message);
                input = scanner.next();
                return input;
            } catch (Exception e) {
                System.out.println("Incorrect input, try again");
                scanner.next();
            }
        }
    }
}
