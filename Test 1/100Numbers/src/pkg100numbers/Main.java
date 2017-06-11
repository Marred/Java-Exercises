 package pkg100numbers;

import java.util.Random;

/**
 *
 * @author Mariusz Redzimski
 */
public class Main {

    public static void main(String[] args) {
        
        Random r = new Random();
        
        int temp;
        int[] max = new int[3];
        int evcount = 0;
        int ev = 0;
        int unevcount = 0;
        int unev = 0;
        int poscount = 0;
        
        for(int i = 0; i<100; i++) {
            temp = r.nextInt(201)-100;

            if(temp%2==0){
                ev+=temp;
                evcount++;
            }
            else {
                unev+=temp;
                unevcount++;
            }
            if(temp>0) {
                poscount++;
                if(temp>max[0]) {
                    max[2] = max[1];
                    max[1] = max[0];
                    max[0] = temp;
                }
                else if(temp>max[1]) {
                    max[2] = max[1];
                    max[1] = temp;
                }
                else if(temp>max[2]) {
                    max[2] = temp;
                }
            }
        }
        if(poscount>3) {
            System.out.println("Ratio of even to uneven numbers is " + ((double)(ev/evcount)/(unev/unevcount)) + " and the biggest positive numbers are " + max[0] +", "+max[1]+", "+max[2]);
        }
        else {
            System.out.println("Ratio of even to uneven numbers is " + ((ev/evcount)/(unev/unevcount)) + ". There are not enough positive numbers.");
        }
        
        
    }
    
}
