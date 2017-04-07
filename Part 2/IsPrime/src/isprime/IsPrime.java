/*
Napisać program, który sprawdza, czy podana liczba całkowita n, n > 1, jest
liczbą pierwszą.
 */
package isprime;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class IsPrime {
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int num = getInput("Please input the number to check");
        Boolean isPrime = true;
        for(int i = 2; i<num; i++) {
            if(num%i==0) isPrime = false;
        }
        if(isPrime) System.out.println("The number " + num + " is a prime number.");
        else  System.out.println("The number " + num + " is not a prime number.");
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
