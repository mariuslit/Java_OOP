package a_fundamental;

import java.util.ArrayList;
import java.util.List;

public class Fund_3_Loop_for_break_continue {

    public static void main(String[] args) {

        // Tarkime mums reikia susumuoti visus masyvo elementus pradedant nuo pirmo,
        // bet tik iki elemento kurio reikšmė yra 0,
        // bet nereikia sumuoti elementų kurių reikšmė = 20.

        int[] a = {15, 20, 2, 0, -5, 80};
        int suma = 0;

        for (int i = 0; i < a.length; ++i) {


            if (a[i] == 20) {
                continue;
            }

            if (a[i] == 0) {
                break;
            }
            suma += a[i];
        }
        System.out.println("suma = " + suma); //

        /*
         * FOR ciklo viduje Sring tipo masyvo narius galima palyginti: arr[i] == "xxx"
         * FOR EACH ciklo viduje Sring tipo masyvo narius galima palyginti: item.equals("xxx")
         * */

        // for vs forEach
        List<String> list = new ArrayList<>();

        list.add("Marius");
        list.add("Daius");
        list.add("Petras");
        list.add("Andrius");
        list.add("Jonux");

        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i));
        }

        System.out.println("---");

        for (String text : list) {

            System.out.println(text);
        }
    }
}
