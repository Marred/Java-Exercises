/*
 * W sklepie ze sprzętem AGD oferowana jest sprzedaż ratalna. Napisz program
 * umożliwiający wyliczenie wysokości miesięcznej raty za zakupiony sprzęt. Danymi
 * wejściowymi dla programu są:
 * • cena towaru (od 100 zł do 10 tyś. zł),
 * • liczba rat (od 6 do 48).
 * Kredyt jest oprocentowany w zależności od liczby rat:
 * • od 6–12 wynosi 2.5% ,
 * • od 13–24 wynosi 5%,
 * • od 25–48 wynosi 10%.
 * Obliczona miesięczna rata powinna zawierać również odsetki. Program powinien
 * sprawdzać, czy podane dane mieszczą się w określonych powyżej zakresach, a w
 * przypadku błędu pytać prosić użytkownika ponownie o podanie danych.
 */
package monthlyinstalments;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class MonthlyInstalments {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int value;
        int installments;
        float finalValue;

        value = getInput("Please input value of bought item(value must be betweeen 100 and 10 000)", 100, 10000);
        installments = getInput("Please input number of monthly installments(must be between 6 and 48)", 6, 48);

        if (installments <= 12) {
            finalValue = 1.025f * value;
        } else if (installments <= 24) {
            finalValue = 1.05f * value;
        } else {
            finalValue = 1.1f * value;
        }

        System.out.printf("Your monthly installment will be %.2f", finalValue / installments);

    }

    public static int getInput(String message, int lowerLimit, int upperLimit) {
        while (true) {
            int input;
            try {
                System.out.println(message);
                input = scanner.nextInt();
                if (lowerLimit <= input && input <= upperLimit) {
                    return input;
                } else {
                    System.out.println("Incorrect input value, try again");
                }
            } catch (Exception e) {
                System.out.println("Incorrect input, try again");
                scanner.next();
            }
        }
    }

}
