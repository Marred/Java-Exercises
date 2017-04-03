/*
 * Napisać program pobierający od użytkownika dwie liczby całkowite A oraz B,
 * A < B, a następnie wyznaczający sumę ciągu liczb od A do B, czyli sumę ciągu
 * (A, A + 1, . . . , B). Obliczenia należy wykonać trzykrotnie stosując kolejno pętle:
 * while, do-while, for.
 */
package sumnumbersinbetween;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class SumNumbersInbetween {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int a = getInput("Please input number A");
        int b;
        while (true) {
            b = getInput("Please input number B");
            if (b > a) {
                break;
            } else {
                System.out.println("Incorrect input - B has to be bigger than A, try again");
            }
        }

        int i = a;
        int sum = 0;

        while (i <= b) {
            sum += i;
            i++;
        }

        System.out.println(sum);

        i = a;
        sum = 0;

        do {
            sum += i;
            i++;
        } while (i <= b);

        System.out.println(sum);

        for (i = a, sum = 0; i <= b; i++) {
            sum += i;
        }

        System.out.println(sum);

    }

    public static int getInput(String message) {
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

}
