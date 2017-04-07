/*
 Napisz program, który:
• stworzy tablicę (macierz) 5 x 5 liczb całkowitych,
• wypełnij ją losowymi wartościami z zakresu {−5, −4, . . . , 5},
• dla każdej kolumny wyznacz minimum,
• dla każdej kolumny wyznaczy maksimum.
Program ma wyświetlać tablicę wypełnioną liczbami oraz tablice z minimami oraz
maksymami.
 */
package minmaxin2darray;

import java.util.Random;

/**
 *
 * @author Mariusz Redzimski
 */
public class MinMaxIn2DArray {

    public static void main(String[] args) {

        int[][] matrix = new int[5][5];
        Random r = new Random();
        int[] max = new int[5];
        int[] min = new int[5];

        for (int i = 0; i < 5; i++) {
            max[i] = Integer.MIN_VALUE;
            min[i] = Integer.MAX_VALUE;
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = r.nextInt(11) - 5;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[j][i] < min[i]) {
                    min[i] = matrix[j][i];
                }
                if (matrix[j][i] > max[i]) {
                    max[i] = matrix[j][i];
                }
            }
        }
        System.out.println("Minimum for each column:");
        for (int value : min) {
            System.out.print(value + " ");
        }
        System.out.println("\r\nMaximum for each column:");
        for (int value : max) {
            System.out.print(value + " ");
        }
    }

}
