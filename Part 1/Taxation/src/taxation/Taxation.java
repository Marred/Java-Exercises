/*
 * Napisać program obliczający należny podatek dochodowy od osób fizycznych. Program
 * ma pobierać od użytkownika dochód i po obliczeniu wypisywać na ekranie
 * należny podatek. Podatek obliczany jest wg. następujących reguł:
 * • do 85.528 podatek wynosi 18% podstawy minus 556,02 PLN,
 * • od 85.528 podatek wynosi 14.839,02 zł + 32% nadwyżki ponad 85.528,00
 */
package taxation;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class Taxation {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        float income = 0;
        float tax;
        
        System.out.println("Please input your yearly income");
        
        try {
            income = scanner.nextFloat();
        }
        catch(Exception e) {
            System.out.println("Incorrect input");
            System.exit(0);
        }
        
        if(income<85528) {
            tax = (income * 0.18f) - 556.02f;
        }
        else {
            tax = 14839.02f+((income-85528)*0.32f);
        }
        
        System.out.printf("The tax amount for your %.2f of income is %.2f", income, tax);
    }
    
}
