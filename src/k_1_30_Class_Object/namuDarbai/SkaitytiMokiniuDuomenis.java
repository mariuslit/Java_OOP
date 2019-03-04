package k_1_30_Class_Object.namuDarbai;

import a_fundamental.Fund_7_Metodai_su_skaiciais;

import java.io.*;
import java.util.Arrays;

public class SkaitytiMokiniuDuomenis {

    public static void main(String[] args) {

        String filePath = new File("").getAbsolutePath() + "\\src\\k_1_30_Class_Object\\namuDarbai\\";
        Mokinys[] mokiniai = skaityti(filePath, "mokiniai.txt");

        for (Mokinys mok : mokiniai) {
            System.out.print("V.: " + mok.getVardas());
            System.out.print(", P.: " + mok.getPavarde());
            System.out.print(", Kl.: " + mok.getKlase());
            System.out.println(", Paž.vid.: " + Fund_7_Metodai_su_skaiciais.getAverageArr(mok.getPazymiai()));
        }
    }

    // -------------------------------------   F >>
    private static Mokinys[] skaityti(String filePath, String failas) {

        Mokinys[] mokiniai = new Mokinys[]{};

        try (BufferedReader br = new BufferedReader(new FileReader(filePath + failas))) {

            String line = br.readLine();

            int sk = 0;
            while (line != null) {

                String[] zodis = line.split(" ");
                String[] pazymiaiStr = zodis[3].split(",");
                Integer[] pazymiaiInt = new Integer[pazymiaiStr.length];

                // sukelti pažymius į integer masyvą
                for (int i = 0; i < pazymiaiStr.length; i++) {
                    pazymiaiInt[i] = Integer.parseInt(pazymiaiStr[i]);
                }

                Mokinys mokinys = new Mokinys(zodis[0], zodis[1], zodis[2], pazymiaiInt);
                mokiniai = addElement(mokiniai, mokinys);

                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Failas nerastas");
        } catch (IOException ex) {
            System.out.println("Įvedimo klaida");
        } catch (NumberFormatException ex) {
            System.out.println("pagautas ne skaičius");
        }

        return mokiniai;
    }

    public static Mokinys[] addElement(Mokinys[] arr, Mokinys element) {

        Mokinys[] arr2 = Arrays.copyOf(arr, arr.length + 1);
        arr2[arr2.length - 1] = element;
        return arr2;
    }
}
