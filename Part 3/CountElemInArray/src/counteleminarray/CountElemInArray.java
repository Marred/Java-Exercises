/*
Napisać program, który utworzy tablicę 20 liczb całkowitych z przedziału 1 . . . 10,
a następnie wypisze na ekranie ile razy każda z liczb z tego przedziału powtarza
się w tablicy.
 */
package counteleminarray;

import java.util.Random;

/**
 *
 * @author Mariusz Redzimski
 */
public class CountElemInArray {

    public static void main(String[] args) {

        int[] array = new int[20];
        int[] count = new int[10];
        Random r = new Random();
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(10) + 1;
            System.out.print(array[i] + " ");
            count[array[i] - 1]++;
        }
        System.out.println("");
        for (int i = 0; i < count.length; i++) {
            System.out.println((i+1) + " - " + (count[i]));
        }
    }

}
