package k_2_19_PrekybaElektronikosPrekemis_100proc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MainElektronikosPrekes {
    /*
        Apskaičiuokite:

        - kiek vienetų parduota populiariausio modelio;
        -     kiek surinkta pinigų už populiariausią modelį;
        - kiek vienetų parduota pelningiausio modelio;
        -     kiek buvo surinkta už pelningiausią modelį.
        - Kuris modelis yra mažiausiai populiarus?
        -     Kiek parduota jo vienetų ir
        -     kiek už jį buvo surinkta pinigų.
    */
    public static void main(String[] args) throws IOException {

        Map<Integer, Telefonas> telefonai = nuskaitytiDuomenis(new File("").getAbsolutePath() + "\\src\\k_2_19_PrekybaElektronikosPrekemis_100proc\\Duomenys.txt");

        for (Telefonas tel : telefonai.values()) {

            System.out.println(tel.toString());
        }

        System.out.println("Populiariausias " + telefonai.get(gautiPopuliariausia(telefonai)));
        System.out.println("Pelningiausias " + telefonai.get(gautiPelningiausia(telefonai)));
        System.out.println("Nepopuliariausias " + telefonai.get(gautiNepopuliariausia(telefonai)));

    }

    public static Integer gautiPopuliariausia(Map<Integer, Telefonas> telefonai) {

        Integer max = 0;
        Integer id = 0;
        for (Telefonas tel : telefonai.values()) {

            if (tel.getPardavimuSkaicius() > max) {

                max = tel.getPardavimuSkaicius();
                id = tel.getId();
            }
        }
        return id;
    }

    public static Integer gautiPelningiausia(Map<Integer, Telefonas> telefonai) {

        Double max = 0d;
        Integer id = 0;
        for (Telefonas tel : telefonai.values()) {

            if (tel.getApyvarta() > max) {

                max = tel.getApyvarta();
                id = tel.getId();
            }
        }
        return id;
    }

    public static Integer gautiNepopuliariausia(Map<Integer, Telefonas> telefonai) {

        Double min = Double.MAX_VALUE;
        Integer id = 0;
        for (Telefonas tel : telefonai.values()) {

            if (tel.getApyvarta() < min) {

                min = tel.getApyvarta();
                id = tel.getId();
            }
        }
        return id;
    }

    private static Map<Integer, Telefonas> nuskaitytiDuomenis(String failas) throws IOException {

        //  Numeris  Sportininkas
        Map<Integer, Telefonas> telefonai = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            String line = br.readLine();
            int sk = Integer.parseInt(line);

            // [1 eil] nuskaitomi sportininkai
            // i - sportininko Nr.
            for (int i = 0; i < sk; i++) {

                line = br.readLine();
                String[] arr = line.split(" ");

                Integer id = Integer.parseInt(arr[0]);
                String modelis = arr[1] + " " + arr[2] + " " + arr[3];

                Double kaina = Double.parseDouble(arr[4]);

                telefonai.put(id, new Telefonas(id, modelis, kaina));
            }

            line = br.readLine();
            int sk2 = Integer.parseInt(line);

            // i - sportininko Nr.
            for (int i = 0; i < sk2; i++) {

//                System.out.println(telefonai.get(i));
                line = br.readLine();
                String[] arr = line.split(" ");

                Integer id = Integer.parseInt(arr[0]);
                Integer parduotaVnt = Integer.parseInt(arr[1]);

                telefonai.get(id).setPardavimuSkaicius(parduotaVnt);
            }

            return telefonai;

        } catch (
                FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }


}
