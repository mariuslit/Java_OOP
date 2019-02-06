package a_fundamental;

import java.io.*;

public class Fund_4_ReadWriteFile_minimumas {

    public static void main(String[] args) {
        try {

            skaityti("C:\\Coding\\Java_OOP\\src\\a_fundamental\\files\\fileRead.txt");
            rasyti(  "C:\\Coding\\Java_OOP\\src\\a_fundamental\\files\\fileWrite.txt");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("rado klaidą nėra failo");
        }
    }

    public static void skaityti(String failas) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(failas));

        try {

            String line = br.readLine();
            System.out.println(line);

        } catch (FileNotFoundException ex) {
            System.out.println("Failas nerastas");
        } finally {
            br.close();
        }
    }

    public static void rasyti(String failas) throws IOException {

        BufferedWriter output = null;

        try {

            output = new BufferedWriter(new FileWriter(failas));
            output.write("aaa bbbbbb ccccccccc");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }
}
