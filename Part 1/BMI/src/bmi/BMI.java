/*
 * Napisać program, który oblicza wartość współczynnika BMI (ang. body mass
 * index) wg. wzoru: waga
 * wzrost2 . Jeżeli wynik jest w przedziale (18,5 - 24,9) to wypisuje
 * ”waga prawidłowa”, jeżeli poniżej to ”niedowaga”, jeżeli powyżej ”nadwaga”.
 */
package bmi;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class BMI {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        float weight = 0;
        float height = 0;
        float bmi;

        System.out.println("Please input your weight in kilograms");

        try {
            weight = scanner.nextFloat();
        } catch (Exception e) {
            System.out.println("Incorrect input");
            System.exit(0);
        }

        System.out.println("Please input your height in centimeters");

        try {
            height = scanner.nextFloat() / 100;
        } catch (Exception e) {
            System.out.println("Incorrect input");
            System.exit(0);
        }

        bmi = weight / (float) Math.pow(height, 2);
        if (bmi < 18.5) {
            System.out.printf("You are underweight, your BMI is %.1f", bmi);
        } else if (bmi > 24.9) {
            System.out.printf("You are overweight, your BMI is %.1f", bmi);
        } else {
            System.out.printf("Congratulations, your weight is normal, your BMI is %.1f", bmi);
        }
    }

}
