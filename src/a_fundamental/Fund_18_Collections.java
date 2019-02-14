package a_fundamental;

import a_fundamental.filesJava.Employee;
import a_fundamental.filesJava.Employee2;
import a_fundamental.filesJava.Salary;
import a_fundamental.filesJava.Zmogus;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Fund_18_Collections {

    public static void main(String[] args) {

        String s___ = ("---------------------------------------------------------------------- new Main");
        System.out.println("*************************************************************************************");
        System.out.println("*    Džiugo pavyzdžiai: Collection, stream, 3sprintas/src/java14/demo1, 2 ... 13    *");
        System.out.println("*************************************************************************************");
        System.out.println(s___ + " 1");
        Collection_ListArrayList.main(new String[]{});
        System.out.println(s___ + " 2");
        Collection_SetHashSetTreeSet.main(new String[]{});
        System.out.println(s___ + " 3");
        Collection_MapHashMapTreeMap.main(new String[]{});
        System.out.println(s___ + " 4");
        Collection_QueuePriorityQueue.main(new String[]{});
        System.out.println(s___ + " 5");
        Collection_SetTreeSet_Iterator.main(new String[]{});
        System.out.println(s___ + " 6");
        Collection_ListArrayList_Iterator.main(new String[]{});
        System.out.println(s___ + " 7");
        Collection_SetTreeSet_Employee.main(new String[]{});
        System.out.println(s___ + " 8");
        Collection_FunctionPredicateSupplierOptional.main(new String[]{});
        System.out.println(s___ + " 9");
        Collection_ListArrayList_stream.main(new String[]{});
        System.out.println(s___ + " 10");
        Collection_ListArrayList_stream2.main(new String[]{});
        System.out.println(s___ + " 11");
        Collection_IntStream_stream3.main(new String[]{});
        System.out.println(s___ + " 12");
        Collection_ReduceBiFunction_stream4.main(new String[]{});
        System.out.println(s___ + " 13");
        Collection_ListSetMap_collectors_groupingBy_stream5.main(new String[]{});
        System.out.println(s___ + " uzduotis 1, uzdotis 3");
        Collection_ZmogusIrSalaryExamle.main(new String[]{});
    }
}

class Collection_ListArrayList {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(20);
        list.add(0, 40);
//        Collections.sort(list);
        System.out.print("Sąrašas:");
        for (Integer i : list) {
            System.out.print(" " + i);
        }
        System.out.println();

        System.out.println("Ar yra 20? = " + list.contains(20));
        System.out.println("(1) = " + list.get(1));

        System.out.println("Išmetam is sąrašo (0) ir 20");
        list.remove(0);
        list.remove(Integer.valueOf(20));

        System.out.print("Sąrašas:");
        for (Integer i : list) {
            System.out.print(" " + i);
        }
        System.out.println();


        List<Integer> b = new ArrayList<>();
        b.add(25);
        b.add(26);

        list.addAll(b);

        System.out.print("Sąrašas:");
        for (Integer i : list) {
            System.out.print(" " + i);
        }
        System.out.println();

        b.clear();
        b.add(10);
        b.add(20);
        System.out.println("Ar yra 10,20? = " + list.containsAll(b));

        b.add(21);
        System.out.println("Ar yra 10,20,21? = " + list.containsAll(b));

    }
}

class Collection_SetHashSetTreeSet {

    public static void main(String[] args) {

        System.out.println("HashSet:");
        testSet(new HashSet<>());

        System.out.println("--------------------");

        System.out.println("TreeSet:");
        testSet(new TreeSet<>());
    }


    private static void testSet(Set<Integer> set) {

        set.add(30);
        set.add(20);
        set.add(50);
        set.add(20);
        set.add(10);

        System.out.print("Aibės dydis " + set.size() + ": ");
        for (Integer i : set) {
            System.out.print(" " + i);
        }
        System.out.println();

        System.out.println("Ar yra 20? = " + set.contains(20));

        System.out.println("Išmetam is sąrašo 20");
        set.remove(20);

        System.out.print("Aibės dydis " + set.size() + ": ");
        for (Integer i : set) {
            System.out.print(" " + i);
        }
        System.out.println();

    }
}

class Collection_MapHashMapTreeMap {

    public static void main(String[] args) {

        System.out.println("HashMap:");
        testMap(new HashMap<>());

        System.out.println("--------------------");

        System.out.println("TreeMap:");
        testMap(new TreeMap<>());

    }

    private static void testMap(Map<String, Integer> map) {

        map.put("trisdešimt", 30);
        map.put("dvidešimt", 20);
        map.put("penkiasdešimt", 50);
        map.put("dvidešimt", 20);
        map.put("šeši", 6);
        map.put("septyniasdešimt", 70);


        System.out.print("Žodyno reikšmės:");
        for (Integer i : map.values()) {
            System.out.print(" " + i);
        }
        System.out.println();
        System.out.print("Žodyno raktai:");
        for (String i : map.keySet()) {
            System.out.print(" " + i);
        }
        System.out.println();

        System.out.println("Ar yra reikšmė 20? = " + map.containsValue(20));
        System.out.println("Ar yra raktas 'dešimt'? = " + map.containsKey("dešimt"));

        System.out.println("Išmetam objektą su raktu 'dešimt'");
        map.remove("dešimt");

        System.out.print("Žodyno reikšmės:");
        for (Integer i : map.values()) {
            System.out.print(" " + i);
        }
        System.out.println();
        System.out.print("Žodyno raktai:");
        for (String i : map.keySet()) {
            System.out.print(" " + i);
        }
        System.out.println();
    }
}

class Collection_QueuePriorityQueue {

    public static void main(String[] args) {

        testQueue(new PriorityQueue<>());

    }

    private static void testQueue(Queue<Integer> queue) {

        queue.add(30);
        queue.add(20);

        queue.add(50);
        queue.add(20);
        queue.add(10);

        System.out.print("Eilė:");
        for (Integer i : queue) {
            System.out.print(" " + i);
        }
        System.out.println();

        System.out.println("Ar yra 20? = " + queue.contains(20));

        System.out.println("Išmetam is sąrašo paskutinį, t.y. 10");
        queue.poll();

        System.out.print("Eilė:");
        for (Integer i : queue) {
            System.out.print(" " + i);
        }
        System.out.println();
    }
}

class Collection_SetTreeSet_Iterator {

    public static void main(String[] args) {

        Collection<String> set = new TreeSet<>();

        set.add("Kaunas");
        set.add("Vilnius");
        set.add("Kaunas");
        set.add("Alytus");
        set.add("Klaipėda");
        set.add("Vilnius");
        set.add("Kaunas");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();

            System.out.println(s);
        }

    }
}

class Collection_ListArrayList_Iterator {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Kaunas");
        list.add("Vilnius");
        list.add("Kaunas");
        list.add("Alytus");
        list.add("Klaipėda");
        list.add("Vilnius");
        list.add("Kaunas");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();

            if (s.equals("Vilnius")) {
                iterator.remove();
            }
        }
        System.out.println(list);

        System.out.println("-------------------------------");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("Kaunas")) {
                list.remove(i);
            }
        }

        System.out.println(list);


        for (String miestas : list) {
            if (miestas.equals("Alytus")) {
                list.remove(miestas);
            }
        }

        System.out.println(list);
    }

}


class Collection_SetTreeSet_Employee {

    public static void main(String[] args) {

//        List<Employee> list = new ArrayList<>();
        Collection<Employee> list = new TreeSet<>();
//        Collection<Employee> list = new HashSet<>();

        list.add(new Employee(1, "Ona", "administracija", new BigDecimal("11.00")));
        list.add(new Employee(2, "Zenonas", "pardavimai", new BigDecimal("9.00")));
        list.add(new Employee(3, "Audra", "administracija", new BigDecimal("10.00")));
        list.add(new Employee(4, "Ignas", "administracija", new BigDecimal("12.00")));
        list.add(new Employee(5, "Jonas", "pardavimai", new BigDecimal("9.00")));
        list.add(new Employee(6, "Petras", "pardavimai", new BigDecimal("7.00")));
        list.add(new Employee(7, "Antanas", "apskaita", new BigDecimal("12.00")));
        list.add(new Employee(8, "Rasa", "administracija", new BigDecimal("12.00")));
        list.add(new Employee(9, "Ona", "pardavimai", new BigDecimal("10.00")));
        list.add(new Employee(1, "Ona", "administracija", new BigDecimal("9.00")));
        list.add(new Employee(1, "Ona", "administracija", new BigDecimal("9.00")));

        for (Employee employee : list) {
            System.out.println(employee);
        }
//        list.forEach(x-> System.out.println(x));

        System.out.println("Sulygiuota:");
//        Collections.sort(list);
        for (Employee employee : list) {
            System.out.println(employee);
        }


        // 7, 8, 9
//        Collections.sort(list, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                int comp = o1.getDepartment().compareTo(o2.getDepartment());
//                if (comp == 0) {
//                    return o1.getName().compareTo(o2.getName());
//                } else {
//                    return comp;
//                }
//            }
//        });

        System.out.println("Sulygiuota pagal skyrius-vardas:");
        for (Employee employee : list) {
            System.out.println(employee);
        }

//        // >= 8
//        list.sort(new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                int comp = o1.getName().compareTo(o2.getName());
//                if (comp == 0) {
//                    return o1.getDepartment().compareTo(o2.getDepartment());
//                } else {
//                    return comp;
//                }
//            }
//        });
//
//        System.out.println("Sulygiuota pagal vardas-skyrius:");
//        for (Employee employee : list) {
//            System.out.println(employee);
//        }


//        list.sort(new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return 0;
//            }
//        });

//        System.out.println("Sulygiuota:");
//        for (Employee employee : list) {
//            System.out.println(employee);
//        }
    }
}

class Collection_FunctionPredicateSupplierOptional {

    public static void main(String[] args) {

        Function<String, Integer> convert = Integer::parseInt;
        System.out.println("convert 123 -> " + convert.apply("123"));

        Predicate<Integer> positive = x -> x > 0;
        System.out.println("positive(1) " + positive.test(1));
        System.out.println("positive(-2) " + positive.test(-2));

        Supplier<Integer> generator = new Random()::nextInt;

        // todo Consumer ??

        List<Optional<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int r = generator.get();
            System.out.println("random #" + i + " -> " + r);

            Optional<Integer> opt = r < 0 ? Optional.empty() : Optional.of(r);
            list.add(opt);
        }
        long sum = 0;
        for (Optional<Integer> opt : list) {
            sum += opt.orElse(0);
        }
        System.out.println("sum = " + sum);

        Optional<Integer> op = Optional.ofNullable(0);
        int a = op.orElse(1);
        System.out.println("a = " + a);

    }
}

class Collection_ListArrayList_stream {

    public static void main(String[] args) {

        List<Employee2> list = new ArrayList<>();
        list.add(new Employee2("Kazys", 1400.0, "administration"));
        list.add(new Employee2("Jonas", 800.0, "store"));
        list.add(new Employee2("Ona", 900.0, "sales"));
        list.add(new Employee2("Petras", 1200.0, "sales"));
        list.add(new Employee2("Ada", 1500.0, "administration"));

        System.out.println(" - stream:");
        list.stream().filter(new Predicate<Employee2>() {
            @Override
            public boolean test(Employee2 employee) {
                return employee.getSalary() > 1000.0;
            }
        }).forEach(new Consumer<Employee2>() {
            @Override
            public void accept(Employee2 employee) {
                System.out.println(employee);
            }
        });

        System.out.println(" - sutrumpintas stream:");
        list.stream().filter((Employee2 employee) -> employee.getSalary() > 1000.0).forEach(System.out::println);

        System.out.println(" - parallelStream:");
        list.parallelStream().filter(e -> e.getSalary() < 1400.0).forEach(System.out::println);

    }
}

class Collection_ListArrayList_stream2 {

    public static void main(String[] args) {

        List<Employee2> list = new ArrayList<>();
        list.add(new Employee2("Kazys", 1400.0, "administration"));
        list.add(new Employee2("Jonas", 800.0, "store"));
        list.add(new Employee2("Ona", 900.0, "sales"));
        list.add(new Employee2("Petras", 1200.0, "sales"));
        list.add(new Employee2("Ada", 1500.0, "administration"));

        System.out.println(" stream of List:");
        list.stream().filter(e -> e.getSalary() > 1000.0).forEach(System.out::println);

        System.out.println(" stream of parameters:");
        Stream.of(1, 2, 3, 4).findAny().ifPresent(System.out::println);

        System.out.println(" stream of range 1..100: " +
                IntStream.range(1, 101).sum()
        );

        System.out.println(" stream of random numbers: " +
                new Random().ints(100, 1, 100).sum()
        );
    }
}

class Collection_IntStream_stream3 {

    public static void main(String[] args) {

        // Filter
        IntStream stream = IntStream.range(1, 101);
        // Srauto negalima panaudoti du kartus!!!
        // kadangi count() suskaičiuoja elementus "praleisdamas" srautą
        // tai tolimesni vaiksmai su tuo pačiu srautu iššauks klaidą
        //System.out.println("Viso " + stream.count());
        long count2 = stream
                .filter(x -> x % 2 == 0)
                .filter(x -> x > 10)
                .count();
        System.out.println("Viso lyginių didesnių už 10 yra " + count2);

        // Map
        int suma = IntStream.range(1, 201)
                .filter(x -> x % 2 == 0)
                .map(x -> x / 2).sum();
        System.out.println("Suma " + suma);

        // Sorted
        System.out.print("sorted");
        stream = new Random().ints(10, 1, 1000);
        stream.sorted().forEach(x -> System.out.print(" " + x));
        System.out.println();
    }
}

class Collection_ReduceBiFunction_stream4 {

    public static void main(String[] args) {

        // Reduce
        /*
          reduce(accumulator):

          boolean foundAny = false;
          int result = null;
          for (int element : this stream) {
              if (!foundAny) {
                  foundAny = true;
                  result = element;
              }
              else
                  result = accumulator.applyAsInt(result, element);
          }
          return foundAny ? OptionalInt.of(result) : OptionalInt.empty();
         */
        OptionalInt reduce = IntStream.range(1, 101).reduce((x, y) -> x + y);
        System.out.println("reduce 1: " + reduce);

        /*
          reduce(identity, accumulator):

          int result = identity;
          for (int element : this stream)
              result = accumulator.applyAsInt(result, element)
          return result;
         */
        int sum = IntStream.range(1, 101).reduce(-50, (x, y) -> x + y);
        System.out.println("reduce 2: " + sum);

        /*
          reduce(identity, accumulator, combiner):

          U result = identity;
          for (T element : this stream)
              result = accumulator.apply(result, element)
          return result;

          The identity value must be an identity for the combiner function.
          This means that for all u, combiner(identity, u) is equal to u
          Additionally, the combiner function must be compatible with the accumulator function;
          for all u and t, the following must hold:
          combiner.apply(u, accumulator.apply(identity, t)) == accumulator.apply(u, t)
         */

        BiFunction<A, Integer, A> accumulator = (s, x) -> {
            A rez = s.copy();
            if (x % 2 == 0) rez.setEven(rez.getEven() + x);
            else rez.setOdd(rez.getOdd() + x);
            System.out.println("a: (" + s + ", " + x + ") -> " + rez);
            return rez;
        };

        BinaryOperator<A> combiner = (s, x) -> {
            A rez = s.copy();
            rez.setOdd(rez.getOdd() + x.getOdd());
            rez.setEven(rez.getEven() + x.getEven());
            System.out.println("c: (" + s + ", " + x + ") -> " + rez);
            return rez;
        };

        A sum1 = IntStream.range(1, 11)
                .boxed()
                //.parallel() - jei ne parallel tai combiner neiškviečiamas!!!
                .reduce(new A(0, 0), accumulator, combiner);
        System.out.println("reduce 3.1: " + sum1);

        A sum2 = IntStream.range(1, 11)
                .boxed()
                .parallel()
                .reduce(new A(0, 0), accumulator, combiner);
        System.out.println("reduce 3.2: " + sum2);
    }
//}

    static class A {
        int even;
        int odd;

        public A(int even, int odd) {
            this.even = even;
            this.odd = odd;
        }

        @Override
        public String toString() {
            return "A{" +
                    "even=" + even +
                    ", odd=" + odd +
                    '}';
        }

        public A copy() {
            return new A(even, odd);
        }

        public int getEven() {
            return even;
        }

        public void setEven(int even) {
            this.even = even;
        }

        public int getOdd() {
            return odd;
        }

        public void setOdd(int odd) {
            this.odd = odd;
        }
    }
}

class Collection_ListSetMap_collectors_groupingBy_stream5 {

    public static void main(String[] args) {

        List<Employee2> employees = new ArrayList<>();
        employees.add(new Employee2("Kazys", 1400.0, "administration"));
        employees.add(new Employee2("Jonas", 800.0, "store"));
        employees.add(new Employee2("Ona", 900.0, "sales"));
        employees.add(new Employee2("Petras", 1200.0, "sales"));
        employees.add(new Employee2("Ada", 1500.0, "administration"));

        // Išrinkti visus skyrius
        Set<String> s1 = employees.stream()
                .map(Employee2::getDepartment)
                .collect(Collectors.toSet());
        System.out.println("Set<String>: " + s1);

        // Išrinkti visus skyrius ir jų darbuotojus
        Map<String, List<Employee2>> s2 = employees.stream()
                .collect(Collectors.groupingBy(Employee2::getDepartment));
        System.out.println("Map<String, List<Employee>>: " + s2);

        // Išrinkti visus skyrius ir jų darbuotojų suminius atlyginimus
        Map<String, Double> s3 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee2::getDepartment,
                        Collectors.reducing(0.0, Employee2::getSalary, Double::sum)));
        System.out.println("Map<String, Double>: " + s3);

        // Išrinkti visus skyrius ir jų darbuotojų vardus
        Map<String, Set<String>> s4 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee2::getDepartment,
                        Collectors.mapping(Employee2::getName, Collectors.toSet())
                ));
        System.out.println("Map<String, Set<String>>: " + s4);
    }
}

class Collection_ZmogusIrSalaryExamle{

    public static void main(String[] args) {

        System.out.println("*** TreeMap<String, Zmogus> example ***");

        Map<String, Zmogus> zodynas = new HashMap<>();

        zodynas.put("3",new Zmogus("Andrius", "Petras", "3"));
        zodynas.put("1",new Zmogus("Jonas", "Petras", "1"));
        zodynas.put("4",new Zmogus("Darius", "Petras", "4"));
        zodynas.put("3",new Zmogus("Andrius", "Petras", "3"));
        zodynas.put("1",new Zmogus("Jonas", "Petras", "1"));
        zodynas.put("2",new Zmogus("Jonas", "Petras", "2"));
        zodynas.put("5",new Zmogus("Andrius", "Petras", "5"));
        zodynas.put("1",new Zmogus("Jonas", "Petras", "1"));
        zodynas.put("2",new Zmogus("Darius", "Petras", "2"));

        System.out.println(zodynas);

        TreeMap<String, Zmogus> treeZodynas = new TreeMap<>(zodynas);
        System.out.println(treeZodynas);



        System.out.println("*** Salary example ***");

        List<Salary> list = new ArrayList<>();
        list.add(new Salary(new Employee2("Kazys", 1400.0, "administration"), 200d));
        list.add(new Salary(new Employee2("Jonas", 800.0, "store"), 100d));
        list.add(new Salary(new Employee2("Ona", 900.0, "sales"), 300d));
        list.add(new Salary(new Employee2("Petras", 1200.0, "sales"), 500d));
        list.add(new Salary(new Employee2("Ada", 1500.0, "administration"), 200d));
        list.add(new Salary(new Employee2("Kazys", 1400.0, "administration"), 150d));
        list.add(new Salary(new Employee2("Jonas", 800.0, "store"), 200d));
        list.add(new Salary(new Employee2("Ona", 900.0, "sales"), 100d));
        list.add(new Salary(new Employee2("Petras", 1200.0, "sales"), 400d));
        list.add(new Salary(new Employee2("Ada", 1500.0, "administration"), 300d));

//       1 uzd
        Map<String, Double> s1 = list.stream()
                .collect(Collectors.groupingBy(
                        o -> o.getEmployee().getName(),
                        Collectors.reducing(0.0, o -> o.getAtlyginimas(), Double::sum)));
//        Collections.sort(s1, new Comparator<Map.Entry<String, Double> >() {
//            @Override
//            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
//                return (o1.getValue().compareTo(o2.getValue()));
//            }
//        });
//        LinkedHashMap<String, Double> newMap = new LinkedHashMap<>(s1);
//        Collections.sort(newMap, Comparator.comparing(LinkedHashMap.Entry.));
        System.out.println("Palei atlyginima " + s1);
//        Collections.sort(s1, (o1, o2) ->);

        Map<String, Long> s2 = list.stream()
                .collect(Collectors.groupingBy(
                        o -> o.getEmployee().getName(), Collectors.counting()
                ));

        System.out.println("Map<String, Double>: " + s2);
    }
}
