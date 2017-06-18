package correcttext;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Mariusz Redzimski
 */
public class CorrectText {

    public static void main(String[] args) {
        try {
            Save();
            Correct();
        } catch (Exception e) {
            System.out.println("An error occured.");
        }
    }

    private static void Save() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"));
        bw.write("This is  some sample text , that I want this script to correct.  let's see how   it works , shall we.");
        bw.close();
    }

    private static void Correct() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("correct_file.txt", true));

        String currLine;

        while ((currLine = br.readLine()) != null) {
            currLine = currLine.replace(" . ", ". ");
            currLine = currLine.replace(" .", ". ");
            currLine = currLine.replace(".", ". ");
            
            currLine = currLine.replace(" , ", ", ");
            currLine = currLine.replace(" ,", ", ");
            currLine = currLine.replace(",", ", ");

            currLine = currLine.replace("  ", " ");
            currLine = currLine.replace("  ", " ");
            
            for (int i = 0; i < currLine.length(); i++) {
                if (currLine.charAt(i) == '.' && i + 2 < currLine.length()) {
                    if (currLine.charAt(i + 2) > 'a' && currLine.charAt(i + 2) < 'z') {
                        currLine = currLine.substring(0, i + 2) + currLine.substring(i+2, i+3).toUpperCase() + currLine.substring(i + 3);
                    }
                }
            }
            bw.write(currLine);
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}
