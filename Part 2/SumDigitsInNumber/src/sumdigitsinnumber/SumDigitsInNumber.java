/*
Napisać program, który pobiera od użytkownika liczbę całkowitą, a następnie:
• oblicza sumę cyfr tej liczby,
• stosunek średniej arytmetycznej cyfr parzystych do średniej arytmetycznej
cyfr nieparzystych.

 */
package sumdigitsinnumber;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class SumDigitsInNumber {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int num = getInput("Please input a number.");
        int temp = 0;
        int sum = 0;
        int unevenSum = 0;
        int uneven = 0;
        int evenSum = 0;
        int even = 0;

        while (num % 10 != 0) {
            temp = num % 10;
            num /= 10;
            sum += temp;
            if (temp % 2 == 0) {
                evenSum += temp;
                even++;
            } else {
                unevenSum += temp;
                uneven++;
            }
        }
        if (uneven != 0 && even != 0) {
            System.out.println("Sum of numbers is " + sum + " and the avarages of even and uneven numbers are " + (evenSum / even) + " and " + (unevenSum / uneven));
        } else if (even != 0) {
            System.out.println("Sum of numbers is " + sum + " and the avarage of even numbers is " + (evenSum / even) + ". There are no uneven numbers");
        }
        else System.out.println("Sum of numbers is " + sum + " and the avarage of uneven numbers is " + (unevenSum / uneven) + ". There are no even numbers");
    }

    private static int getInput(String message) {
        while (true) {
            int input;
            try {
                System.out.println(message);
                input = scanner.nextInt();
                if (input < 0) {
                    System.out.println("Number must be bigger than 0. Try again!");
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
