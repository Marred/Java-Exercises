/*
 * Napisać program, który wczytuje od użytkownika liczbę całkowitą dodatnią n, a
 * następnie wyświetla na ekranie wszystkie potęgi liczby 2 nie większe, niż podana
 * liczba.
 */
package powersoftwo;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class PowersOfTwo {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n;
        
        while (true) {
            try {
                System.out.println("Please input a positive integer");
                n = scanner.nextInt();
                if(n>0) break;
                else System.out.println("Incorrect input - the integer has to be positive, try again");
            } catch (Exception e) {
                System.out.println("Incorrect input, try again");
                scanner.next();
            }
        }
        
        for(int i = 0; Math.pow(2, i) < n; i++) {
            System.out.print((int)Math.pow(2, i) + " ");
        }
        
    }
    
}
