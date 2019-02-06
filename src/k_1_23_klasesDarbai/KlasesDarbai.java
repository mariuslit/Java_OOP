package k_1_23_klasesDarbai;

/*
        Parašyti programas:
        1 Kurios atspausdintų skaičius nuo vieno iki šimto  ir atvirkščiai nuo šimto iki vieno (panaudojant visus ciklo variantus)
        2 Atlikti pirmą užduoti taip, kad skaičiai atsispausdintų atbulai, nuo šimto iki 1
      + 3 Naudojant for ciklą apsirašyti ciklą cikle ir atspausdinti kiekvieno ciklo indeksus i ir j
      + 4 Naudojant ciklą apskaičiuoti indeksų sumą
      + 5 Naudojant ciklą parašyti programą, kuri pasiekus indeksų suma 12 atspausdintų rezultatą
      + 6 Naudojant ciklą parašyti programą, kuri atspausdintų tik lyginius skaičius
        7 Parašyti programą, kuri nuskaitytų iš failo n(ciklo ilgio indeksas), vykdo ciklą n ilgio ir įrašo visus skaičius į failą
        8 Parašyti programą, kuri nuskaito žodžius iš failo ir įrašo žodžių skaičių į failo pirmą eilutę, o kitoje eilutėje visas nuskaitytas tekstas.
        9 Suskaičiuoti vidurkį iš duomenų esančių tekstiniam faile. Rezultatą išsaugoti rezultatų faile
        10 Iš duomenų failo nustatyti kokie skaičiai yra lyginiai ir išvesti į rezultatų failą skaičių ir ar jis lyginis.
           Pvz: 1 - nelyginis
                2 – lyginis
      + 11 Įvesta skaičių nuo 1-7 grąžintų atitinkamą dienos pavadinimą naudojant Switch
*/

import java.util.Scanner;

public class KlasesDarbai {

    public static void main(String[] args) {
        // 3 Naudojant for ciklą apsirašyti ciklą cikle ir atspausdinti kiekvieno ciklo indeksus i ir j
//        for (int i = 1; i < 5; i++) {
//            for (int j = 1; j < 7; j++) {
//                System.out.println("i=" + i + " j=" + j);
//            }
//        }

        // 4 Naudojant ciklą apskaičiuoti indeksų sumą
//        int sum4 = 0;
//        for (int i = 0; i < 20; i++) {
//            sum4 += i;
//            System.out.println(sum4);
//        }

        // 5 Naudojant ciklą parašyti programą, kuri pasiekus indeksų suma 12 atspausdintų rezultatą
//        int sum5 = 0;
//        for (int i = 0; i < 20; i++) {
//            sum5 += i;
//            if (sum5 >= 12) {
//                System.out.println(sum5);
//                break;
//            }
//        }

        // 6 Naudojant ciklą parašyti programą, kuri atspausdintų tik lyginius skaičius
//        for (int i = 0; i <= 20; i++) {
//            if (i % 2 == 0) {
//                System.out.println(i);
//            }
//        }

        // 11 Įvesta skaičių nuo 1-7 grąžintų atitinkamą dienos pavadinimą naudojant Switch
        Scanner sc = new Scanner(System.in);
        System.out.println("Įveskite dienos numerį");
        int diena = sc.nextInt();
        switch (diena) {
            case 1:
                System.out.println("pirm");
                break;
            case 2:
                System.out.println("antr");
                break;
            case 3:
                System.out.println("treč");
                break;
            case 4:
                System.out.println("ketv");
                break;
            case 5:
                System.out.println("penkt");
                break;
            case 6:
                System.out.println("šešt");
                break;
            case 7:
                System.out.println("sekm");
                break;
            default:
                System.out.println("tokia diena neegzistuoja");
        }
        sc.close();
    }
}
