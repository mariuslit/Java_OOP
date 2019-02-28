package k_2_19_nd_MokiniuVidurkiai_100proc;

import k_2_18_Map_OrientacinioSportoVarzybos_100proc.Sportininkas;

import java.io.*;
import java.util.*;

public class MainMokiniuVidurkiai {

    public static void main(String[] args) throws IOException {

        Map<String, List<Mokinys>> klases = nuskaitytiDuomenis("C:\\Coding\\Java_OOP\\src\\k_2_19_nd_MokiniuVidurkiai_100proc\\Duomenys.txt");

        spausdintiAtaskaita(klases);
    }

    public static void spausdintiAtaskaita(Map<String, List<Mokinys>> klases) {

        klases.forEach((a, b) -> {

            System.out.println("Klasė "+a+":");
            b.forEach(c -> {
                System.out.println(c.toString());
            });
            System.out.println();
        });

//        for (String key : klases.keySet()) {
//
//            System.out.println("Klasė " + key + ":");
//
//            for (Mokinys mokinys : klases.get(key)) {
//
//                System.out.println(mokinys.toString());
//            }
//
//            System.out.println();
//        }

        spausintiDidziausiaVidurki(klases);
        spausintiMaziausiaVidurki(klases);
    }

    public static void spausintiDidziausiaVidurki(Map<String, List<Mokinys>> klases) {

        Double max = 0d;
        String mok = "";

        for (List<Mokinys> mokiniai : klases.values()) {

            for (Mokinys mokinys : mokiniai) {

                if (mokinys.getBendrasVidurkis() > max) {

                    max = mokinys.getBendrasVidurkis();
                    mok = mokinys.getVardas() + " " + mokinys.getVardas() + " iš " + mokinys.getKlase();
                }
            }
        }
        System.out.println("Didžiausias vidurkis : " + mok);
    }

    public static void spausintiMaziausiaVidurki(Map<String, List<Mokinys>> klases) {

        Double min = Double.MAX_VALUE;
        String mok = "";

        for (List<Mokinys> mokiniai : klases.values()) {

            for (Mokinys mokinys : mokiniai) {

                if (mokinys.getBendrasVidurkis() < min) {

                    min = mokinys.getBendrasVidurkis();
                    mok = mokinys.getVardas() + " " + mokinys.getVardas() + " iš " + mokinys.getKlase();
                }
            }
        }
        System.out.println("Mažiausias vidurkis  : " + mok);
    }


    private static Map<String, List<Mokinys>> nuskaitytiDuomenis(String failas) throws IOException {

        //  Numeris  Sportininkas
        Map<String, List<Mokinys>> klases = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            String line = br.readLine();
            int sk = Integer.parseInt(line);

            // [1 eil] nuskaitomi sportininkai
            // i - sportininko Nr.
            for (int i = 0; i < sk; i++) {

                line = br.readLine().replaceAll("\\s+", " "); // pašalinami papildomi tarpai

                String[] arr = line.split(" ");

                String vardas = arr[0];
                String pavarde = arr[1];
                String klase = arr[2];

                int vd = Integer.parseInt(arr[3]);

                List<Double> vidurkiai = new ArrayList<>();

                Double vidSum = 0d;
                for (int j = 0; j < vd; j++) {

                    Double vid = Double.parseDouble(arr[4 + j]);
                    vidurkiai.add(vid);
                    vidSum += vid;
                }

                Mokinys mokinys = new Mokinys(vardas, pavarde, klase, vidurkiai, vidSum);

                if (klases.containsKey(klase)) {

                    klases.get(klase).add(mokinys);
                } else {

                    List<Mokinys> newKlase = new ArrayList<>();
                    newKlase.add(mokinys);
                    klases.put(klase, newKlase);
                }
            }

            return klases;

        } catch (
                FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }

    public static void irasytiDuomenis(String failas, Map<Integer, Sportininkas> sportininkai) {

        try (BufferedWriter output = new BufferedWriter(new FileWriter(failas))) {


            for (Integer vieta : sportininkai.keySet()) {

                if (vieta == 1) {

                    output.write(sportininkai.get(0) + " I pirmoji vieta");
                } else {

                    output.write(sportininkai.get(vieta).toString());
                }
                output.write(System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
