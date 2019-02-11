package k_2_07_generic;

import use.GenericArrMethods;

public class GenericTestavimas<E> implements GenericArrMethods<E> {
    /*
       +   Sukurti Integer, Double, Character tipo masyvus ir aprašyti metodą, kuris atspausdintų visus šiuos tipus;
       +   Sukurti bendrinę klasę, kurioje būtų galima saugoti bet kokio tipo kintamąjį;
       +   Sukurti bendrinį metodą, kuriam perdavus bet kokio tipo masyvą ir reikšmę,
               bus suskaičiuojama kiek kartų tame masyve reikšmė kartojasi.
       +   Sukurti bendrinę klasę kuri turėtų du tipus <K,V> ir paveldėtų Pora interfeisą.
       +   Sukurti bendrinį metodą, kuris surikiuotų masyvą, nesvarbu koks masyvo tipas.
     */

    public static void main(String[] args) {

        GenericTestavimas genericTestavimas = new GenericTestavimas();
        genericTestavimas.test();
    }

    public void test() {

        String[] str = {"pirmas", "antras", "trečias", "Java nykštukai = Gaming-pro"};
        Double[] dbl = {5d, 6d, 98.9, 5d, -85.58, 77.01};
        Character[] chr = {'a', 'f', 'r', 'a'};
        Integer[] nt = {7, 9, 8, 7, 5, 6, 2, 4, 5, 3, 2, 5, 7, 8, 9, 5};

        atspausdinti(str, dbl, chr, nt);

        BendrineKlase<String> bk = new BendrineKlase<String>();
        bk.set(str[3]);
        System.out.println(bk.get());

        System.out.println("Kiek pasikartoja xxx " + numberOfValues(str, "xxx")); // iš interfeiso
        System.out.println("Kiek pasikartoja 5.0 " + numberOfValues(dbl, 5d)); // iš interfeiso
        System.out.println("Kiek pasikartoja a   " + kiekPasikartojanciuReiksmiu(chr, 'a'));
        System.out.println("Kiek pasikartoja 7   " + kiekPasikartojanciuReiksmiu(nt, 7));

        Poros<Integer, String> manoMap = new Poros<>();
        manoMap.setKey(55);
        manoMap.setValue("penki penki");

//        System.out.println(
        nt = arraySortAsseding(nt);
        atspausdinti(nt);
        System.out.println(nt.length);
        nt = addElment(nt, 100);
        System.out.println(nt.length);

    }

    public static <E> void atspausdinti(E[]... arr) {

        for (E[] arr2 : arr) {

            for (E element : arr2) {

                System.out.printf("%s-> ", element);
            }
            System.out.println();
        }
    }

    public static <E> int kiekPasikartojanciuReiksmiu(E[] arr, E reiksme) {

        int kiek = 0;

        for (E element : arr) {

            if (element.equals(reiksme)) {

                kiek++;
            }
        }
        return kiek;
    }
}


