/*
 * Wczytać od użytkownika 3 liczby całkowite i wypisać na ekran największą oraz
 * najmniejszą z nich.
 */
package minmaxnumber;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class MinMaxNumber {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Input the first number");
        int first = scanner.nextInt();
        
        System.out.println("Input the second number");
        int second = scanner.nextInt();
        
        System.out.println("Input the third number");
        int third = scanner.nextInt();
        
        if(first>second&&first>third) {
            if(second>third) {
                MinMax(first,third);
            }
            else {
                MinMax(first,second);
            }
        }
        else if(second>first&&second>third) {
            if(first>third) {
               MinMax(second,third);
            }
            else {
                MinMax(second,first);
            }
        }
        else {
            if(first>second) {
                MinMax(third,second);
            }
            else {
                MinMax(third,first);
            }
        }
    }
    
    public static void MinMax(int max, int min) {
        System.out.printf("The smallest number is %d, the biggest number is %d\n", min, max);
    }
    
}
