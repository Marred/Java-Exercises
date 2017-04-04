/*
 * Napisać program, który pobiera od użytkownika ciąg liczb całkowitych. Pobieranie
 * danych kończone jest podaniem wartości 0 (nie wliczana do danych). W następnej
 * kolejności program powinien wyświetlić sumę największej oraz najmniejszej z
 * podanych liczb oraz ich średnią arytmetyczną.

 */
package sumandavg;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class SumAndAvg {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int temp;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (true) {
            while (true) {
                try {
                    System.out.println("Please input an integer");
                    temp = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Incorrect input, please try again");
                    scanner.next();
                }
            }
            if (temp != 0) {
                if (temp < min) {
                    min = temp;
                }
                if (temp > max) {
                    max = temp;
                }
            } else {
                break;
            }
        }
        System.out.println("Sum of the numbers is " + (min + max) + " and the avarage is " + (min + max) / 2f);
    }
}
