package k_2_08_uzduotisSavaitgaliui_Cars;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class MainCars {

    public static void main(String[] args) {

        try {
            String path = new File("").getAbsolutePath() + "\\src\\k_2_08_uzduotisSavaitgaliui_Cars\\";

            Car[] cars = skaityti(path + "cars.txt");
            rasyti(path + "dataWrite.txt", cars);

            // Rasti seniausią mašiną ir ją atspausdinti;
            System.out.println("\nSeniausia mašina");
            System.out.println(cars[rastiSeniausia(cars)].toString());

            // Rasti naujausią mašiną ir ją atspausdinti;
            System.out.println("\nNaujausia mašina");
            System.out.println(cars[rastiNaujausia(cars)].toString());

            // Rasti visas mašinas naujesnes nei 2010 metai ir jas atspausdinti;
            spausdintiVisasMasinasNaujesnesNei(cars, 2007);

            // Rasti visas mašinas, kurios yra pagamintos tarp 2000 ir 2010 metų ir jas atspausdinti;
            spausdintiVisasMasinasPagamintasTarp(cars, 2000, 2010);

            // Rasti visas VW markės mašinas ir jas atspausdinti;
            spausdintiVisasVienosMarkesMasinas(cars, "VW");

            // Rasti didžiausią variklio tūrį turinčią mašiną ir ją atspausdinti;
            System.out.println("\nDidžiausią variklio tūrį turinti mašina");
            System.out.println(cars[rastiDidziausiaVariklioTuri(cars)].toString());

            // Rasti benzininį variklį turinčių mašinų kiekį;
            System.out.println("\nBenzninių mašinų yra: " + kiekBenzininiu(cars));
            spausdintiBenzininius(cars, "B");

            // Mano sugalvota užduotis

            // Atspausdinti visas mašinas didėjančia tvarka pagal pagaminimo metus
            spausdintiVisasMasinasDidejanciaTvarkaPagalPagaminimoMetus(cars);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void spausdintiVisasMasinasDidejanciaTvarkaPagalPagaminimoMetus(Car[] cars) {
        // surūšiuoti masyvą didėjančia tvarka pagal pagaminimo metus
        // atspausdinti masyvą

        Arrays.sort(cars, Comparator.comparing(Car::getMetai));

        System.out.println("\nVisos mašinos didėjančia tvarka pagal pagaminimo metus:");
        for (Car car : cars) {

                System.out.println(car.toString());
        }
    }


    public static void spausdintiBenzininius(Car[] cars, String kuras) {

        String k = kuras.equals("B") ? "benziną" : "dyzelį";
        System.out.println("Visos " + k + " naudojančios mašinos:");

        for (Car car : cars) {

            if (car.getKuroTipas().equals(kuras)) {

                System.out.println(car.toString());
            }
        }
    }

    public static void spausdintiVisasVienosMarkesMasinas(Car[] cars, String marke) {

        System.out.println("\nVisos " + marke + " markes mašinos:");

        for (Car car : cars) {

            if (car.getGamintojas().equals(marke)) {

                System.out.println(car.toString());
            }
        }
    }

    public static void spausdintiVisasMasinasPagamintasTarp(Car[] cars, Integer year1, Integer year2) {

        System.out.println("\nVisos mašinos pagamintos tarp " + year1 + " ir " + year2 + " metų:");

        for (Car car : cars) {

            if (car.getMetai() >= year1 && car.getMetai() <= year2) {

                System.out.println(car.toString());
            }
        }
    }

    public static void spausdintiVisasMasinasNaujesnesNei(Car[] cars, Integer year) {

        System.out.println("\nVisos mašinos pagamintos po " + year + " metų:");

        for (Car car : cars) {

            if (car.getMetai() > year) {

                System.out.println(car.toString());
            }
        }
    }

    public static int rastiSeniausia(Car[] arr) {

        int min = 2019;
        int index = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i].getMetai() < min) {

                min = arr[i].getMetai();
                index = i;
            }
        }
        return index;
    }

    public static int rastiNaujausia(Car[] arr) {

        int max = arr[0].getMetai();
        int index = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i].getMetai() > max) {

                max = arr[i].getMetai();
                index = i;
            }
        }
        return index;
    }

    public static int rastiDidziausiaVariklioTuri(Car[] arr) {

        double max = arr[0].getVariklioTuris();
        int index = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i].getVariklioTuris() > max) {

                max = arr[i].getVariklioTuris();
                index = i;
            }
        }
        return index;
    }

    public static int kiekBenzininiu(Car[] arr) {

        int index = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i].getKuroTipas().equals("B")) {

                index++;
            }
        }
        return index;
    }


    public static Car[] skaityti(String failas) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            String line = br.readLine();

            Car[] cars = new Car[Integer.parseInt(line)];

            for (int i = 0; i < cars.length; i++) {
                line = br.readLine();

                String[] arr = line.split(" ");
                Car car = new Car(arr[0],
                        arr[1],
                        Integer.parseInt(arr[2]),
                        Integer.parseInt(arr[3]),
                        Double.parseDouble(arr[4]),
                        arr[5]);
                cars[i] = car;
            }

            return cars;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }

    public static void rasyti(String failas, Car[] cars) throws IOException {

        BufferedWriter output = null;

        try {
            output = new BufferedWriter(new FileWriter(failas));

            for (Car car : cars) {
                output.write(car.toString() + "\n");
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            if (output != null) {

                output.close();
            }
        }
    }
}
