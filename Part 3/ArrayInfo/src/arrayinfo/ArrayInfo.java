/*
Napisać program, który:
• utworzy tablicę 10 liczb całkowitych i wypełni ją wartościami losowymi z
przedziału [−10, . . . , 10],
• wypisze na ekranie zawartość tablicy,
• wyznaczy najmniejszy oraz najwięszy element w tablicy,
• wyznaczy średnią arytmetyczną elementów tablicy,
• wyznaczy ile elementów jest mniejszych, ile większych od średniej.
• wypisze na ekranie zawartość tablicy w odwrotnej kolejności, tj. od ostatniego
do pierwszego.
 */
package arrayinfo;

import java.util.Random;

/**
 *
 * @author Mariusz Redzimski
 */
public class ArrayInfo {

    public static void main(String[] args) {
        int[] table = new int[10];
        Random r = new Random();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int avg = 0;
        int smallerThanAvg = 0;
        int biggerThanAvg = 0;
        System.out.println("Elements in table:");
        for (int i = 0; i < table.length; i++) {
            table[i] = r.nextInt((10 - (-10)) + 1) + (-10);
            System.out.print(table[i] + " ");
            if (table[i] < min) {
                min = table[i];
            }
            if (table[i] > max) {
                max = table[i];
            }
            sum += table[i];
        }
        avg = sum / table.length;
        System.out.println("Elements in table in reversed order:");
        for (int i = table.length-1; i >= 0; i--) {
            System.out.print(table[i] + " ");
            if (table[i] < avg) {
                smallerThanAvg++;
            }
            if (table[i] > avg) {
                biggerThanAvg++;
            }
        }
        System.out.println("");
        System.out.println("Max value: " + max + " Min value: " + min + " Avarage: " + avg + " Smaller than avarage: " + smallerThanAvg + " Bigger than avarage: " + biggerThanAvg);

    }

}
