/*
Napisać program rysujący w konsoli „choinkę” złożoną ze znaków gwiazdki (*).
Użytkownik programu powinien podać liczbę całkowitą n, n > 0, określającą
wysokość choinki (liczbę wierszy).
 */
package drawtree;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class DrawTree {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int height = getInput("Please input the height of the tree");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i; j++) {
                System.out.print(" ");
            }
            for(int k = 0; k<=2*i; k++) {
                System.out.print("*");
            }
            for(int l = 0; l<height-i; l++) {
                System.out.print(" ");
            }
            System.out.println("");
        }

    }

    public static int getInput(String message) {
        while (true) {
            int input;
            try {
                System.out.println(message);
                input = scanner.nextInt();
                if (input < 0) {
                    System.out.println("The number must be bigger than 0. Try again");
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
