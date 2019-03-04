package k_2_20_kd_PrekybaBuitineTechnika_100proc;

import java.io.*;
import java.util.*;

public class MainBuitineTechnika {

    public static void main(String[] args) throws IOException {

        String pathSandelis = new File("").getAbsolutePath() + "\\src\\k_2_20_kd_PrekybaBuitineTechnika_100proc\\Sandelis.txt";
        String pathUzsakymai = new File("").getAbsolutePath() + "\\src\\k_2_20_kd_PrekybaBuitineTechnika_100proc\\Uzsakymai.txt";
        String pathSandelisRez = new File("").getAbsolutePath() + "\\src\\k_2_20_kd_PrekybaBuitineTechnika_100proc\\SandelisRez.txt";
        String pathUzsakymaiRez = new File("").getAbsolutePath() + "\\src\\k_2_20_kd_PrekybaBuitineTechnika_100proc\\UžsakymaiRez.txt";

        Map<Integer, Technika> technikaMap = nuskaitytiDuomenis(pathSandelis);
//        System.out.println("\n- Buitinė technika");
//        technikaMap.forEach((a, b) -> System.out.println(b.toStringSandelisRez()));

        Map<Integer, Technika> sandelioLikuciai = new TreeMap<>(technikaMap);

        Map<Integer, Technika> uzsakymas = gautiUzsakyma(pathUzsakymai, sandelioLikuciai);

        // spausdinti sandėlio likucius
        spausdintiSandelioLikucius(pathSandelisRez, sandelioLikuciai);

        // spausdinti uzsakyma tiekejams
        spausdintiUzsakymaTiekejams(pathUzsakymaiRez, uzsakymas);

    }

    public static void spausdintiSandelioLikucius(String pathSandelisRez, Map<Integer, Technika> sandelioLikuciai) {

        List<String> sandelisRez = new ArrayList<>();
        sandelisRez.add("Rezultatų failas");
        sandelisRez.add("SandelisRez.txt");

        for (Technika technika : sandelioLikuciai.values()) {
            sandelisRez.add(technika.toStringSandelisRez());
        }

        // į konsolę
        irasytiDuomenis(pathSandelisRez, sandelisRez);
        System.out.println("\n- SandelisRez.txt");
        sandelioLikuciai.forEach((a, b) -> System.out.println(b.toStringSandelisRez()));
    }

    public static void spausdintiUzsakymaTiekejams(String pathUzsakymaiRez, Map<Integer, Technika> uzsakymas) {

        List<String> uzsakymaiRez = new ArrayList<>();
        uzsakymaiRez.add("Rezultatų failas");
        uzsakymaiRez.add("UžsakymaiRez.txt");

        for (Technika technika : uzsakymas.values()) {
            uzsakymaiRez.add(technika.toStringUzsakymaiRez());
        }

        uzsakymaiRez.add("Sumokėti tiekėjams " + sumoketiTiekejams(uzsakymas));
        irasytiDuomenis(pathUzsakymaiRez, uzsakymaiRez);

        // į konsolę
        System.out.println("\n- UžsakymaiRez.txt");
        uzsakymas.forEach((a, b) -> System.out.println(b.toStringUzsakymaiRez()));
        System.out.println("Sumokėti tiekėjams " + sumoketiTiekejams(uzsakymas));
    }


    private static String sumoketiTiekejams(Map<Integer, Technika> uzsakymas) {

        double sum = uzsakymas.values()
                .stream()
                .mapToDouble(a -> a.getKaina() * a.getKiekis())
                .sum();

        return String.format("%-5.2f", sum);
    }

    private static Map<Integer, Technika> nuskaitytiDuomenis(String failas) throws IOException {

        //  Numeris  Sportininkas
        Map<Integer, Technika> technikaMap = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            String line = br.readLine();

            while (line != null) {

                String[] arr = line.split(" ");
                String vardas = "";

                for (int i = 0; i <= arr.length - 4; i++) {

                    vardas += arr[i] + " ";
                }

                Integer kodas = Integer.parseInt(arr[arr.length - 3]);
                Integer kiekis = Integer.parseInt(arr[arr.length - 2]);
                Double kaina = Double.parseDouble(arr[arr.length - 1]);


                technikaMap.put(kodas, new Technika(vardas, kodas, kiekis, kaina));
                line = br.readLine();
            }
            return technikaMap;

        } catch (
                FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }

    private static Map<Integer, Technika> gautiUzsakyma(String failas, Map<Integer, Technika> technika) throws IOException {

        //  Numeris  Sportininkas
        Map<Integer, Technika> uzsakymas = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            String line = br.readLine();

            while (line != null) {

                String[] arr = line.split(" ");

                Integer kodas = Integer.parseInt(arr[0]);
                Integer kiekis = Integer.parseInt(arr[1]);

                technika.get(kodas).setKiekis(technika.get(kodas).getKiekis() - kiekis);

                if (technika.get(kodas).getKiekis() < 0) {

                    uzsakymas.put(kodas, technika.get(kodas));
                    uzsakymas.get(kodas).setKiekis(-uzsakymas.get(kodas).getKiekis());
                    technika.remove(kodas);

                } else if (technika.get(kodas).getKiekis() == 0) {

                    technika.remove(kodas);
                }

                line = br.readLine();
            }
            return uzsakymas;

        } catch (
                FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }

    public static void irasytiDuomenis(String failas, List<String> technika) {

        try (BufferedWriter output = new BufferedWriter(new FileWriter(failas))) {


            for (String item : technika) {

                output.write(item);
                output.write(System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
