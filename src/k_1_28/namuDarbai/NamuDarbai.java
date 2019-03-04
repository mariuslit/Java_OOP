package k_1_28.namuDarbai;

import java.io.*;
import java.util.Arrays;

public class NamuDarbai {

    //   1   Skaitymo iš failo metodą patobulinti,
    //          kad jeigu failas neegzistuoja, būtų skaitoma iš kito failo.
    //   2   Parašyti funkciją, kuris gražintų iš masyvo elementą pagal indeksą,
    //          įvedus netinkamą, programa aptiktų klaidą ir
    //          atspausdintų į failą paskutinį masyvo elementą.
    //   3   Parašyti metodą, kuris aptiktų klaidą naudojant Integer.parseInt() funkciją,
    //          jei duoto kintamojo nepavyksta paversti į Integer tipo kintamąjį.
    //   4   Parašyti metodą, kuris atspausdintų nurodytą žodžio raidę pagal nurodytą indeksą ir
    //          jei nurodyto žodžio indeksas neegzistuoja aptikti klaidą ir apie ją pranešti.
    //   5   Papildyti metodą, kuriame įterpiame į masyvą naują reikšmę ir
    //          jei nurodome netinkamą įterpimo vietą pranešame apie klaidą.

    int t;
    //   6   Parašyti metodą duomenų skaitymui iš failo.
    //          Duomenų faile yra skaitinės reikšmės ir tekstinės.
    //          Reikia šiais duomenimis užpildyti masyvus ir juos atspausdinti ekrane.
    //          (Duomenų failas pateiktas moodle sistemoje)

    public static void main(String[] args) {
        try {
            String filePath = new File("").getAbsolutePath() + "\\src\\k_1_28\\namuDarbai\\";

            readFileAndPrintArrays(filePath + "readFileD.txt");

        } catch (IOException e) {
            System.out.println("klaida e=" + e);
            e.printStackTrace();
        }
    }

    // -------------------------------------   F >>
    private static void readFileAndPrintArrays(String failas) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(failas));
        String visosEiluts = "";
            Integer[] intArr = new Integer[]{};
            String[] strArr = new String[]{};

        try {

            String line = br.readLine();

            while (line != null) {

                String[] strTempArr = line.split(" ");

                for (int i = 0; i < strTempArr.length; i++) {

                    try {

                        intArr = addElment(intArr, Integer.parseInt(strTempArr[i]));

                    } catch (NumberFormatException e) {
                        System.out.println(e);
                        strArr = addElment(strArr, strTempArr[i]);
                    }
                }

                line = br.readLine();
            }


        } catch (FileNotFoundException ex) {
            System.out.println("Failas nerastas");
        } finally {
            System.out.println("baigta");
            br.close();
        }

        for (int i = 0; i < intArr.length; i++) System.out.println(intArr[i]);
        for (int i = 0; i < strArr.length; i++) System.out.println(strArr[i]);



//        return visosEiluts;
    }

    public static Integer[] addElment(Integer[] arr, Integer element) {

        Integer[] arr2 = Arrays.copyOf(arr, arr.length + 1);
        arr2[arr2.length - 1] = element;
        return arr2;
    }

    public static String[] addElment(String[] arr, String element) {

        String[] arr2 = Arrays.copyOf(arr, arr.length + 1);
        arr2[arr2.length - 1] = element;
        return arr2;
    }

    public static void pausdinti(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) System.out.println(i);
    }

}

































































































