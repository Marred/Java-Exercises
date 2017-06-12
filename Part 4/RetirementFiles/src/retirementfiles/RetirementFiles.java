/*
 Napisać funkcję emerytura(String nazwaPliku), która wczyta z pliku o podanej nazwie dane
pracowników zapisane w kolejnych wierszach w następujący sposób:
 Imię Nazwisko Płeć Wiek
Przykład:
 Tomasz Nowak M 45
 Marta Ziobro K 42
 Jan Kowalski M 27
 Ewelina Tusk K 59
Następnie funkcja dla każdego pracownika powinna wyznaczyć ile lat pozostało do jego emerytury.
Wyniki należy zapisać w następujący sposób:
 Nazwisko Imię "Lata do emerytury"
 */
package retirementfiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Mariusz Redzimski
 */
public class RetirementFiles {

    public static void main(String[] args) {
        try {
            retirement();
        } catch (Exception e) {
            System.out.println("An error occured");
        }
    }

    private static void retirement() throws IOException {

        FileWriter fWriter = new FileWriter("females.txt", true);
        FileWriter mWriter = new FileWriter("males.txt", true);

        BufferedReader reader = new BufferedReader(new FileReader("retirementlist.txt"));

        String currLine;
        String[] currArray;

        while ((currLine = reader.readLine()) != null) {
            currArray = currLine.split(" ");
            currLine = currArray[1] + " " + currArray[0] + " " + (65 - Integer.parseInt(currArray[3])) + "\n\r";
            if (currArray[2].equals("M")) {
                mWriter.write(currLine);
            } else {
                fWriter.write(currLine);
            }
        }
        fWriter.close();
        mWriter.close();
    }
}
