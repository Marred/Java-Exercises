package weatherinfo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Mariusz Redzimski
 */
public class WeatherInfo {

    public static void main(String[] args) {
        try {
            SaveToFile("plik.txt");
            System.out.println(ChangeFeelTemp("plik.txt"));
        }
        catch(Exception e) {
            System.out.println("An error occured.");
        }
    }

    private static float ChangeFeelTemp(String path) throws IOException {
        RandomAccessFile file = new RandomAccessFile(path, "rw");
        float tempSum = 0;
        int humiditySum = 0;
        try {
            long filePointer;
            long endFilePointer;

            float temp;
            float feelTemp;
            int humidity;
            float windSpeed;

            while (true) {
                file.readUTF();
                temp = file.readFloat();
                filePointer = file.getFilePointer();
                feelTemp = file.readFloat();
                humidity = file.readInt();
                windSpeed = file.readFloat();
                endFilePointer = file.getFilePointer();

                tempSum += temp;
                humiditySum += humidity;

                if (windSpeed > 10) {
                    file.seek(filePointer);
                    file.writeFloat(windSpeed + 0.1f * (float) (humidity + temp));
                    file.seek(endFilePointer);
                }
            }
        } catch (Exception e) {
            file.close();
            return tempSum / humiditySum;
        }
    }

    private static void SaveToFile(String path) throws IOException {
        RandomAccessFile file = new RandomAccessFile(path, "rw");
        file.writeUTF("cloudy");
        file.writeFloat(9.15f);
        file.writeFloat(15.5f);
        file.writeInt(101);
        file.writeFloat(5.2f);
                file.writeUTF("partially cloudy");
        file.writeFloat(10.5f);
        file.writeFloat(20.2f);
        file.writeInt(91);
        file.writeFloat(15.7f);
                file.writeUTF("clear sky");
        file.writeFloat(19f);
        file.writeFloat(17.3f);
        file.writeInt(123);
        file.writeFloat(12f);
    }
}
