/*
Napisać program działający w trybie konsolowym (tekstowym) i rysujący na ekranie
prostokąt. Użytkownik podaje znak wypełnienia prostokąta, pozycję lewego
górnego rogu prostokąta (x, y) oraz długości boków prostokąta (ab). Przyjmujemy,
że lewy górny narożnik konsoli ma współrzędne (x, y) = (1, 1).
 */
package drawrectangle;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class DrawRectangle {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int posX = getIntInput("Please input the X position of the rectangle");
        int posY = getIntInput("Please input the Y position of the rectangle");
        int sizeX = getIntInput("Please input size of the rectangle on the X axis");
        int sizeY = getIntInput("Please input size of the rectangle on the Y axis");
        char fill = getCharInput("Please input the character that will fill the rectangle");

        for (int i = 0; i <= posY + sizeY; i++) {
            for (int j = 0; j <= posX + sizeX; j++) {
                if (i > posY&&j<posX) {
                    System.out.print(" ");
                } else if(i>posY&&j>posX) {
                    System.out.print(fill);
                }
            }
            System.out.println("");
        }
    }

    public static int getIntInput(String message) {
        while (true) {
            int input;
            try {
                System.out.println(message);
                input = scanner.nextInt();
                if (input < 0) {
                    System.out.println("The number must be higher than 0. Try again");
                    continue;
                }
                return input;
            } catch (Exception e) {
                System.out.println("Incorrect input, try again");
                scanner.next();
            }
        }
    }
    public static char getCharInput(String message) {
        while (true) {
            char input;
            try {
                System.out.println(message);
                input = scanner.next().charAt(0);;
                return input;
            } catch (Exception e) {
                System.out.println("Incorrect input, try again");
                scanner.next();
            }
        }
    }
}
