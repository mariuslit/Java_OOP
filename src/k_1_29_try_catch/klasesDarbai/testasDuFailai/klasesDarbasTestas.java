package k_1_29_try_catch.klasesDarbai.testasDuFailai;

import java.io.*;
import java.util.Arrays;

public class klasesDarbasTestas {

    public static void main(String[] args) {
        try {
            String filePath = new File("").getAbsolutePath() + "\\src\\k_1_29_try_catch\\klasesDarbai\\testasDuFailai\\";

            String mas = skaityti(filePath + "readFile_1.txt");
            String[] arrStr1 = mas.split(" ");
            Integer[] arrInt1 = toArray(arrStr1);
            double vid1 = getAverageArr(arrInt1);
            int sk1 = gautiKiekSkaciuDidesniuUzVidurki(arrInt1, vid1);
            System.out.println("mas 1 sk=" + sk1 + " vid=" + vid1);

            mas = skaityti(filePath + "readFile_2.txt");
            String[] arrStr2 = mas.split(" ");
            Integer[] arrInt2 = toArray(arrStr2);
            double vid2 = getAverageArr(arrInt2);
            int sk2 = gautiKiekSkaciuDidesniuUzVidurki(arrInt2, vid2);
            System.out.println("mas 2 sk=" + sk2 + " vid=" + vid2);


            if (sk1 > sk2) {

                rasyti(filePath + "writeFile.txt", arrStr1);
            } else {

                rasyti(filePath + "writeFile.txt", arrStr2);
            }

        } catch (IOException e) {
            System.out.println("klaida e=" + e);
            e.printStackTrace();
        }
    }

    public static Integer[] toArray(String[] arr) {

        Integer[] str = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {

            str[i] = Integer.parseInt(arr[i]);
        }
        return str;
    }

    public static Double getAverageArr(Integer[] arr) {

        Double averageArr = 0.0;

        for (int i = 0; i < arr.length; i++) {
            averageArr += arr[i];
        }
        return averageArr / arr.length;
    }

    public static int gautiKiekSkaciuDidesniuUzVidurki(Integer[] arr, Double avr) {

        int number = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > avr) {

                number++;
            }
        }
        return number;
    }

    public static Integer[] addElment(Integer[] arr, Integer element) {

        Integer[] arr2 = Arrays.copyOf(arr, arr.length + 1);
        arr2[arr2.length - 1] = element;
        return arr2;
    }

    // -------------------------------------   F >>
    private static String skaityti(String failas) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(failas));
        String visosEiluts = "";

        try {

            String line = br.readLine();

            while (line != null) {

                visosEiluts += line + " ";
                line = br.readLine();
            }


        } catch (FileNotFoundException ex) {
            System.out.println("Failas nerastas");
        } finally {
            br.close();
        }

        return visosEiluts;
    }

    // -------------------------------------   F <<
    private static void rasyti(String failas, String[] arr) throws IOException {

        BufferedWriter output = null;

        try {
            output = new BufferedWriter(new FileWriter(failas));
            StringBuilder text = new StringBuilder();

            for (int i = 0; i < arr.length; i++) {
                text.append(arr[i]).append(" ");
            }

            output.write(text.toString());
            text.append(System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }
}


