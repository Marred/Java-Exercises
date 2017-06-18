package unigrades;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Mariusz Redzimski
 */
public class UniGrades {

    public static void main(String[] args) {
        try {
            SaveGrades();
            System.out.println(CountAvarageAndAddECTS());
        }
        catch (Exception e) {
            System.out.println("An error occured");
        }
    }

    private static float CountAvarageAndAddECTS() throws IOException {
        RandomAccessFile file = new RandomAccessFile("file.txt", "rw");

        long filePointer, endFilePointer;

        int semester;
        int ects;
        float grade;

        int numOfSubjects = 0;
        float sumOfGrades = 0;

        try {
            while (true) {
                file.readUTF();
                semester = file.readInt();
                filePointer = file.getFilePointer();
                ects = file.readInt();
                grade = file.readFloat();
                endFilePointer = file.getFilePointer();

                numOfSubjects++;
                sumOfGrades += grade;

                if (grade < 3) {
                    file.seek(filePointer);
                    file.writeInt(ects + semester);
                    file.seek(endFilePointer);
                }
            }
        } catch (Exception e) {
            file.close();
            return sumOfGrades/numOfSubjects;
        }
    }

    private static void SaveGrades() throws IOException {
        RandomAccessFile write = new RandomAccessFile("file.txt", "rw");
        write.writeUTF("Przedmiot1");
        write.writeInt(1);
        write.writeInt(3);
        write.writeFloat(3.0f);

        write.writeUTF("Przedmiot2");
        write.writeInt(2);
        write.writeInt(1);
        write.writeFloat(2.0f);

        write.writeUTF("Przedmiot4");
        write.writeInt(3);
        write.writeInt(4);
        write.writeFloat(4.2f);

        write.writeUTF("Przedmiot3");
        write.writeInt(3);
        write.writeInt(2);
        write.writeFloat(4.5f);

        write.writeUTF("Przedmiot5");
        write.writeInt(5);
        write.writeInt(3);
        write.writeFloat(2.9f);

        write.close();
    }
}
