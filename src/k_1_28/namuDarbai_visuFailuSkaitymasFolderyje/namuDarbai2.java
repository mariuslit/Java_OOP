package k_1_28.namuDarbai_visuFailuSkaitymasFolderyje;

import java.io.*;
import java.util.Arrays;

public class namuDarbai2 {

    public static void main(String[] args) {

        String path = new File("").getAbsolutePath() + "\\src\\k_1_28\\namuDarbai_visuFailuSkaitymasFolderyje\\filesToRead\\";
        final File folder = new File(path);

        // 1 pirmas būdas nuskaityti failų pavadinimus iš katalogo, kreiptis į rekursinį metodą
//        listFilesForFolder_1(folder);

        // 2 antras būdas nuskaityti failų pavadinimus iš katalogo
//        listFilesForFolder_2(folder);

        // 3 užduotis
        // nuskaityti visus .txt failus ir sukelti jų duomenis į du masyvus:
        // Integer jeigu randamas skaičius ir Striing jeigu randamas žodis
        // tuosmsyvus atspausdinti
        try {

            readAllTxtFilesAndPrint(path, folder);

        } catch (IOException e) {
            System.out.println("klaida e=" + e);
            e.printStackTrace();
        }
    }

    private static void listFilesForFolder_1(final File folder) {

        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder_1(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }

    private static void listFilesForFolder_2(final File folder) {

        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName() + " size: " + file.list());
            }
            if (file.isDirectory()) {
                System.out.println("DIR >>" + file.getName());
            }
        }
    }

    // -------------------------------------   F >>
    private static void readAllTxtFilesAndPrint(String path, File folder) throws IOException {

        Integer[] intArr = new Integer[]{};
        String[] strArr = new String[]{};

        int f = 1;
        for (File file : folder.listFiles()) {
            System.out.println("============================= " + f++);
            if (!file.isFile()) {
                System.out.println("-------FOLDER " + file.getName());
                continue;
            }
            String[] tokens = file.getName().split("\\.(?=[^\\.]+$)");
            if (!tokens[1].equals("txt")) {
                System.out.println("-------FILE " + file.getName() + " token: " + tokens[1]);
                continue;
            }

            BufferedReader br = new BufferedReader(new FileReader(path + file.getName()));
            String visosEiluts = "";

            try {

                String line = br.readLine();

                while (line != null) {

                    String[] strTempArr = line.split(" ");

                    for (int i = 0; i < strTempArr.length; i++) {

                        try {

                            intArr = addElment(intArr, Integer.parseInt(strTempArr[i]));

                        } catch (NumberFormatException e) {

                            strArr = addElment(strArr, strTempArr[i]);
                        }
                    }

                    line = br.readLine();
                }


            } catch (FileNotFoundException ex) {
                System.out.println("Failas nerastas");
            } finally {
//                System.out.println("baigta");
                br.close();
            }

        }
        spausdinti(intArr, strArr);

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

    public static void spausdinti(Integer[] intArr, String[] strArr) {

        System.out.println("\n *** Spausdina Integer masyvą ***");
        for (int item : intArr) {
            System.out.println(item);
        }

        System.out.println("\n *** Spausdina String masyvą ***");
        for (String item : strArr) {
            System.out.println(item);
        }
    }
}
