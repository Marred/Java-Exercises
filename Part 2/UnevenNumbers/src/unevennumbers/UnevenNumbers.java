/*
 * Napisać program, który pobiera od użytkownika liczbę całkowitą dodatnią, a następnie
 * wyświetla na ekranie kolejno wszystkie liczby niepatrzyste nie większe od
 * podanej liczby. Przykład, dla 15 program powinien wyświetlić 1, 3, 5, 7, 9, 11, 13,
 * 15.
 */
package unevennumbers;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class UnevenNumbers {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int input;
        while (true) {
            try {
                System.out.println("Please input a positive integer");
                input = scanner.nextInt();
                if(input>0) break;
                else System.out.println("Incorrect input - the integer has to be positive, try again");
            } catch (Exception e) {
                System.out.println("Incorrect input, try again");
                scanner.next();
            }
        }
        
        for(int i = 0; i <= input; i++) {
            if(i%2==1) System.out.print(i + " ");
        }
    }

}
