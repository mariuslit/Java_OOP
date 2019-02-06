package k_1_29_try_catch.klasesDarbai.skaitymasSuTryCach;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * užduotis sukurti metodą kuris turėtų nuskaityti failą, o neradęs jo nuskaitytų kitą failą, naudoti try - catch
 */
public class Skaitymas {

    public static void main(String[] args) {
        String filePath = "C:\\Coding\\Java_OOP\\src\\k_1_29_try_catch\\klasesDarbai\\skaitymasSuTryCach\\";

        String mas = skaityti(filePath, "readFile_1.txt");
        String[] arrStr1 = mas.split(" ");
        System.out.println("pirmas elementas = " + arrStr1[0]);
    }


    // -------------------------------------   F >>
    private static String skaityti(String filePath, String failas) {
        String visosEiluts = "";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath + failas))) {

            String line = br.readLine();

            while (line != null) {

                visosEiluts += line + " ";
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Failas nerastas");
            visosEiluts = skaityti(filePath, "readFile_2.txt");
        } catch (IOException ex) {
            System.out.println("Įvedimo klaida");
        }

        return visosEiluts;
    }
}
