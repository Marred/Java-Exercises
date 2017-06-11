/*
Napisać funkcję:
void szukaj(String nazwaPlikWe, String nazwaPlikWy, String slowo)
której zadaniem jest znalezienie wszystkich wierszy w pliku, które zawierają szukane słowo.
Wszystkie wiersze, które zawierają słowo powinny zostać zapisane w pliku wynikowym wraz z nr
wiersza (z pierwszego pliku). Nazwa pierwszego pliku zapamiętana jest w parametrze
nazwaPlikWe, nazwa pliku wynikowego podana jest w parametrze nazwaPlikWy, natomiast szukane
słowo w parametrze slowo. 
 */
package findwordinline;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mariusz Redzimski
 */
public class FindWordInLine {

    public static void main(String[] args) {
        try {
                    SaveFile("file.txt", "Dzisiaj mam egzamin \n Jutro również mam egzamin \n A pojutrze nie mam \n egzaminy są męczące.");
                    SaveFile("endfile.txt", FindInFile("file.txt", "egzamin"));
        } catch (Exception e) {
            System.out.println("An error occured");
        }

    }
    
    private static String FindInFile(String path, String searchedWord) throws IOException {
        FileReader fileReader = null;
        String returnString = "";
        
        try {
            fileReader = new FileReader(path);
            LineNumberReader lnr = new LineNumberReader(fileReader);
            String line;
            while((line=lnr.readLine())!= null) {
                if(line.contains(searchedWord)) returnString += (lnr.getLineNumber() + ": " + line + '\n');
            }
        }
        catch(Exception e) {
            System.out.println("An error occured");
        }
        finally {
            if(fileReader!=null) fileReader.close();
            return returnString;
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
