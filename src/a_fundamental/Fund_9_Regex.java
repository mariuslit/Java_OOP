package a_fundamental;

public class Fund_9_Regex {

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
//        System.out.println("1 |" + num.replaceAll("[^a-zA-Z0-9]", r) + "|"); // visi simboliai išskyrus raides
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
    }
}
