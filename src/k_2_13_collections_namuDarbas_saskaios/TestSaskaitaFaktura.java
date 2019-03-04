package k_2_13_collections_namuDarbas_saskaios;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSaskaitaFaktura {
    /*
     +   Sukurkite sąskaitas-faktūras aprašančią klasę, kurioje būtų
            sąskaitos datos laukas (LocalDate),
            kliento vardas ir
            sumos laukas (BigDecimal).
     +   Sukurkite sąrašą tokių įrašų su skirtingomis datomis ir sumomis.
     +   Parašykite metodą kuris iš sąrašo suformuoja kitą sąrašą - ataskaitą
            parodančią kokios yra pajamos pagal ketvirčius.
    */

    public static void main(String[] args) throws IOException {

        List<Saskata> saskataFakturas;

        saskataFakturas = skaityti(new File("").getAbsolutePath() + "\\src\\dataFiles\\klientai.txt");

        spausdinti(saskataFakturas, "PRADINIS LISTAS");

        Map<Integer, Double> ketvirciai = atrinktiSaskaitaPgalKevircius(saskataFakturas);

        for (Double d : ketvirciai.values()) {

            System.out.println(d);
        }
    }

    public static Map<Integer, Double> atrinktiSaskaitaPgalKevircius(List<Saskata> saskataFakturas) {

        Map<Integer, Double> ketvirciai = new HashMap<>();

        ketvirciai.put(1, 0.0); // expected result: 5500.77
        ketvirciai.put(2, 0.0); // expected result: 4956.780000000001
        ketvirciai.put(3, 0.0); // expected result: 17641.02
        ketvirciai.put(4, 0.0); // expected result: 4716.01

        for (Saskata saskata : saskataFakturas) {
            pridetiReiksmeMap(ketvirciai, saskata);
        }

        return ketvirciai;
    }

    public static void pridetiReiksmeMap(Map<Integer, Double> ketvirciai, Saskata saskata) {

        switch (saskata.getData().getMonthValue()) {
            case 1:
            case 2:
            case 3:
                ketvirciai.put(1, ketvirciai.get(1) + saskata.getSuma().doubleValue());
                break;
            case 4:
            case 5:
            case 6:
                ketvirciai.put(2, ketvirciai.get(2) + saskata.getSuma().doubleValue());
                break;
            case 7:
            case 8:
            case 9:
                ketvirciai.put(3, ketvirciai.get(3) + saskata.getSuma().doubleValue());
                break;
            default:
                ketvirciai.put(4, ketvirciai.get(4) + saskata.getSuma().doubleValue());
        }
    }

    public static void spausdinti(List<Saskata> saskataFakturas, String title) {

        System.out.println(title);
        for (Saskata s : saskataFakturas) {

            System.out.println(s.toString());
        }
        System.out.println("---------------------------------");
    }

    public static List<Saskata> skaityti(String failas) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {


            String line = br.readLine();
            StringBuilder textLine = new StringBuilder(); // formuojami string duomenys iš failo

            List<Saskata> fakturos = new ArrayList<>();
            while (line != null) {

                String[] arr = line.split(" ");

                Saskata sf = new Saskata(
                        LocalDate.parse(arr[0]), // LocalDate data;
                        arr[1], // String klientoVardas;
                        BigDecimal.valueOf(Double.parseDouble(arr[2])) // BigDecimal suma;
                );

                fakturos.add(sf);
                line = br.readLine();
            }
            return fakturos;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }
}
