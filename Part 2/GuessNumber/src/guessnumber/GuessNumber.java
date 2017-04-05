/*
 * Gra w ”Za dużo, za mało”. Komputer losuje liczbę z zakresu 1 . . . 100, a gracz
 * (użytkownik) ma za zadanie odgadnąć, co to za liczba poprzez podawanie kolejnych
 * wartości. Jeżeli podana wartość jest:
 * • większa – wyświetlany jest komunikat „Podałeś za dużą wartość”,
 * • mniejsza – wyświetlany jest komunikat „Podałeś za małą wartość”,
 * • identyczna z wylosowaną – wyświetlany jest komunikat „Gratulacje” i gra
 * się kończy.
 */
package guessnumber;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class GuessNumber {

            private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        

        Random r = new Random();
        int guess;
        int goal = r.nextInt(101);
        
        System.out.println("Let's play a game! I'll generate a random number in a range of 0 to 100, guess what number it is to win!");
        while(true) {
            guess = getInput("Take a guess!");
            if(guess==goal) {
                break;
            }
            else if(guess<goal) {
                System.out.println("Nope, too low. Try again!");     
            }
            else if(guess>goal) {
                System.out.println("Nope, too high. Try again!");
            }
        }
        System.out.println("Bingo! The number was " + goal);  
    }
    
    public static int getInput(String message) {
        while (true) {
            int input;
            try {
                System.out.println(message);
                input = scanner.nextInt();
                if(input<0||input>100)
                {
                    System.out.println("The number must be in a range of 0 to 100. Try again");
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
