/*
Napisz program, który pobiera od użytkownika dodatnią liczbę naturalną n i
tworzy tablicę a zmiennych typu logicznego (boolean) o rozmiarze n×n. Następnie
program powinien wypełnić utworzoną tablicę, tak by a[i][j] = true jeżeli liczby
(i+1) oraz (j+1) są względnie pierwsze, tzn. nie mają wspólnych dzielników poza
1. Tak utworzoną tablicę należy wypisać na ekranie, przy czym dla wartości true
należy wyświetlić znak ”+”, natomiast dla wartości false znak ”.”.
 */
package boolarray;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class BoolArray {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int size = getInput("Please input size of the array");
        Boolean[][] array = new Boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i == 0 || j == 0) || !hasCommonDivisor(i + 1, j + 1)) {
                    array[i][j] = true;
                } else {
                    array[i][j] = false;
                }
            }
        }

        System.out.println("Here's your array:");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (array[i][j] == true) {
                    System.out.print("+"+" ");
                } else {
                    System.out.print("."+" ");
                }
            }
            System.out.println();
        }
    }

    static boolean hasCommonDivisor(int a, int b) {
        if (a == b) {
            return true;
        }
        while (b != 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a > 1;
    }

    private static int getInput(String message) {
        int input;
        while (true) {
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
}
