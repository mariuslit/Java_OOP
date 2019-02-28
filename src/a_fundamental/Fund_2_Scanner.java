package a_fundamental;

import java.util.Locale;
import java.util.Scanner;

public class Fund_2_Scanner {

    public static void copyPaste() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Įveskite du skaičius per tarpą pvz: '5 99'");
        String line = sc.nextLine();

        String[] metimas = line.split(" ");

        Integer pirmasSkaicius = Integer.parseInt(metimas[0]);
        Integer antrasSkaicius = Integer.parseInt(metimas[1]);

        System.out.println("pirmas sk=" + pirmasSkaicius + " antras sk=" + antrasSkaicius);
    }

    public static void main(String[] args) {

        copyPaste();

        // sukuriamas Scanner objektas sc
        Scanner sc = new Scanner(System.in);

        // String input
        System.out.println("Įveskite vardą");
        // nextLine() nuskaito visą eilutę
        String vardas = sc.nextLine();
        System.out.println("Jūsų įvestas vardas yra " + vardas);

        // Character input
        System.out.println("Įveskite raidę");
        // next() nuskaito žodį iki tarpo
        char raide = sc.next().charAt(0);
        System.out.println("Jūsų įvestas simbolis yra " + raide);

        // Numerical data input byte, short and float can be read using similar-named functions.
        System.out.println("Įveskite sveikąjį skaičių");
        int sk = sc.nextInt();
        System.out.println("Jūsų įvestas sveikasis skaičius yra " + sk);

        System.out.println("Įveskite ilgą sveikąjį skaičių");
        long ilgasSk = sc.nextLong();
        System.out.println("Jūsų įvestas ilgas sveikasis skaičius yra " + ilgasSk);

        System.out.println("Įveskite trupmeninį skaičių, naudoti kablelį [,]");
        double trupmeninisSk = sc.nextDouble();
        System.out.println("Jūsų įvestas trupmeninis skaičius yra " + trupmeninisSk);

        // uždaromas skaneris
        sc.close();


        /*
         * kitoks pavydzdys
         */
        String s = "gfg 2 geeks! 848996 skaneris gali nuskaityti iš anksto įkeltą String objektą ir atpažinti Integer tipo duomenis";
        Scanner scanner = new Scanner(s);

        // use US locale to interpret Ints in a string
        scanner.useLocale(Locale.US);

        // iterate till end
        while (scanner.hasNext()) {

            // check if the scanner's
            // next token is a Int with the default radix
            System.out.print("" + scanner.hasNextInt());

            // print what is scanned
            System.out.print(" -> " + scanner.next() + "\n");
        }

        // close the scanner
        scanner.close();
    }
}
