package k_1_29_try_catch.namuDarbai;

import java.io.*;
import java.util.Arrays;

public class SkaitytiDuomenis {

    public static void main(String[] args) {
        String filePath = new File("").getAbsolutePath() + "\\src\\k_1_29_try_catch\\namuDarbai\\";
        Darbuotojas[] darbuotojai = skaityti(filePath, "Duomenys.txt");
        System.out.println("elementas = " + darbuotojai[1].getAmzius());
    }

    // -------------------------------------   F >>
    private static Darbuotojas[] skaityti(String filePath, String failas) {
        String[] zodis;

        Darbuotojas[] darbuotojai = new Darbuotojas[]{};

        try (BufferedReader br = new BufferedReader(new FileReader(filePath + failas))) {

            String line = br.readLine();

            int sk = 0;
            while (line != null) {

                zodis = line.split(" ");
                Darbuotojas darbuotojas = new Darbuotojas(zodis[0], zodis[1], Integer.parseInt(zodis[2]), zodis[3]);
                darbuotojai = addElement(darbuotojai, darbuotojas);

                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Failas nerastas");
        } catch (IOException ex) {
            System.out.println("Įvedimo klaida");
        } catch (NumberFormatException ex) {
            System.out.println("pagautas ne skaičius");
        }

        return darbuotojai;
    }

    public static Darbuotojas[] addElement(Darbuotojas[] arr, Darbuotojas element) {

        Darbuotojas[] arr2 = Arrays.copyOf(arr, arr.length + 1);
        arr2[arr2.length - 1] = element;
        return arr2;
    }

}
