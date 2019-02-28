package k_2_14_KeliaiMasinosZmones;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MainKeliaiMasinosZmones {
/*
      -      Nuskaityti failą
                    automobiliai.txt
                    zmones.txt ir
                  -      Zmones.txt faile
                            Vardas,
                            Pavarde,
                            Masinos numeriai
                  -      Automobiliai.txt faile
                            Marke,
                            Masinos numeriai
                    ir apjungti du failus į Map<> kolekciją.
      -      Susikurti klases
                    Zmogus,
                    Masina;

      -      Nuskaityti du skirtingus duomenų failus ir atitinkamai susikurti du List‘us,
                    viename saugoti žmones, kitame mašinas.

      -      Turint du list‘us apjungti į Map<Zmogus, List<Masina>> tipo objektą.
                    Surasti kiekvieno žmogaus mašinas ir sudėti į mašinų list‘ą.

      -      Atspausdinti į failą... Pvz „Jonas Jonaitis -  Marke: BMW Nr. AAA:111“
*/

    public static void main(String[] args) throws IOException {

        String pathD = "C:\\Coding\\Java_OOP\\src\\MainKeliaiMasinosZmones\\DarbuotojuDuomenys.txt";
        String pathM = "C:\\Coding\\Java_OOP\\src\\MainKeliaiMasinosZmones\\Masinos.txt";
        List<Masina> masinuDB = skaitytiMasinas(pathM);
        System.out.println(masinuDB.size());

        Map<Zmogus, Map<String, String>> zmones = skaitytiZmones(pathM, new HashSet<>(masinuDB));
        System.out.println(zmones.size());

    }

    public static Map<Zmogus, Map<String, String>> skaitytiZmones(String failas, Set<Masina> masinuDB) throws IOException {

//        System.out.println(masinuDB.size() + " mmmmmmm");
        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {
            String line = br.readLine();

            // todo pabaigti visą logiką su Map'ais
            // 1 sukurti žmonių masyvą
            Map<Zmogus, Map<String, String>> zmones = new HashMap<Zmogus, Map<String, String>>();

            // 2  sukurti žmogų (Key)
            Zmogus zmogus2 = new Zmogus("Marius", "Litvinas");

            // 3 sukurti autmobilį ir patikrinti duomenu bazėje ar toks yra
            Masina masina = new Masina("MERCEDES", "CCC:222");
//            Masina masina = new Masina("Opel", "JGN:682");

            for (Masina m : masinuDB) {
                System.out.println(m.toString());
            }


            if (containsCar(masinuDB, masina)) {

                System.out.println("Tokia masina egzistuoja");
            } else {

                System.out.println(masina.toString());
                System.out.println("Tokios mašinos nra");
            }
            // 4 sukurti automobilių Map
            Map<String, String> masinos = new HashMap<>();

            // 5 į automobilių Map įdėti automobilį
            masinos.put(masina.getGamintojas(), masina.getNumeriai());

            // 6  į žmonių masyvą įdėti žmogu ir automobilių Map
            zmones.put(zmogus2, masinos);

//            while (line != null) {
//
//                String[] arr = line.split(" ");
//
//                Zmogus zmogus = new Zmogus(arr[0], arr[1]);
//                if (zmones.containsKey(zmogus)) {
//                    zmones.get(zmogus).put(arr[2], masinuDB.);
//                }

//                Masina masina = new Masina();
//                zmones.put(zmogus, masinos.get(Integer.parseInt(arr[2])));
            line = br.readLine();
//            }
            return zmones;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }

    public static boolean containsCar(Set<Masina> masinuDB, Masina masina) {

        // stream surasti ar Set kolekcija contains Objektą masina
        Set<Masina> filtered = masinuDB.stream()
                .filter(mc -> mc.getNumeriai().equals(masina.getNumeriai()))
                .collect(Collectors.toSet());

        return filtered.size() > 0;
    }

    public static List<Masina> skaitytiMasinas(String failas) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {


            String line = br.readLine();

            List<Masina> masinos = new ArrayList<>();

            while (line != null) {

                String[] arr = line.split(" ");

                Masina masina = new Masina(arr[0], arr[1]);

                masinos.add(masina);
                line = br.readLine();
            }
            return masinos;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }
}
