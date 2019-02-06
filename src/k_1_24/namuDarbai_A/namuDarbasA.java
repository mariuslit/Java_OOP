package k_1_24.namuDarbai_A;

import java.io.*;
import java.util.Arrays;

/*
 * NAMŲ DARBAI 2018-01-24
 *
 * +  A. Nuskaityti iš tekstinio failo elementus į masyvą ir atsakymus išspausdinti į Failą.
 * +     1. Masyvą apsukti, t.y. jei masyvas yra lygus 1,2,3 , metodas turi grąžinti 3,2,1
 * +     2. Suskaičiuoti masyvo elementų vidurkį
 * +     3. Pašalinti visus elementus mažesnius už vidurkį
 * +     4. Visus neigiamus skaičius perkelti į naują masyvą, o iš senojo ištrinti
 * +     5. Rasti Maksimumą ir Minimumą
 * +     6. Rastų reikšmes, kurios kartojasi
 * +     7. Surikiuoti masyvus didėjimo ir mažėjimo tvarkomis, naudojant burbuliuko(BubleSort) rikiavimo metodą
 *    B. Nuskaityti iš tekstinio failo elementus į Matricą ir atsakymus išspausdinti į failą.
 *       1. Suskaičiuoti visos matricos sumą, vidurkį
 *       2. Suskaičiuoti kiekvienos eilutės sumą, vidurkį
 *       3. Rasti kiekvienos eilutės didžiausią ir mažiausią reikšmę
 *       4. Pašalinti eilutes kurių suma mažesnė nei 5
 */
public class namuDarbasA {

    // *    1. Masyvą apsukti, t.y. jei masyvas yra lygus 1,2,3 , metodas turi grąžinti 3,2,1
    public static void main(String[] args) {
        try {
            String filePath = "C:\\Coding\\Java_OOP\\src\\k_1_24\\namuDarbai_A\\";

            Integer[] mas = skaityti(filePath + "Fund_7_readFileA.txt");

            // 1. Masyvą apsukti, t.y. jei masyvas yra lygus 1,2,3 , metodas turi grąžinti 3,2,1
            Integer[] apsuktasMasyvas = turnArray(mas);
            rasyti(filePath + "writeA1_apsuktasMasyvas.txt", apsuktasMasyvas);

            // 2. Suskaičiuoti masyvo elementų vidurkį
            Double masyvoElementuVidurkis = getAverageArr(mas);
            // išvesti du skaičius į Integer tipo masyą ir atspausdinti faile, pirmas skaičius sveikoji Double dalis, anrtas - trupmeninė
            int int1 = masyvoElementuVidurkis.intValue();
            System.out.println(int1);
            double dou2 = (masyvoElementuVidurkis % int1);
            System.out.println(dou2);
//            int int2 = dou2.intValue();
            rasyti(filePath + "writeA2_masyvoElementuVidurkis.txt", new Integer[]{int1});
            // panaudotas formatas Duoble tipui
            System.out.println("masyvo elementų vidurkis yra " + String.format("%.3f", masyvoElementuVidurkis));

            // 3. Pašalinti visus elementus mažesnius už vidurkį
            Integer[] masyvasBeMazesniuUzVidurki = removeElementLessAverage(mas, masyvoElementuVidurkis);
            rasyti(filePath + "writeA3_masyvasBeMazesniuUzVidurki.txt", masyvasBeMazesniuUzVidurki);

            // 4. Visus neigiamus skaičius perkelti į naują masyvą, o iš senojo ištrinti
            Integer[] neigiamuSkMasyvas = negativArray(mas);
            rasyti(filePath + "writeA4_neigiamuSkMasyvas.txt", neigiamuSkMasyvas);
            Integer[] masyvasBeNeigiamuSk = arrayBeNeigiamuSk(mas);
            rasyti(filePath + "writeA4_masyvasBeNeigiamuSk.txt", masyvasBeNeigiamuSk);

            //  5. Rasti Minimumą ir Maksimumą
            Integer minimumas = getMin(mas);
            Integer maksimumas = getMax(mas);
            rasyti(filePath + "writeA5_getMin_getMax.txt", new Integer[]{minimumas, maksimumas});

            //  6. Rastų reikšmes, kurios kartojasi
            Integer[] besikartojanciosReiksmes = repeatValues(mas);
            rasyti(filePath + "writeA6_repeatValues.txt", besikartojanciosReiksmes);

            // 7. Surikiuoti masyvus didėjimo ir mažėjimo tvarkomis, naudojant burbuliuko(BubleSort) rikiavimo metodą
            Integer[] masyvoRikiavimas = arraySortAsseding(mas);
            rasyti(filePath + "writeA7_arraySortAsseding.txt", masyvoRikiavimas);


        } catch (IOException e) {
            System.out.println("klaida e=" + e);
            e.printStackTrace();
        }
    }

    public static Integer[] turnArray(Integer[] arr) {

        Integer[] apsuktas = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            apsuktas[i] = arr[arr.length - 1 - i];
        }
        return apsuktas;
    }

    public static Double getAverageArr(Integer[] arr) {

        Double averageArr = 0.0;

        for (int i = 0; i < arr.length; i++) {
            averageArr += arr[i];
        }
        return averageArr / arr.length;
    }

    public static Integer[] removeElementLessAverage(Integer[] arr, Double avr) {

        Integer[] arr2 = new Integer[]{};

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] >= avr) {

                arr2 = addElment(arr2, arr[i]);
            }
        }
        return arr2;
    }

    public static Integer[] addElment(Integer[] arr, Integer element) {

        Integer[] arr2 = Arrays.copyOf(arr, arr.length + 1);
        arr2[arr2.length - 1] = element;
        return arr2;
    }

    public static Integer[] removElement(Integer[] arr, Integer index) {

        Integer[] temp = new Integer[arr.length - 1];
        int ii = 0;

        for (int i = 0; i < arr.length; i++) {

            if (i != index) {

                temp[ii++] = arr[i];
            }
        }
        return temp;
    }

    public static Integer[] negativArray(Integer[] arr) {

        Integer[] arr2 = new Integer[]{};

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < 0) {

                arr2 = addElment(arr2, arr[i]);
            }
        }
        return arr2;
    }

    public static Integer[] arrayBeNeigiamuSk(Integer[] arr) {

        Integer[] arr2 = arr;
        int i = 0;

        while (i < arr2.length - 1) {

            if (arr2[i] < 0) {

                arr2 = removElement(arr2, i);
            }
            i++;
        }

        return arr2;
    }

    public static Integer getMin(Integer[] arr) {

        Integer min = arr[0];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < min) {

                min = arr[i];
            }
        }
        return min;
    }

    public static Integer getMax(Integer[] arr) {

        Integer max = arr[0];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > max) {

                max = arr[i];
            }
        }
        return max;
    }

    public static Integer[] repeatValues(Integer[] arr) {

        //+ sukurti tuščią dublikatų masyvą
        //+ paimti pirma elementą
        //+ patikrinti ar jis kartojasi masyve
        //+ patikrinti ar jis nesidubliuoja dublikatų masyve
        //+ pridėti į dublikatų masyvą

        Integer[] duplicates = new Integer[]{};
        boolean isDuplicate = false;
        Integer duplicate = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                // tikrina ar turi dublikatą
                if (arr[i] == arr[j]) {

                    isDuplicate = true;
                    duplicate = arr[i];
                    break;
                }
            }

            // tikrinti ar toks dublikatas nebuvo anksčiau įdėtas į masyvą, jei ne - įdėti
            if (isDuplicate) {

                boolean prideti = true;

                for (int j = 0; j < duplicates.length; j++) {

                    if (duplicate == duplicates[j]) {
                        prideti = false;
                        break;
                    }
                }

                // jei dublikatu nėra - pridėti nauja elementą
                if (prideti) {

                    duplicates = addElment(duplicates, duplicate);
                }
            }

            isDuplicate = false;
        }
        return duplicates;
    }

    public static Integer[] arraySortAsseding(Integer[] arr) {

        // surykiuoti msyvą didėjimo tvarka

        // 1 patikrinti du masyvo elementus
        // 2 jei pirmasis didesnis už antrajį - sukeisti vietomis
        // 3 naudoti fori forj ir tarpinį kintamajį

//        Integer[] sorttedArray = new Integer[]{};
        Integer temp;
        Integer sk=0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length -1 - i; j++) {

                if (arr[j] > arr[j + 1]) {

                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    System.out.println(++sk);
                }
            }
        }

        return arr;
    }


    // -------------------------------------   F >>
    private static Integer[] skaityti(String failas) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(failas));
        Integer[] masyvas = null;

        try {

            // regex "\\W+" pašalina viską, kas ne žodžiai, naudoti vietoje " ", kai dirbama su String.
            // Netinka su skaičiais nes pašalina ir minuso ženklą.
            String[] textArr = br.readLine().split(" ");
            masyvas = new Integer[textArr.length];

            for (int i = 0; i < textArr.length; i++) {
                masyvas[i] = Integer.parseInt(textArr[i]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Failas nerastas");
        } finally {
            br.close();
        }

        return masyvas;
    }

    // -------------------------------------   F <<
    private static void rasyti(String failas, Integer[] arr) throws IOException {

        BufferedWriter output = null;

        try {
            output = new BufferedWriter(new FileWriter(failas));
            StringBuilder text = new StringBuilder();

            for (int i = 0; i < arr.length; i++) {
                text.append(arr[i]).append(" ");
            }
            output.write(text.toString());
            text.append(System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

}
