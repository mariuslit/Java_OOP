package a_fundamental;

public class Fund_8_String_methods {

    public static void main(String[] args) {

        String[] regex = {
                "[^a-zA-Z0-9]", // visi simboliai išskyrus raides
                "\\W+", // visios ne ridės
                "[\\w+-]", // visios ne ridės, palieka + ir -
                "[\\W+-]", // didzioji W palieka minusa ir praleistu visus skaicius ir raides
                " "  // tik taprpai
        };

        String m="abcd;efgh;jkab MAMA";
        System.out.println(m.length()); // 19
        System.out.println(m.charAt(5)); // e
        System.out.println(m.concat(" - mano")); // abcd;efgh;jkab;nopr
        System.out.println(m.startsWith("lm")); // false
        System.out.println(m.endsWith("ama")); // false
        System.out.println(m.indexOf("gh")); // 7
        System.out.println(m.toUpperCase()); // ABCD;EFGH;JKAB
        System.out.println(m.toLowerCase()); // ABCD;EFGH;JKAB
        System.out.println(m.lastIndexOf("MAMA"));
        /*
         * int        length(); // eilutės ilgis
         * char       charAt(int index); // simbolis nurodytoje pozicijoje
         * int        indexOf(int ch); // pirma pozicija, kur yra simbolis
         * int        indexOf(String str); // pirma pozicija, kur yra posekis
         * int        lastIndexOf(int ch); // paskutinė pozicija, kur yra simbolis
         * int        lastIndexOf(String str); // paskutinė pozicija, kur yra posekis
         *
         * boolean    endsWith(String suffix); // ar baigiasi posekiu
         * boolean    startsWith(String prefix); // ar prasideda posekiu
         * boolean    equals(Object obj); // ar eilutė lygi duotajai
         * boolean    equalsIgnoreCase(String str); // ar lygios nepaisant didžiųjų ir mažųjų raidžių
         *
         * String     concat(String str); // prijungti duotą eilutę
         * String     replace(char old, char new); // pakeisti simbolį eilutėje
         * String     replaceAll(char old, char new); // pakeisti visus simbolius eilutėje
         * String     replaceAll(String regex, String replacemen); // pakeisti visus žodžius eilutėje
         * String[]   split(String regex); // suskaidyti eilutę dalimis pagal šiuos simbolius
         * String     substring(int beginIndex); // ištraukti posekį nuo nurodytos pozicijos
         * String     substring(int beginIndex, int endIndex); // ištraukti posekį nuo nurodytos pozicijos iki nurodytos pozicijos
         * char[]     toCharArray(); // suskaidyti į simbolių masyvą
         * String     toLowerCase(); // padaryti mažosiomis raidėmis
         * String     toUpperCase(); // padaryti didžiosiomis raidėmis
         * String     valueOf(boolean b); // versti nurodyto tipo reikšmę į eilutę
         *
         */
    }
}
