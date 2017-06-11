package pkg2darray;

import java.util.Random;

/**
 *
 * @author Mariusz Redzimski
 */
public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        int[][] array = new int[40][40];
        
        for(int i = 0; i<40; i++) {
            for(int j = 0; j<40; j++) {
                if(i%2==0) {
                    array[i][j] = i+j;
                }
                else array[i][j]=r.nextInt(101)-50;
            }
        }
        int temp;
        for(int i = 0; i<40; i++) {
            for(int j = 0; j<20; j++) {
                temp=array[i][j];
                array[i][j] = array[i][39-j];
                array[i][39-j]=temp;
            }
        }
                for(int i = 0; i<40; i++) {
            for(int j = 0; j<40; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
