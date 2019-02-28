package a_fundamental;

import a_fundamental.filesJava.Zmogus;
import k_2_15_namuDarbaiSavaitgaliui_Krepsinis_100proc.Zaidejas;

import java.util.*;

public class Fund_18_Lambda_Expression {

    public static void main(String[] args) {

        simple1(); // List sortByParameter print
//        simple2(); // Map print
//        simple3(); // Map + List printKey + printValue
//        simple4(); // Map sortByValue print
    }

    public static void simple1() {

        System.out.println("\n----- FUNDAMENTAL -----");
        System.out.println("Spausdinimas su lambda expression: list.forEach(a -> System.out.println(...)   \n");

        List<Zmogus> zmones = new ArrayList();

        zmones.add(new Zmogus("Andrius", "Petras", "3"));
        zmones.add(new Zmogus("Jonas", "Petras", "1"));
        zmones.add(new Zmogus("Darius", "Petras", "4"));
        zmones.add(new Zmogus("Andrius", "Petras", "3"));
        zmones.add(new Zmogus("Jonas", "Andrius", "1"));
        zmones.add(new Zmogus("Jonas", "Petras", "2"));
        zmones.add(new Zmogus("Andrius", "Petras", "5"));
        zmones.add(new Zmogus("Jonas", "Petras", "1"));
        zmones.add(new Zmogus("Darius", "Petras", "2"));

        Collections.sort(zmones, (o1, o2) -> o1.getVardas().compareTo(o2.getVardas()));

        // LAMBDA: atspausdina visas mašinas, kadangi list iteracija turi tik vieną reikšmę tai kintamajam zmogus ir priskiriama ta reiksme
        zmones.forEach(a -> System.out.println("List -> " + a.toString()));

        // // LAMBDA sutrumpintai: automatiškai susiranda elementa ir spausdina panaudodamas toString
        zmones.forEach(System.out::println);
    }

    public static void simple2() {

        System.out.println("\n----- FUNDAMENTAL -----");
        System.out.println("Spausdinimas su lambda expression: sportininkai.forEach((a, b) -> System.out.println(...)   \n");

        Map<Integer, Zmogus> sportininkai = new TreeMap<>();

        sportininkai.put(1, new Zmogus("Andrius", "Petras", "3"));
        sportininkai.put(2, new Zmogus("Jonas", "Petras", "1"));
        sportininkai.put(3, new Zmogus("Darius", "Petras", "4"));
        sportininkai.put(4, new Zmogus("Andrius", "Petras", "3"));
        sportininkai.put(5, new Zmogus("Jonas", "Petras", "1"));
        sportininkai.put(6, new Zmogus("Jonas", "Petras", "2"));
        sportininkai.put(7, new Zmogus("Andrius", "Petras", "5"));
        sportininkai.put(8, new Zmogus("Jonas", "Petras", "1"));
        sportininkai.put(9, new Zmogus("Darius", "Petras", "2"));

        // LAMBDA
        sportininkai.forEach((a, b) -> System.out.println("Map -> " + b.toString()));
    }

    public static void simple3() {

        System.out.println("\n----- FUNDAMENTAL -----");
        System.out.println("Spausdinimas su lambda expression: sportininkai.forEach((a, b) -> System.out.println(...)   \n");

        Map<String, List<Zmogus>> sportininkai = new TreeMap<>();

        List<Zmogus> list1 = new ArrayList();
        list1.add(new Zmogus("Andrius", "Petras", "3"));
        list1.add(new Zmogus("Jonas", "Petras", "1"));
        list1.add(new Zmogus("Darius", "Petras", "4"));
        sportininkai.put("Pirmas trejetas", list1);

        List<Zmogus> list2 = new ArrayList();
        list2.add(new Zmogus("Andrius", "Petras", "3"));
        list2.add(new Zmogus("Jonas", "Petras", "1"));
        list2.add(new Zmogus("Jonas", "Petras", "2"));
        sportininkai.put("Antras trejetas", list2);

        List<Zmogus> list3 = new ArrayList();
        list3.add(new Zmogus("Andrius", "Petras", "5"));
        list3.add(new Zmogus("Jonas", "Petras", "1"));
        list3.add(new Zmogus("Darius", "Petras", "2"));
        sportininkai.put("Trečias trejetas", list3);

        // LAMBDA + LAMBDA
        sportininkai.forEach((a, b) -> {

            System.out.println("Map -> Key: " + a.toString());

            b.forEach((c) -> {

                System.out.println("Map -> List -> " + c.toString());
            });

        });
    }

    public static void simple4() {

        System.out.println("\n----- FUNDAMENTAL -----");
        System.out.println("Sort su lambda expression:\n");
        System.out.println("Spausdinimas su lambda expression:\n");

        Map<Integer, Zaidejas> zaidejaiPirminis = new HashMap<>();

        // užpildom Map'ą
        for (int i = 1; i <= 7; i++) {
            zaidejaiPirminis.put(i, new Zaidejas(i, "vardas" + i, "pavarde" + i));
        }

        // sort pagal Key su Lambda išraiška, sort: Z-A, tinka tik su TreeMap
        // LAMBDA
        Map<Integer, Zaidejas> zaidejai = new TreeMap<>((o1, o2) -> o2.compareTo(o1));

        zaidejai.putAll(zaidejaiPirminis);

        zaidejai.forEach((a, b) -> System.out.println("Map -> " + b.toString()));
    }
}
