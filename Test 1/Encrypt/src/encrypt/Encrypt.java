package encrypt;

import java.util.Scanner;

/**
 *
 * @author Mariusz Redzimski
 */
public class Encrypt {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String str = getInput("Please input a string to cipher");
        String code = getInput("Please input a code to cipher");
        
        System.out.println("The ciphered message is " + cipher(str, code));
    }

    public static String cipher(String str, String code) {
        String finalStr = "";
        char tempChar;
        int keyIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            tempChar = str.charAt(i);
            if ((tempChar >= 'a' && tempChar <= 'z') || (tempChar >= 'A' && tempChar <= 'Z')) {
                tempChar += (char) code.charAt(keyIndex) % 26;
                if (tempChar > 'z' || (str.charAt(i) <= 'Z' && tempChar > 'Z')) {
                    tempChar = (char) (tempChar - 26);
                }
                keyIndex = keyIndex >= code.length() - 1 ? 0 : keyIndex + 1;
            }
            finalStr+=tempChar;
        }
        return finalStr;
    }

    public static String getInput(String message) {
        String input;
        while (true) {
            try {
                System.out.println(message);
                input = scanner.nextLine();
                return input;
            } catch (Exception e) {
                System.out.println("Sorry, incorrect input. Try again");
            }
        }
    }

}
