/*
 * Napisać program służący do konwersji wartości temperatury podanej w stopniach
 * Celsjusza na stopnie w skali Fahrenheita (stopnie Fahrenheita = 1.8 * stopnie
 * Celsjusza + 32.0)
 */
package tempcalc;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class TempCalc {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int tempc;
        float tempf;
        
        System.out.println("Please input the temperature in celcius");
        tempc = scanner.nextInt();
        tempf = 1.8f * tempc + 32;
        System.out.println("The temperature in fahrenheit is: " + tempf);
    }
    
}
