package k_1_23_klasesDarbai;

import java.io.*;

public class SkaitymasIrRasymas {

    public static void main(String[] args) {
        String file = "C:\\Coding\\Java_OOP\\src\\k_1_23_klasesDarbai\\Test.txt";
        String fileRasymui = "C:\\Coding\\Java_OOP\\src\\k_1_23_klasesDarbai\\Irasytas.txt";
        try {
            Integer[] nuskaitytiSkaiciai = skaityti(file);
            Integer gautaSuma = Suma(nuskaitytiSkaiciai);
            rasyti(fileRasymui, gautaSuma);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Integer Suma(Integer[] skaiciuMasyvas) {
        Integer suma = 0;
        for (int i = 0; i < skaiciuMasyvas.length; i++) {
            suma += skaiciuMasyvas[i];
        }
        return suma;
    }

    private static Integer[] skaityti(String failas) throws IOException {

        Integer[] masyvas = null;
        BufferedReader br = new BufferedReader(new FileReader(failas));

        try {
            StringBuilder sb = new StringBuilder();
            String nReiksme = br.readLine();
            Integer n = Integer.parseInt(nReiksme);
            masyvas = new Integer[n];
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                String[] skaiciai = line.split(" ");
                for (int i = 0; i < skaiciai.length; i++) {
                    masyvas[i] = Integer.parseInt(skaiciai[i]);
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Failas nerastas");
        } finally {
            br.close();
        }

        return masyvas;
    }

    private static void rasyti(String failas, Integer ats) throws IOException {
        BufferedWriter output = null;
        try {
            output = new BufferedWriter(new FileWriter(failas));
            output.write("Gauta suma lygi = " + ats);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

}
