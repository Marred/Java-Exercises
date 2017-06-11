/*
Zadanie polega na stworzeniu dwóch funkcji:
 void szyfruj(String nazwaWe, int przesun)
 void deszyfruj(String nazwaWe, int przesun)
Funkcja szyfruj dokonuje szyfrowania pliku, którego nazwa podana została jako pierwszy parametr.
Szyfrowanie polega na zamianie każdej litery na znak przesunięty o wartość podaną drugim
parametrem np. dla przesunięcia równego 2 literka 'a' powinna zostać zastąpiona literką 'c', literka
'z' literką 'b' itp.
 */
package filecipher;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mariusz Redzimski
 */
public class FileCipher {

    public static void main(String[] args) {
        try {
            System.out.println("Ciphering...");
            Cipher("file.txt", 20);
            System.out.println("Deciphering...");
            Decipher("_file.txt", 20);
        } catch (IOException ex) {
            Logger.getLogger(FileCipher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void Cipher(String path, int modifier) throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = new FileWriter("_" + path);
        String output = "";
        int currChar;

        try {
            fileReader = new FileReader(path);

            while ((currChar = fileReader.read()) != -1) {
                if ((currChar >= 'a' && currChar <= 'z') || (currChar >= 'A' && currChar <= 'Z')) {

                    currChar += modifier;
                    if ((currChar > 'z') || (currChar > 'Z' && currChar < 'a')) {
                        currChar -= 26;
                    }
                }
                output += (char) currChar;
            }
            System.out.println(output);
            fileWriter.write(output);
        } catch (Exception e) {
            System.out.println("An error occured");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
            if (fileWriter != null) fileWriter.close();
        }
    }

    private static void Decipher(String path, int modifier) throws IOException {
        Cipher(path, (modifier * -1));
    }
}
