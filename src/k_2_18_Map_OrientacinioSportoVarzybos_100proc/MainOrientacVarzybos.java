package k_2_18_Map_OrientacinioSportoVarzybos_100proc;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MainOrientacVarzybos {

    public static void main(String[] args) throws IOException {

        Map<Integer, Sportininkas> sportininkai = nuskaitytiDuomenis(new File("").getAbsolutePath() + "\\src\\k_2_18_Map_OrientacinioSportoVarzybos_100proc\\orient-duomenys.txt");

        List<Sportininkas> finalistai = new ArrayList<>();

        assert sportininkai != null;
        sportininkai.forEach((a, b) -> {
            if (b.getPunktai().contains(5)) finalistai.add(b);
        });

//        for (Sportininkas sp : sportininkai.values()) {
//            if (sp.getPunktai().contains(5)) {
//                finalistai.add(sp);
//            }
//        }

        // tik atspausdinami spotininkai
        Collections.sort(finalistai, (o1, o2) -> o1.compareTo(o2));
        System.out.println(finalistai.get(0).toString()+" I vieta\n");
        finalistai.forEach((a) -> System.out.println(a.toString() + " " + a.getPunktai().size() + " " + a.getDuration()));
    }

    public static Sportininkas sukurtiSportininką(Integer nr, String line, Map<Integer, Sportininkas> sportininkai) {

        String[] arr = line.split(" ");

        String vardas = arr[0];
        String pavarde = arr[1];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss");

        LocalTime startTime = LocalTime.parse(arr[2], formatter); // 08:45:00
        LocalTime finalTime = LocalTime.parse(arr[3], formatter); // 08:45:00

        return new Sportininkas(vardas, pavarde, nr, startTime, finalTime);
    }

    public static void priskirtiPunktaSportinkui(String line, Map<Integer, Sportininkas> sportininkai) {

        String[] arr = line.split(" ");

        Integer punktoNumeris = Integer.parseInt(arr[0]);

        int sportininkuSkaicius = Integer.parseInt(arr[1]);

        for (int i = 0; i < sportininkuSkaicius; i++) {

            int sportininkoNr = Integer.parseInt(arr[i + 2]);
            sportininkai.get(sportininkoNr).addPunktai(punktoNumeris);
        }
    }

    private static Map<Integer, Sportininkas> nuskaitytiDuomenis(String failas) throws IOException {

        //  Numeris  Sportininkas
        Map<Integer, Sportininkas> sportininkai = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            // nuskaitomas sportininku skaicius
            String line = br.readLine();
            int sportininkuSkaicius = Integer.parseInt(line);

            for (int sportininkoNr = 1; sportininkoNr <= sportininkuSkaicius; sportininkoNr++) {

                line = br.readLine();
                sportininkai.put(sportininkoNr, sukurtiSportininką(sportininkoNr, line, sportininkai));
            }

            // nuskaitomas punktu skaicius
            int punktuSkaicius = Integer.parseInt(br.readLine());

            // kiek ciklų suksime
            for (int i = 0; i < punktuSkaicius; i++) {

                line = br.readLine();
                priskirtiPunktaSportinkui(line, sportininkai);
            }

            return sportininkai;

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
