package a_fundamental;

import java.io.*;

public class Fund_4_ReadWriteFile {

    public static void main(String[] args) {

        try {
            // visi šie failo path nurodymai geri
            String path = new File("").getAbsolutePath() + "\\src\\a_fundamental\\files\\";
//            String path = "src/a_fundamental/files/";
//            String path = "C:/Coding/Java_OOP/src/a_fundamental/files/";
//            String path = "C:\\Coding\\Java_OOP\\src\\a_fundamental\\files\\";

            skaityti(path + "tekstas1.txt");
            rasyti(path + "tekstas2.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void skaityti(String failas) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            String line = br.readLine();
            StringBuilder textLine = new StringBuilder(); // formuojami string duomenys iš failo

            while (line != null) {

                textLine.append(line);
                textLine.append(System.lineSeparator());

                System.out.println(line);
                line = br.readLine();
            }
            String returnString = textLine.toString();

        } catch (FileNotFoundException ex) {
            System.out.println("Failas nerastas " + failas);
        } finally {
        }
    }

    public static void rasyti(String failas) throws IOException {

        BufferedWriter output = null;

        try {

            output = new BufferedWriter(new FileWriter(failas));
            output.write("šis įrašas randasi faile src/a_fundamental/files/tekstas1.txt");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }
}
