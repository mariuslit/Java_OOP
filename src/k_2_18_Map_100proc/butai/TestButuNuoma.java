package k_2_18_Map_100proc.butai;

import java.io.*;
import java.util.*;

public class TestButuNuoma {

    public static void main(String[] args) throws IOException {

        List<Butas> butai = gautiStudentus(new File("").getAbsolutePath() + "\\src\\k_2_18_Map_100proc\\butai\\Duomenys.txt");
        Kriterijai kriterijai = gautiKriterijus(new File("").getAbsolutePath() + "\\src\\k_2_18_Map_100proc\\butai\\Kriterijai.txt");

        System.out.println(butai.toString());
        System.out.println(kriterijai.toString());

        List<Butas> atrinktiButai = atrinktiButusPagalKriterijus(kriterijai, butai);
        System.out.println(atrinktiButai.toString());
    }

    public static List<Butas> atrinktiButusPagalKriterijus(Kriterijai kriterijai, List<Butas> butai) {

        List<Butas> atrinktiButai = new ArrayList<>();

        for (Butas butas : butai) {

            if (butas.getKambariuSkaicius() < kriterijai.kambariuSkaiciusMIN) continue;
            if (butas.getKambariuSkaicius() > kriterijai.kambariuSkaiciusMAX) continue;
            if (butas.getKvadratura() < kriterijai.kvadraturaMIN) continue;
            if (butas.getKvadratura() > kriterijai.kvadraturaMAX) continue;
            if (butas.getNuomosKaina() < kriterijai.nuomosKainaMIN) continue;
            if (butas.getNuomosKaina() > kriterijai.nuomosKainaMAX) continue;

            atrinktiButai.add(butas);
        }

        return atrinktiButai;
    }

    private static List<Butas> gautiStudentus(String failas) throws IOException {

        List<Butas> butai = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            String line = br.readLine();

            while (line != null) {

                String[] arr = line.split(" ");

                Integer numeris = Integer.parseInt(arr[0]);
                String adresas = arr[1] + " " + arr[2] + " " + arr[3];
                Integer kambariuSkaicius = Integer.parseInt(arr[4]);
                Double kvadratura = Double.parseDouble(arr[5]);
                Double nuomosKaina = Double.parseDouble(arr[6]);

                butai.add(new Butas(numeris, adresas, kambariuSkaicius, kvadratura, nuomosKaina));
                line = br.readLine();
            }
            return butai;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }

    private static Kriterijai gautiKriterijus(String failas) throws IOException {


        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            String[] arr = br.readLine().split(" ");

            Integer kambariuSkaiciusMIN = Integer.parseInt(arr[0]);
            Integer kambariuSkaiciusMAX = Integer.parseInt(arr[1]);

            arr = br.readLine().split(" ");
            Double kvadraturaMIN = Double.parseDouble(arr[0]);
            Double kvadraturaMAX = Double.parseDouble(arr[1]);

            arr = br.readLine().split(" ");
            Double nuomosKainaMIN = Double.parseDouble(arr[0]);
            Double nuomosKainaMAX = Double.parseDouble(arr[1]);

            Kriterijai kriterijai = new Kriterijai(kambariuSkaiciusMIN, kambariuSkaiciusMAX, kvadraturaMIN, kvadraturaMAX, nuomosKainaMIN, nuomosKainaMAX);

            return kriterijai;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }


}
