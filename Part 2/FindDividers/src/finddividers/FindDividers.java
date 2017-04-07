/*
Napisać program, dla podanej liczby całkowitej wyświetla jej dzielniki. Przykładowo,
dla liczby 21 dzielniki to: 1, 3, 7, 21.
 */
package finddividers;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class FindDividers {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int num = getInput("Please input a positive number");
        for (int i = 1; i <= num; i++) {
            if(num%i==0) System.out.print(i+" ");
        }

    }

    private static int getInput(String message) {
        int input;
        while (true) {
            try {
                System.out.println(message);
                input = scanner.nextInt();
                if (input < 0) {
                    System.out.println("Input must be bigger than 0, try again");
                    continue;
                }
                return input;
            } catch (Exception e) {
                System.out.println("Incorrect input, try again");
                scanner.next();
            }
        }
    }

}
