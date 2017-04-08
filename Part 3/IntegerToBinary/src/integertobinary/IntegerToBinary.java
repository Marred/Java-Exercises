/*
Napisać program, który wczytuje od użytkownika liczbę całkowitą, a następnie
wyświetla jej reprezentację w kodzie binarnym (ZM). Podczas konwersji liczby
należy kolejne jej bity zapisywać w pomocniczej tablicy liczb całk. o rozmiarze
32. Konwersji należy dokonać korzystając z operacji dzielenia całkowitego oraz
operacji modulo.
 */
package integertobinary;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class IntegerToBinary {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int integer = getInput("Please input the integer to convert");
        int temp;
        int count = 0;
        int[] binary = new int[32];
        
        System.out.println("Your integer in binary:");
        
        if(integer<0) {
            System.out.print("1.");
            integer = Math.abs(integer);
        }

        while (integer != 0) {
            temp = integer % 2;
            integer /= 2;
            binary[binary.length - (1+count)] = temp;
            count++;
        }

        for (int value : binary) {
            System.out.print(value);
        }

    }

    private static int getInput(String message) {
        int input;
        while (true) {
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
