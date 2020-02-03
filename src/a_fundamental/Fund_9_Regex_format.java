package a_fundamental;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;

public class Fund_9_Regex_format {

    // []* - betkoks simbolis išskyrus tuos kurie tarp [] skliaustų
    // norint pakeisti daatos formatą
    // 12/01/2018 -> 2018
    // find:    (\d\d)/(\d\d)/(\d{4}) - betkoks simbolis išskyrus tuos kurie tarp [] skliaustų
    // replace: $3-$1-$2

    static String num = "-10.12345"; // 9 sk
    static String txt = "-Abc, De.";
    static String r = "";

    public static void main(String[] args) {

        String a = "MAMA abc +-123.09 <.,;:'\"\\|/?>(`~!@#$%^&*=*/)[_]";
        String[] regex = {
                "", "originalas - neišmestas nei vienas simbolis",
                "[^a-zA-Z0-9]", "visi simboliai, išskyrus raides ir skaičius",
                "\\W+", "visos ne ridės",
                "[\\w+-]", "visos ne ridės, palieka + ir -",
                "\\w+", "visos ne ridės, palieka + ir -",
                "[\\W+-]", "didzioji W palieka minusa ir praleistu visus skaicius ir raides",
                " ", "pašalina tik taprpus",
                "-?\\\\d+", "?"
        };

        p(regex);

//        System.out.println("  |------------------------------------------------|");
//        System.out.println("2 |" + num.replaceAll("\\W+", r) + "|"); // visos ne ridės
//        System.out.println("3 |" + num.replaceAll("[\\w+-]", r) + "|"); // visos ne ridės, palieka + ir -
//        System.out.println("3+|" + num.replaceAll("\\w+", r) + "|"); // visos ne ridės, palieka + ir -
//        System.out.println("4 |" + num.replaceAll("[\\W+-]", r) + "|"); // didzioji W palieka minusa ir praleistu visus skaicius ir raides
//        System.out.println("5 |" + num.replaceAll(" ", r) + "|"); // tik taprpai
//        System.out.println("5 |" + num.replaceAll("-?\\\\d+", r) + "|"); //
    }

    public static void p(String[] regex) {

        System.out.println("\n regex naudojimas su String metodu replaseAll(regex, replacement)");
        System.out.println("       15            10         10");
        System.out.println("|---------------|----------|----------|---------------NEBAIGTAS----------------------------|");
        for (int i = 0; i < regex.length; i++) {
            System.out.printf("|%15s", regex[i]);
            System.out.printf("|%10.10s", num.replaceAll(regex[i], r));
            System.out.printf("|%10.10s", txt.replaceAll(regex[i], r));
            System.out.println("| " + regex[i + 1]);
            i++;
        }
        System.out.println("|---------------|----------|----------|---------------NEBAIGTAS----------------------------|");

        System.out.println("text1 " + 5.587895566 + " text2");
        System.out.printf("text1 %.4f textas2\n %.3f hhhhhh", 5.587895566, 8.456987);

    }
}

class formatai {

    public static void main(String[] args) {

        NumberFormat decimalFormat;

        System.out.println("------------------------------------");
        decimalFormat = new DecimalFormat("#00");
        System.out.println(decimalFormat.format(5));
        System.out.println(decimalFormat.format(154.5));

        System.out.println("------------------------------------");
        decimalFormat = new DecimalFormat("#0.00");
        // TODO: 2019-02-13 paklausti Džiugo dėl 0.055 kodėl apvalinamas į 0.5
        System.out.println(decimalFormat.format(854.055));
        System.out.println(decimalFormat.format(4.5));

        System.out.println("------------------------------------");
        System.out.println(String.format("|%20d|", 93));// prints: |                  93|
        System.out.println(String.format("|%-20d|", 93));// prints: |93                  |

        System.out.println(String.format("|%.5s|", "Hello World")); //  prints: |Hello|
        System.out.println(String.format("|%.15s|", "Hello World")); // prints: |Hello World|
        System.out.println(String.format("|%15s|", "Hello World")); //  prints: |    Hello World|
        System.out.println(String.format("|%-15s|", "Hello World")); // prints: |Hello World    |


    }
}

class String_replaceAll_regex {

    public static void main(String[] args) {

        // išmetami visi papildomi tarpai
        System.out.println("|123 abc a  b   c .     ,    +    -|");
        System.out.println("|123 abc a  b   c .     ,    +    -|".replaceAll("\\s+", " "));




    }
}

