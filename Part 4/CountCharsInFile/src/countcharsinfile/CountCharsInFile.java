/*
 Napisać funkcję liczZnakiSlowa, która zlicza:
 • liczbę znaków w pliku,
 • liczbę białych znaków w pliku (białe znaki to spacja, tabulator, znacznik końca wiersza),
 • liczbę słów w pliku,
Wynikiem funkcji jest tablica złożona z 3 liczb całkowitych po jednej dla wymienionych
podpunktów.
 */
package countcharsinfile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Mariusz Redzimski
 */
public class CountCharsInFile {

    public static void main(String[] args) {
        try {
            SaveFile("file.txt", "Some sample text \n with a new line");
            int[] result = CountChars("file.txt");
            System.out.printf("This file contains %d chars, %d whitespace chars and %d words", result[0], result[1], result[2]);
        }
        catch(Exception e) {
            System.out.println("An error occured");
        }
    }
    
    private static int[] CountChars(String path) throws IOException {
        int[] array = {0,0,0};
        String tempString = "";
        char tempChar;
        FileReader fileReader = null;
        System.out.println("Saving file...");
        try {
            fileReader = new FileReader(path);
            while((tempChar = (char)fileReader.read()) != (char)-1) {
                array[0]++;
                tempString+=tempChar;
                if(Character.isWhitespace(tempChar)) array[1]++;
            }
            array[2] = tempString.split("\\s+").length;
            
        }
        catch(Exception e) {
            System.out.println("An error occured");
        }
        finally {
            if(fileReader!=null) fileReader.close();
            return array;
        }
        
    }
    private static void SaveFile(String path, String content) throws IOException {
        FileWriter fileWriter = null;
        
        try {
            fileWriter = new FileWriter(path);
            fileWriter.write(content);
        }
        catch(Exception e) {
            System.out.println("An error occured.");
        }
        finally {
            if (fileWriter != null) fileWriter.close();
        }
    }
}
