package k_2_20_nd_SkaniausiSaldainiai_100proc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
    3. Skaniausi saldainiai.
    Saulius yra saldainių ekspertas. Jis ragauja įvairių gamintojų produkciją
    ir įvertina saldainių skonį 5 balų skalėje
        1 – neskanus;
        2 – iš bėdos galima valgyti;
        3 – galima valgyti, bet yra ir skanesnių;
        4 – skanus;
        5 – labai skanus
    Parenkite programą, kuri Sauliui
        pateiktų kiekvieno gamintojo saldainių sąrašą
        skanumo didėjimo tvarka.
    Pradinių duomenų faile <<Duomenys.txt>> įrašyta:
        pirmoje eilutėje – saldainių gamintojų skaičius n;
        toliau surašyti duomenys apie kiekvieną gamintoją:
        vienoje eilutėje įrašytas gamintojo pavadinimas (skiriama 25 pozicijos) ir saldainių
        rūšių skaičius r;
        tolesnėse r eilučių įrašytas saldainių rūšies pavadinimas (skiriama po 20 pozicijų) ir
        sveikasis skaičius nuo 1 iki 5, nurodantis saldainio skanumą.
    Rezultatų faile <<Rezultatai.txt>> turi būti įrašyta:
        kiekvieno gamintojo pavadinimas;
        to gamintojo saldainiai, išrikiuoti skanumo didėjimo tvarka. Jei yra kelios to paties
        skanumo saldainių rūšys, tai jos gali būti išdėstytos bet kuria tvarka
 */

public class MainSkaniausiSaldainiai {

    public static void main(String[] args) throws IOException {

        String pathDuomenys = "C:\\Coding\\Java_OOP\\src\\k_2_20_nd_SkaniausiSaldainiai_100proc\\Duomenys.txt";

        Map<String, List<Saldainis>> gamintojai = nuskaitytiDuomenis(pathDuomenys);

        // TODO: 2019-02-21 padaryti sort su stream
        gamintojai.forEach((gamintojas, saldainiai) -> {
            System.out.println(gamintojas);
            Collections.sort(saldainiai, (o1, o2) -> o1.getSkanumas().compareTo(o2.getSkanumas()));

            saldainiai.forEach(c -> {
                System.out.println(c.toString());
            });
        });
    }

    private static Map<String, List<Saldainis>> nuskaitytiDuomenis(String failas) throws IOException {

        Map<String, List<Saldainis>> saldainiai = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            String line = br.readLine();

            int gamintojuSkaicius = Integer.parseInt(line);

            for (int i = 0; i < gamintojuSkaicius; i++) {

                line = br.readLine();

                String[] arr = line.split(" ");

                String gamintojas = "";

                for (int k = 0; k < arr.length - 1; k++) {

                    gamintojas += arr[k] + " ";
                }

                int gaminiuSkaicius = Integer.parseInt(arr[arr.length - 1]);

                for (int j = 0; j < gaminiuSkaicius; j++) {

                    line = br.readLine();
                    String[] arr2 = line.split(" ");

                    String pavadinimas = "";

                    for (int k = 0; k < arr2.length - 1; k++) {

                        pavadinimas += arr2[k] + " ";
                    }

                    Integer skanumas = Integer.parseInt(arr2[arr2.length - 1]);

                    Saldainis saldainis = new Saldainis(gamintojas, pavadinimas, skanumas);

                    if (saldainiai.containsKey(gamintojas)) {

                        saldainiai.get(gamintojas).add(saldainis);

                    } else {

                        List<Saldainis> list = new ArrayList<>();
                        list.add(saldainis);
                        saldainiai.put(gamintojas, list);
                    }
                }
            }
            return saldainiai;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }
}
