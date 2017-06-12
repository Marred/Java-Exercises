/*
Zad. 5. Napisać program, którego zadaniem jest odczytanie danych tabelarycznych w pliku
tekstowym, a następnie zapisanie ich do nowego pliku w postaci kodu HTML.
Przykład:
Wejście:
"Waga" "Wzrost" "BMI" "Nadwaga"
70 1,8 21,6 "NIE"
67 1,77 21,39 "NIE"
85 1,7 29,41 "TAK"
100 1,92 27,13 "TAK"
Wynik:
<html><body>
<table>
<tr><td>"Waga"</td><td>"Wzrost"</td><td>"BMI"</td><td>"Nadwaga"
</td></tr>
<tr><td>70</td><td>1,8</td><td>21,6</td><td>"NIE"
</td></tr>
<tr><td>67</td><td>1,77</td><td>21,39</td><td>"NIE"
</td></tr>
<tr><td>85</td><td>1,7</td><td>29,41</td><td>"TAK"
</td></tr>
<tr><td>100</td><td>1,92</td><td>27,13</td><td>"TAK"</td></tr>
</table>
</body></html>
 */
package generatehtmltable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Mariusz Redzimski
 */
public class GenerateHTMLTable {

    public static void main(String[] args) {
        
        try {
            parseToHtml();
        }
        catch(Exception e) {
            System.out.println("An error occured");
        }
        
    }
    
    private static void parseToHtml() throws IOException {
        
        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
        
        String output = "<html><body>\n<table>";
        
        String currLine;
        
        String[] currArray;
        
        while((currLine=reader.readLine())!= null) {
            output+="<tr>";
            currArray=currLine.split(" ");
            for(String item : currArray) {
                output+="<td>"+item+"</td>";
            }
            output+="</tr>\n";
        }
        output+="</table>\n</body></html>";
        
        FileWriter writer = new FileWriter("data.html");
        writer.write(output);
        writer.close();
    }
    
}
