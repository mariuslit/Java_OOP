package a_Kamiles;

public class Kamilei {

    public static void main(String[] args) {

        Integer skaicius = 5;
        System.out.println(skaicius);

        skaicius = 16;
        System.out.println(skaicius);

        skaicius++;
        System.out.println(skaicius);

        for (int i = 0; i < 3; i++) {
            System.out.println(i + skaicius);
        }

        String txt;
        String txt2 = "";
        String txt3 = null;
        String txt4 = "paskaita";
        txt = "bchdch ";
        System.out.println(txt + txt4);

        // masyvo sukūrimas
        Integer[] arr = new Integer[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 5;
        arr[4] = 4;

        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);
        System.out.println(arr.length);

        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);
        }

        System.out.println();

        for (int i = arr.length - 1; i >= 0; i--) {

            System.out.println(arr[i]);
        }

        // metodai

        // tuščias metodas
        suma2();

        // metodas grąžinantis eikšmę
        System.out.println(suma3());

//        System.out.println(sum4(5.5, 4));

        Double ddd = sum4(7.9, 3);
        ddd++;
        System.out.println(ddd);

        ddd = sum4(1d, 4);
        System.out.println(ddd);

        suma5(arr);

    }

    public static void suma5(Integer[] back) {

        Integer suma = 0;

        for (int i = 0; i < back.length; i++) {

            suma = suma + back[i];
        }
        System.out.println(suma);

        System.out.println(back[0] + back[1] + back[2] + back[3] + back[4]);
    }

    public static Double sum4(Double x, Integer y) {

        Double sum = x + y;
        return sum;
    }


    public static void suma2() {

        if (true) {

            System.out.println("čia suma() metodas 1");
//            return;
        } else if (false) {

            System.out.println("čia suma() metodas 2");
            return;
        }

        System.out.println("čia suma() metodas 3");
    }

    public static Integer suma3() {

        return 44;
    }
}
