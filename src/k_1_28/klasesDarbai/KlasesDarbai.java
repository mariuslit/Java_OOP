package k_1_28.klasesDarbai;

import java.io.*;

public class KlasesDarbai {

    /*
        klaeės  darbas 2019-01-28

    + 1 Sukurti metodą, kuris atspausdintų sveikų skaičių masyvą.
      2 Sukurti funkciją į kurią perdavus du skaitmenis bus grąžinama jų suma.
      3 Sukurti metodą, kuris atspausdintų ar perduotas skaičius yra lyginis ar nelyginis.
      4 Sukurti funkciją į kurią perdavus skaičių masyvą bus grąžinamas jų vidurkis.
      5 Sukurti funkciją į kurią perdavus skaičių masyvą bus grąžinamas mažiausias skaičius.
      6 Sukurti funkciją į kurią perdavus skaičių masyvą bus grąžinamas skaičių masyvas kuriame visi skaičiai mažesni už 10.
      7 Sukurti metodą, kuris surikiuotų skaičių masyvą.
      8 Sukurti funkciją į kurią perdavus String masyvą bus grąžinamas ilgiausias žodis.
      9 Sukurti funkciją į kurią perdavus žodį bus grąžinamas vidurinis žodžio simbolis.
    */

    public static void main(String[] args) {
        try {
            String filePath = new File("").getAbsolutePath() + "\\src\\k_1_28\\klasesDarbai\\";

            String mas = skaityti(filePath + "readFileC.txt");
            String[] arrStr = mas.split(" ");
            Integer[] arrInt = toArray(arrStr);

            // 1 Sukurti metodą, kuris atspausdintų sveikų skaičių masyvą.
            atspaudintiIkonsole(arrInt);

            rasyti(filePath + "writeFileC.txt", arrStr);

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

    public static void atspaudintiIkonsole(Integer[] arr) {

        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);
        }
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
