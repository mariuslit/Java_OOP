package a_fundamental;

import a_fundamental.filesJava.Zmogus;
import k_2_14_KeliaiMasinosZmones.Masina;

import java.util.*;
import java.util.stream.Collectors;

public class Fund_21_Stream {

    public static void main(String[] args) {
/*
        Stream
            .stream()      kolekcijų srautas
            .map(...)      elementai keičiami,
            .filter(...)   atrenkami
            .sort(...)     rūšiuojami
            .collect(...)  surenkami į konteinerį, jei reikia

        Yra dviejų rūšių srautų operacijos:
        1. TARPINĖ - jos rezultatas yra kitas srautas
            filter - filtravimas - tarpinė operacija, kurios parametras Predicate funkcijos tipo.
                    Praleidžiami tik tie srauto elementai, kuriems funkcija grąžina true
            sort,sorted - tarpinė operacija kuri lygiuoja srauto elementus

            map - tarpinė operacija, kurios parametras Function tipo.
                    Funkcija vykdoma kiekvienam srauto elementui ir grąžinamas naujas srautas

            reduce - mažinimo galutinė operacija grąžinanti Optional
                    reduce(BinaryOperator accumulator)
                    reduce(identity, BinaryOperator accumulator)
                    reduce(identity, BiFunction accumulator, BinaryOperator combiner)

        2. GALUTINĖ - ji
            arba neturi rezultato
                (void)
            arba rezultatas nėra srautas
                forEach - kiekvienam elementui atliekama funkcija
                .sum() - suma
                ifPresent, …
            collect - iš srauto sukuria kolekciją
                    Collectors.toList()
                    Collectors.toSet()
                    Collectors.toMap()
                    Collectors.groupingBy()
                    Collectors.reducing()
                    Collectors.mapping()

        Paprasčiausi būdai gauti srautą:
            Arrays.stream(…)
            kolekcija.stream()…
            kolekcija.parallelStream()…
            Stream.of(…)
            IntStream, DoubleStream….
            new Random().ints(…)
*/

        Set<Masina> masinos = new HashSet<>();

        masinos.add(new Masina("VW", "ABC:123"));
        masinos.add(new Masina("VW", "QWE:789"));
        masinos.add(new Masina("VW", "zxc:123"));
        masinos.add(new Masina("VW", "zxc:123"));
        masinos.add(new Masina("Ford", "OKL:951"));
        masinos.add(new Masina("VW", "zxc:123"));

        Masina masina = new Masina("VW", "zxc:123");

        simpleStream();
        System.out.println(containsCar(masinos, masina));
        System.out.println(gautiKolekcjaBeNurodytosMasinos(masinos, masina)); // Set filter
        ivairiosStream_MapToList_getValues_exampless(); // filtruoja atrenka konvertuoja sumuoja
    }

    public static void simpleStream() {

        System.out.println("-----   STREAM 1  -----\n");

        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1", "caswinciu");

        myList.stream()
                .filter(a -> a.startsWith("c")) // filtruoja, paleidžia po viena masyvo elementa, jeigu atitinka salyga (salyga turi būti boolean)
                .map(a -> a.toUpperCase())      // keičia elementus LAMBDA
                .map(String::toUpperCase)       // keičia elementus LAMBDA trumpesnis var.
                .sorted()                       // rūšiuoja sort a-z
                .forEach(System.out::println);  // atspausdina
    }
//                .findAny() // pasakoma kad paimk tik vieną betkurį elementa iš masyve , grąžina optional (obektas kuris ne lygus null))

    // surasti ar Set kolekcija turi Objektą masina
    public static boolean containsCar(Set<Masina> masinos, Masina masina) {

        System.out.println("-----   STREAM 2  -----\n");
        // STREAM
        Set<Masina> filtered;
        filtered = masinos.stream()
                .filter(mc -> mc.getNumeriai().equals(masina.getNumeriai())) // jeigu lygu
                .collect(Collectors.toSet()); // surenka į naują kolekciją

        System.out.println(filtered.size());
        return filtered.size() > 0;
    }

    public static Set<Masina> gautiKolekcjaBeNurodytosMasinos(Set<Masina> masinos, Masina masina) {

        System.out.println("-----   STREAM 3  -----\n");
        // STREAM
        Set<Masina> filtered;
        filtered = masinos.stream()
                .filter(a -> !a.getNumeriai().equals(masina.getNumeriai())) // jeigu ne lygu
                .collect(Collectors.toSet()); // surenka į naują kolekciją

        System.out.println(filtered.size());
        return filtered;
    }

    public static void ivairiosStream_MapToList_getValues_exampless() {

        System.out.println("-----   STREAM 4  -----\n");

        // STREAM
        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 12);
        map.put(2, 24);
        map.put(3, 10);

        int sum = map.values()
                .stream()
                .mapToInt(i -> i)
                .sum();


        Map<Integer, Zmogus> sportininkai = new TreeMap<>();

        sportininkai.put(1, new Zmogus("Andrius", "Petwwwwwwwwwwwwwwras", "3"));
        sportininkai.put(2, new Zmogus("Jonas", "Petrasxxxxxxxxxx", "5"));
        sportininkai.put(3, new Zmogus("Darrrrrrius", "Petras", "4"));
        sportininkai.put(4, new Zmogus("Andrius", "Peoootras", "3"));
        sportininkai.put(5, new Zmogus("Joncccccccccccccccahhs", "Petccccccccccccras", "5"));
        sportininkai.put(6, new Zmogus("Jonas", "Petras", "2"));
        sportininkai.put(7, new Zmogus("Ankkdrius", "Ps", "5"));
        sportininkai.put(8, new Zmogus("Joggnas", "Plletras", "1"));
        sportininkai.put(9, new Zmogus("Dius", "Pes", "5"));

        List<Integer> filtered = sportininkai.values()
                .stream()
                .filter(a -> a.getAsmensKodas().equals("5")) // filtruoja visus kurie jeigūs lygu 5
                .map(a -> (a.getVardas() + a.getPavarde()).toCharArray().length) // sudeda į list'ą asmens vardas + pavardė ilgį
                        .collect(Collectors.toList()); // surenka į naują kolekciją
        System.out.println(filtered);

        int result2 = filtered
                .stream()
                .mapToInt(a -> a)
                .sum();
        System.out.println(result2);

        Set<String> result3 = sportininkai.values()
                .stream()
                .map(a -> a.getAsmensKodas())
                .collect(Collectors.toSet());
        System.out.println(result3);



    }
}
