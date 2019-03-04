package k_2_18_Map_nd_programuotoju_klase_100proc;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainProgramuotojuKlase {

    public static void main(String[] args) throws IOException {

        Map<Integer, List<Mokinys>> mokiniai = gautiMokinius(new File("").getAbsolutePath() + "\\src\\k_2_18_Map_nd_programuotoju_klase_100proc\\Duomenys.txt");
        Integer max = gautiMaxMokiniuSkaiciuKlaseje(new File("").getAbsolutePath() + "\\src\\k_2_18_Map_nd_programuotoju_klase_100proc\\Duomenys.txt");

        mokiniai.forEach((a, b) -> b.forEach(c -> System.out.println(c)));

        List<Mokinys> prioritetiniaiMokiniai = gautiPrioritetineKlase(mokiniai, max);

        System.out.println(max);
        prioritetiniaiMokiniai.forEach((b) -> System.out.println(b.toString()));

        rasyti(new File("").getAbsolutePath() + "\\src\\k_2_18_Map_nd_programuotoju_klase_100proc\\Rezultatai.txt", prioritetiniaiMokiniai);
    }

    private static List<Mokinys> gautiPrioritetineKlase(Map<Integer, List<Mokinys>> mokiniai, Integer max) {

        List<Mokinys> prioritetiniaiMokiniai = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {

            for (Mokinys mokinys : mokiniai.get(i)) {

                if (prioritetiniaiMokiniai.size() >= max) {
                    return prioritetiniaiMokiniai;
                }
                prioritetiniaiMokiniai.add(mokinys);
            }
        }
        return prioritetiniaiMokiniai;
    }

    private static Map<Integer, List<Mokinys>> gautiMokinius(String failas) throws IOException {

        Map<Integer, List<Mokinys>> prioritetai = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            String line = br.readLine();
            line = br.readLine();

            while (line != null) {
                String[] arr = line.split(" ");

                String vardasPavarde = arr[0];
                Integer prioritetas = Integer.parseInt(arr[1]);

                if (prioritetai.containsKey(prioritetas)) {

                    prioritetai.get(prioritetas).add(new Mokinys(vardasPavarde, prioritetas));

                } else {

                    List<Mokinys> mk = new ArrayList<>();
                    mk.add(new Mokinys(vardasPavarde, prioritetas));
                    prioritetai.put(prioritetas, mk);
                }

                line = br.readLine();
            }
            return prioritetai;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }

    private static Integer gautiMaxMokiniuSkaiciuKlaseje(String failas) throws IOException {


        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            Integer max = Integer.parseInt(br.readLine().split(" ")[0]);

            return max;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }

    public static void rasyti(String failas, List<Mokinys> prioritetiniaiMokiniai) {

        try (BufferedWriter output = new BufferedWriter(new FileWriter(failas))) {

            output.write("Sudarytos klasės mokinių sąrašas:");

            for (Mokinys mokinys : prioritetiniaiMokiniai) {
                output.write(System.lineSeparator());
                output.write(mokinys.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
