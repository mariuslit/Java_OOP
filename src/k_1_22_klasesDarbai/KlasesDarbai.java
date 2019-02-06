package k_1_22_klasesDarbai;

import java.util.Scanner;

public class KlasesDarbai {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);


//        uždaviniai [ 15 ]

//        System.out.println("iveskite pirmą kraštinę ");
//        int number = reader.nextInt();
//        System.out.println("iveskite  antrą kraštinę ");
//        int number2 = reader.nextInt();
//        System.out.println("Stačiojo trikampio plotas " + (number * number2) / 2);
//        System.out.println("Stačiakampio plotas " + (number * number2));
//
//
//        System.out.println("iveskite  apskritimo spindulį ");
//        int number3 = reader.nextInt();
//        System.out.println("Apskritimo plotas " + Math.PI * Math.pow(number3,2));
//
//
//        System.out.println("--- Atspausdinti pirmą ir paskutinę žodžio raides ");
//        System.out.println("iveskite  žodį ");
//        char zodis[] = reader.next().toCharArray();
//        System.out.println(zodis);
//        System.out.println(zodis[0]);
//        System.out.println(zodis[zodis.length - 1]);

//        System.out.println("--- Patikrinti ar žodis yra palindromas (palndromo pvz: abba)");
//        System.out.println("iveskite  žodį");
//        char zodis2[] = reader.next().toCharArray();
////        char zodis2[] = "kurmis".toCharArray();
//        System.out.println(zodis2);
//        String isPalindromas = "žodis yra palindromas";
//        for (int i = 0; i < zodis2.length; i++) {
//            if (zodis2[i] != zodis2[zodis2.length - 1 - i]) {
//                isPalindromas = "žodis nėra palindromas";
//                break;
//            }
//            System.out.println(zodis2[i] + " = " + zodis2[zodis2.length - 1 - i]);
//        }
//        System.out.println(isPalindromas);

//        String tipas = "tipas String";
//        System.out.println(tipas);
//        if (tipas instanceof String) {
//            System.out.println(tipas instanceof String);
//        }


//        uždaviniai [ 16 ]

        /*
         * Automobilis 100 km sunaudoja k litrų kuro (realusis skaičius).
         * Į m kilometrų kelionę (realusis skaičius) išsirengė n žmonių.
         * Kiek litų s kainuos kelionė vienam žmogui, jei vienas litras kuro kainuoja kk (realusis skaičius) litų.
         * Pasitikrinkite: kai k = 7.5, m = 305.5, n = 4, kk = 4.09, tai s = 23.4.
         */
//        double k = 7.5d; // 7.5 kiek sunaudoja kuro / 100 km
//        double m = 305.5d; // 305.5 kiek kilometrų
//        int n = 4; // 4 kiek žmonių
//        double kk = 4.09d; // kiek kainuoja 1 litras
//        double s = m * k / 100 * kk / n; // kainuos kelionė vienam žmogui
//        System.out.println(s);

        /*
         * Vandens saugykloje yra v kubinių metrų vandens (realusis skaičius).
         * Saugyklos vandenį vartoja n žmonių.
         * Vienas žmogus per parą vidutiniškai sunaudoja vv kubinių metrų vandens (realusis skaičius).
         *
         * Parašykite programą, kuri apskaičiuotų, kelioms paroms p užteks saugykloje esančio vandens.
         * Pasitikrinkite: kai v = 1001, n = 50, vv = 0.1, tai p = 200.2.
         */
//        int v = 1001; // 1001 kiek vandens
//        int n = 50; // 50 kiek žmonių
//        double vv = 0.1d; // kiek vienas žmogus sunaudooja per parą
//        double p = (double) v / n / vv; // kelioms paroms užteks vandens
//        System.out.println(p);


//        uždaviniai [ 17 ]
        // 1
        // Parašyti programą kuri suskaičiuotų kokia bendra teniruočių trukmė minutėmis
        // klaviatūra įvedami 5 skaičiai reiškiantys savaitės dienos (pirm-penkt) treniruočių trukmę
        // įvedami skaičiai - valandomis, atsakymas - minutės

        // sukuriamas Scanner objektas sc
        Scanner sc = new Scanner(System.in);
        double d[] = new double[5];

        System.out.println("Kokia treniruotės trukmė pirmadienį? ");
        d[0] = sc.nextInt();

        System.out.println("Kokia treniruotės trukmė antradienį? ");
        d[1] = sc.nextInt();

        System.out.println("Kokia treniruotės trukmė reciadienį? ");
        d[2] = sc.nextInt();

        System.out.println("Kokia treniruotės trukmė ketvirtadienį? ");
        d[3] = sc.nextInt();

        System.out.println("Kokia treniruotės trukmė penktadienį? ");
        d[4] = sc.nextInt();

        System.out.println("Visa treniruotės trukmė yra " + (d[0] + d[1] + d[2] + d[3] + d[4])*60 + " min");

        reader.close();
    }
}
