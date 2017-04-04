/*
 * Napisać program, który wczytuje liczby podawane przez użytkownika dotąd, dopóki
 * nie podana zostanie liczba 0. Następnie wyświetlić sumę wszystkich podanych
 * liczb.
 */
package displaysum;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class DisplaySum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int temp;
        int sum = 0;

        do {
            while (true) {
                try {
                    System.out.println("Please input an integer");
                    temp = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Incorrect input, try again");
                    scanner.next();
                }
            }
            sum += temp;
        } while (temp != 0);
        System.out.println("The sum is " + sum);
    }
}