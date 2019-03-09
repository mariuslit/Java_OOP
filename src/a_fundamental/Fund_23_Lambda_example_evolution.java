package a_fundamental;

import java.util.*;

public class Fund_23_Lambda_example_evolution {

    public static void main(String[] args) {
        /*
         * vidinė klasė
         */
        class AAA {

            private String tekstas;
            private Integer skaicius;

            public AAA(String tekstas, Integer skaicius) {
                this.tekstas = tekstas;
                this.skaicius = skaicius;
            }

            @Override
            public String toString() {
                return "AAA{" + "tekstas='" + tekstas + "'" + ", skaicius=" + skaicius + '}';
            }

            public String getTekstas() {
                return tekstas;
            }

            public Integer getSkaicius() {
                return skaicius;
            }
        }

        // 1 sukuriamas AAA objektų list'as ir atspausdinamas originalia tvarka
        System.out.println("unsort A-K");
        List<AAA> list = new ArrayList<>();
        list.add(new AAA("A", 5));
        list.add(new AAA("Z", 9));
        list.add(new AAA("K", 1));
        list.forEach(a -> System.out.println(a.toString()));

        /*
         * Anoniminė klasė ir Lambda išraiška (prastinimo eiliškumu)
         */

        // 1 sukuriama anoniminė klasė, tada jos objektas panaudojamas su list.sort
        System.out.println("\nsort A-Z");
        class Cmp implements Comparator<AAA> {
            @Override
            public int compare(AAA o1, AAA o2) {
                return o1.getTekstas().compareTo(o2.getTekstas());
            }
        }
        Cmp cmp = new Cmp();
        list.sort(cmp);
        list.forEach(a -> System.out.println(a.toString()));


        // 2 anoniminė klasė įkeliama iš karto į list.sort
        System.out.println("\nsort Z-A");
        list.sort(new Comparator<AAA>() {
            @Override
            public int compare(AAA o1, AAA o2) {
                return o2.getTekstas().compareTo(o1.getTekstas());
            }
        });
        list.forEach(a -> System.out.println(a.toString()));


        // 3 anoniminė klasė virsta į lambda išraišką list.sort viduje
        System.out.println("\nsort 1-9");
        list.sort((AAA o1, AAA o2) -> {
            return o1.getSkaicius().compareTo(o2.getSkaicius());
        });
        list.forEach(a -> System.out.println(a.toString()));


        // 4 pašalinami kintamųjų tipai, skliausteliai{} ir return'as
        System.out.println("\nsort 9-1");
        list.sort((o1, o2) -> o2.getSkaicius().compareTo(o1.getSkaicius()));
        list.forEach(a -> System.out.println(a.toString()));


        // 5 lambda išraiška užrašoma kitaip (trumpasis variantas)
        System.out.println("\nsort A-Z");
        list.sort(Comparator.comparing(AAA::getTekstas));
        list.forEach(a -> System.out.println(a.toString()));
    }
}

