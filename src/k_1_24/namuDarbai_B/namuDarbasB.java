package k_1_24.namuDarbai_B;

import java.io.*;
import java.util.Arrays;

/*
 * NAMŲ DARBAI 2018-01-24
 *
 *  +  B. Nuskaityti iš tekstinio failo elementus į Matricą ir atsakymus išspausdinti į failą.
 *  +     1. Suskaičiuoti visos matricos sumą, vidurkį
 *  +     2. Suskaičiuoti kiekvienos eilutės sumą, vidurkį
 *       3. Rasti kiekvienos eilutės didžiausią ir mažiausią reikšmę
 *       4. Pašalinti eilutes kurių suma mažesnė nei 5
 */
public class namuDarbasB {

    public static void main(String[] args) {
        try {
            String filePath = "C:\\Coding\\Java_OOP\\src\\k_1_24\\namuDarbai_B\\";

            Integer[][] matrix = skaitytiMatrica(filePath + "readFileB.txt");
            rasytiMatrica(filePath + "writeB0_matrica.txt", matrix);

            String[][] atsakymai = new String[10][];
            int sk = 0;

            atsakymai[sk++] = new String[]{"1. Suskaičiuoti visos matricos sumą, vidurkį"};
            String suma = "Matricos suma = " + sumMatrix(matrix);
            String vidurkis = "Matricos vidurkis = " + averageMatrix(matrix);
            atsakymai[sk++] = new String[]{suma, vidurkis};
            atsakymai[sk++] = new String[]{""};

            atsakymai[sk++] = new String[]{"2. Suskaičiuoti kiekvienos eilutės sumą, vidurkį"};
            // metodas grąžina string masyva su sakiniais 1 eilutės suma = ..., vidurkis = ...
            atsakymai[sk++] = rowSum(matrix);
            atsakymai[sk++] = new String[]{""};

            atsakymai[sk++] = new String[]{"3. Rasti kiekvienos eilutės didžiausią ir mažiausią reikšmę"};
            // metodas grąžina string masyva su sakiniais 1 eil min = ..., max = ...
            atsakymai[sk++] = rowMinMax(matrix);
            atsakymai[sk++] = new String[]{""};

            int sumaMazesneNei = 15;
            atsakymai[sk++] = new String[]{"4. Pašalinti eilutes kurių suma mažesnė nei " + sumaMazesneNei};
            atsakymai = rowRemove5(atsakymai, matrix, sumaMazesneNei);

            // įrašymo į failą metodas kur paduodama string matrica
            // visi matricos naiai atspausdinami atskirose eilutėse
            rasytiMatricaAtsakymai(filePath + "writeB1_actions1234.txt", atsakymai);

        } catch (IOException e) {
            System.out.println("klaida e=" + e);
            e.printStackTrace();
        }
    }


    public static Integer sumMatrix(Integer[][] arr) {

        Integer averageArr = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                averageArr += arr[i][j];
            }
        }
        return averageArr;
    }

    public static Double averageMatrix(Integer[][] arr) {

        Double averageArr = 0.0;
        int sk = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                sk++;
                averageArr += arr[i][j];
            }
        }
        return averageArr / sk;
    }

    public static String[] rowSum(Integer[][] arr) {

        String[] row = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {

            StringBuilder str = new StringBuilder();
            int sum = 0;

            for (int j = 0; j < arr[i].length; j++) {

                sum += arr[i][j];
            }

            str.append(i + 1).append(" eilutės suma = ").append(sum)
                    .append(", vidurkis = ").append((double) sum / arr[i].length);
            row[i] = str.toString();
        }
        return row;
    }

    public static String[] rowMinMax(Integer[][] arr) {

        String[] row = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {

            StringBuilder str = new StringBuilder();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < arr[i].length; j++) {

                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }

            str.append(i + 1).append(" eilutės min reikšmė = ").append(min)
                    .append(", max reikšmė = ").append(max);
            row[i] = str.toString();
        }
        return row;
    }

    public static String[][] rowRemove5(String[][] strArr, Integer[][] arr, int n) {

        for (int i = 0; i < arr.length; i++) {

            String row = "";
            int sum = 0;

            // integer masyvas verčiamas į string eilutę su tarpais ir sumuojami eilutės elementai
            for (int j = 0; j < arr[i].length; j++) {

                row += arr[i][j] + " ";
                sum += arr[i][j];
            }

            // jeigu eilutės elementai mažesni už n string masyvas pridedamas prie matricos
            if (sum >= n) {

                strArr = Arrays.copyOf(strArr, strArr.length + 1);
                strArr[strArr.length - 1] = new String[]{row};
            }
        }
        return strArr;
    }


    // -------------------------------------   F >>
    private static Integer[][] skaitytiMatrica(String failas) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(failas));
        Integer[][] matrica = null;

        try {
            StringBuilder text = new StringBuilder();

            // nuskaityti eilutę
            String line = br.readLine();

            // naudoti while ciklą eilučių nuskaitymui ir for masyvui priskirti reikšmes
            while (line != null) {

                // kuria text eilutę su StringBuilder, System.lineSeparator() - eilutės perkėlimas [enter]
                text.append(line).append(System.lineSeparator());

                // išskaidyti sring eilutę su splt ir priskirt string masyvui
                String[] arrayString = line.split(" ");

                // string masyvą konvertuoti ir priskirti integer masyvui
                Integer[] arrayInteger = new Integer[arrayString.length];
                for (int i = 0; i < arrayString.length; i++) {
                    arrayInteger[i] = Integer.parseInt(arrayString[i]);
                }

                // masyva priskirti matricai sukuriant naują matricą su senosios kopija
                if (matrica == null) { // jeigu priskiriamas pirmasis matricos narys
                    matrica = new Integer[1][];
                    matrica[0] = arrayInteger;
                } else { // jeigu antrasis ir tolimesni nariai
                    matrica = Arrays.copyOf(matrica, matrica.length + 1);
                    matrica[matrica.length - 1] = arrayInteger;
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Failas nerastas");
        } finally {
            br.close();
        }

        return matrica;
    }

    // -------------------------------------   F <<
    private static void rasytiMatrica(String failas, Integer[][] arr) throws IOException {

        BufferedWriter output = null;

        try {
            output = new BufferedWriter(new FileWriter(failas));

            for (int i = 0; i < arr.length; i++) {

                StringBuilder text = new StringBuilder();

                for (int j = 0; j < arr[i].length; j++) {

                    text.append(arr[i][j]).append(" ");
                }

                text.append(System.lineSeparator());
                output.write(text.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }


    private static void rasytiMatricaAtsakymai(String failas, String[][] arr) throws IOException {

        BufferedWriter output = null;

        try {
            output = new BufferedWriter(new FileWriter(failas));

            for (int i = 0; i < arr.length; i++) {

                StringBuilder text = new StringBuilder();

                for (int j = 0; j < arr[i].length; j++) {

                    text.append(arr[i][j]).append(" ");
                    text.append(System.lineSeparator());
                }

//                text.append(System.lineSeparator());
                output.write(text.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }
}


