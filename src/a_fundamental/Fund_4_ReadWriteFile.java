package a_fundamental;

import java.io.*;

public class Fund_4_ReadWriteFile {

    public static void main(String[] args) throws IOException {

        // visi šie failo path nurodymai geri
        // String path = "src/a_fundamental/files/tekstas1.txt";
        // String path = "C:/Coding/Java_OOP/src/a_fundamental/files/tekstas1.txt";
//        String path = "C:\\Coding\\Java_OOP\\src\\a_fundamental\\files\\tekstas1.txt";
        String path = new File("").getAbsolutePath() + "\\src\\a_fundamental\\files\\tekstas1.txt";
        String txt = skaityti(path);

        txt = txt + "+ naujas tekstas";

        System.out.println(txt);

        rasyti(path , txt);
    }

    public static String skaityti(String failas) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            String line = br.readLine();

            StringBuilder textLine = new StringBuilder(); // formuojami string duomenys iš failo

            while (line != null) {

                textLine.append(line).append(System.lineSeparator());

                System.out.println(line);

                line = br.readLine();
            }

            String returnString = textLine.toString();

            return returnString;

        } catch (FileNotFoundException ex) {
            System.out.println("Failas nerastas " + failas);
        } finally {
        }
        return null;
    }

    public static void rasyti(String failas, String txt) {

        try (BufferedWriter output = new BufferedWriter(new FileWriter(failas))) {

            output.write(txt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

