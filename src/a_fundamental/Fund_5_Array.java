package a_fundamental;

import java.util.Arrays;
import java.util.Comparator;

public class Fund_5_Array {

    public static void main(String args[]) {

        // ARRAY DEKLARAVIMAS

        // 1 tik deklaravimas
        String[] arr1; // pageidautinas
        // String []arr2; // inteliJ automatiškai pakoreguoja tokį deklaravimą
        String arr3[];

        // 2 deklaravimas, inicializavimas su default reikšėmis
        int[] arr4 = new int[5]; // 5 narių asyvas, kurių reikšmės Integer tipo = 0 (default)
        String[] arr44 = new String[5]; // 5 narių asyvas, kurių reikšmės String tipo = null (default)
        for (int i = 0; i < arr4.length; i++) {
            System.out.println(arr4[i] + " " + arr44[i]);
        }

        // 3 deklaravimas su priskyrimu
        String[] arr5 = new String[]{"pirmas index=0", "2", "trečias"}; // užpildytas trijų narių masyvas
        String[] arr6 = {"pirmas index =0", "-2-", "trečias"}; // new String[] rašyti ne būtina
        int[] arr7 = {1, 2, 3};

        System.out.println(arr5[0]);
        System.out.println(arr6[1]);
        System.out.println(arr7[2]);
        System.out.println(arr7.getClass().getName());

        int a[] = new int[5];
        a[0] = 10; // initialization
        a[1] = 20; // initialization
        a[2] = 30; // initialization
        a[3] = 40; // initialization
        a[4] = 50; // initialization
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        // masyvo pdidinimas vienu elementu
        int[] b = Arrays.copyOf(a, a.length + 1);
        b[5] = 60; // initialization
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }


        // array kopijavimas
        char[] copyFrom = {
                'd', 'e', 'c', 'a', 'f', 'f', 'e', 'i', 'n', 'a', 't', 'e', 'd'};
        char[] copyTo = new char[7];

        //copying array using System.arraycopy() method
        System.arraycopy(copyFrom, 2, copyTo, 0, 7);

        //printing the destination array
        System.out.println(String.valueOf(copyTo));


        //=======================================================================================//
        // matrix[][]     matrix[][]     matrix[][]     matrix[][]     matrix[][]     matrix[][] //
        //=======================================================================================//

        // Masyvų masyvas (dvimačio masyvo Java neturi):
        int[][] matrix1 = new int[4][6];

        // Paskelbimo metu būtina nurodyti tik pirmąjį išmatavimą, o antrą galima nurodyti ir vėliau:
        int[][] matrix2 = new int[4][];
        matrix2[0] = new int[5]; // pirma eilutė – 5 elementai
        matrix2[1] = new int[6]; // antra eilutė – 6 elementai

        // Tiesioginis paskelbimas (be new):
        int matrix3[][] = {{1, 2, 3}, {4, 500}, {5, -10, 120, -155, 7, 11}};

        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[i].length; j++) {
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }

        MaistoProduktai[] mp = new MaistoProduktai[4];

        mp[0] = new MaistoProduktai("Pienas", 3d, 6);
        mp[1] = new MaistoProduktai("Duona", 1d, 5);
        mp[2] = new MaistoProduktai("Dešra", 0.4, 10);
        mp[3] = new MaistoProduktai("Kepenėlės", 0.5, 2);


        // greitas būdas išrūšiuoti objektų mąsyvą pagal parametrą
        Arrays.sort(mp, Comparator.comparing(MaistoProduktai::getKiekis));
        spausdinti(mp,"\n pagal kiekį");
        Arrays.sort(mp, Comparator.comparing(MaistoProduktai::getGaliojimasDien));
        spausdinti(mp,"\n pagal galiojimą");
    }

    public static <T> void spausdinti(T[] arr, String txt) {
        System.out.println(" - "+txt);
        for (T item : arr) {

            System.out.println(item.toString());
        }
    }
}

class MaistoProduktai {
    private String name;
    private Double kiekis;
    private Integer galiojimasDien;

    public MaistoProduktai(String name, Double kiekis, Integer galiojimasDien) {
        this.name = name;
        this.kiekis = kiekis;
        this.galiojimasDien = galiojimasDien;
    }

    public String toString() {
        return getName() + " " + getKiekis() + " " + getGaliojimasDien();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getKiekis() {
        return kiekis;
    }

    public void setKiekis(Double kiekis) {
        this.kiekis = kiekis;
    }

    public Integer getGaliojimasDien() {
        return galiojimasDien;
    }

    public void setGaliojimasDien(Integer galiojimasDien) {
        this.galiojimasDien = galiojimasDien;
    }
}