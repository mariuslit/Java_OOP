package a_fundamental;

import java.util.ArrayList;
import java.util.List;

public class Fund_17_generic_Inner_Anonymous_Local {

    //    * Bendrinis tipas netinka primityviems duomenų tipams:
    //          int, double... turi būti Integer, Double...
    //    * Negalima sukurti bendrinio tipo masyvo (kompiliavimo klaida):
    //          T[] x = new T[100];
    //    * Negalima paskelbti bendrinio statinio kintamojo:
    //          private static T kintamasis;
    //    * Negalima sukurti bendrinės išimčių klasės:
    //          public class ManoIšimtis<T> extends Exception {...}

    public static void main(String[] args) {

        System.out.println("-------------------- 1");
        Demo1.demo();
        System.out.println("-------------------- 2");
        Demo2.demo();
        System.out.println("-------------------- 3");
        Demo3.demo();
        System.out.println("-------------------- 4");
        Demo4.demo();
        System.out.println("-------------------- 5");
        Demo5.demo();
        System.out.println("-------------------- 6");
        Demo6.demo();
        System.out.println("-------------------- 7");
        Demo7.demo();
        System.out.println("-------------------- 8");
        Demo8.demo();
        System.out.println("-------------------- 9");
        Demo9.demo();
    }
}

class Demo1 {

    public static void demo() {

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Kazys", 1400.0, "administration"));
        list.add(new Employee("Jonas", 800.0, "store"));
        list.add(new Employee("Ona", 900.0, "sales"));
        list.add(new Employee("Petras", 1200.0, "sales"));
        list.add(new Employee("Ada", 1500.0, "administration"));

        // atspausdinti tuos kurie uzdirba daugiau nei 1000
//        filter(list, 900.0);

//        filterByFilter(list, new Check<Employee>() {
//
//            @Override
//            public boolean test(Employee e) {
//                return e.getSalary() > 1000.0 && e.getDepartment().equals("administration");
//            }
//        });
        Check<Employee> filtras = e -> (e.getSalary() > 1000.0) && e.getDepartment().equals("sales");
//        filterByFilter(list, filtras);
        Check<Employee> filtras2 = e -> e.getSalary() < 1000.0;
        filterByFilter(list, filtras2);
//        System.out.println(list);
    }

    public static void filter(List<Employee> list, double salary) {
        for (Employee e : list) {
            if (e.getSalary() > salary) {
                System.out.println(e);
            }
        }
    }

    public static void filterByFilter(List<Employee> list, Check<Employee> filter) {
        for (Employee e : list) {
            if (filter.test(e)) {
                System.out.println(e);
            }
        }
    }

    @FunctionalInterface
    interface Check<T> {

        boolean test(T e);
    }
}

class Demo2 {

    @FunctionalInterface
    interface Avg<T> {

        T avg(T n1, T n2);

    }

    public static void demo() {

//        Avg<Integer> calc = new Avg<Integer>() {
//            @Override
//            public Integer avg(Integer n1, Integer n2) {
//                return (n1 + n2) / 2;
//            }
//        };

        Avg<Integer> calc = (n1, n2) -> (n1 + n2) / 2;

        Integer result = calc.avg(200, 300);
        System.out.println("result = " + result);
    }
}

class Demo3 {

    @FunctionalInterface
    interface Converter<F, T> {

        T convert(F from);
    }

    public static void demo() {

        final int num = 10;
        Converter<Integer, String> stringConverter = from -> String.valueOf(from + num);
        String result = stringConverter.convert(2);
        System.out.println("result = " + result);

        Converter<String, Integer> integerConverter = from -> Integer.valueOf(from + "2");
        System.out.println(integerConverter.convert("2"));
    }
}

class Demo4 {

    @FunctionalInterface
    interface Converter<F, T> {

        T convert(F from);

    }

    static class A {

        int from = 1;

        void calculate() {

            Converter<Integer, String> stringConverter = from -> String.valueOf(from + ++this.from);

//            Converter<Integer, String> stringConverter = new Converter<Integer, String>() {
//
//                @Override
//                public String convert(Integer from) {
//                    return String.valueOf(from + ++A.this.from);
//                }
//            };

            String result = stringConverter.convert(2);
            System.out.println("result = " + result);
        }
    }

    public static void demo() {

        A a = new A();
        a.calculate();
        a.calculate();
        a.calculate();
    }
}

class Demo5 {

    @FunctionalInterface
    interface Calculate {

        Double calc(Double n1, Double n2);

        default Double sq(Double n) {
            return n * n;
        }

    }

    static class A {

        void calculate() {

            Calculate c = new Calculate() {
                @Override
                public Double calc(Double n1, Double n2) {
                    return Math.sqrt(this.sq(n1) + this.sq(n2));
                }
            };

//            Calculate c1 = (n1, n2) -> Math.sqrt(this.sq(n1) + this.sq(n2));  // Kodel klaida!!!!

            Double result = c.calc(3.0, 4.0);
            System.out.println("result = " + result);
        }
    }

    public static void demo() {

        new A().calculate();
    }
}

class Demo6 {

    @FunctionalInterface
    interface Calculate<N> {

        N calc(N n1, N n2);
    }

    static class A {

        void calculate() {
            // Lambda israiskos interfaco aprasymas
            // klasė::metodas
            Calculate<Double> c = Math::max;

            Double result = c.calc(2.9, 3.0);
            System.out.println("result = " + result);
        }
    }

    public static void demo() {

        new A().calculate();
    }
}

class Demo7 {

    @FunctionalInterface
    interface Calculate<T, N> {

        T create();
    }

    @FunctionalInterface
    interface Calculate2<T, N> {

        T create(N t1);
    }

    static class A {

        Double n;

        A() {
            this.n = 0.0;
        }

        A(Double n) {
            this.n = n;
        }

        Double calculate(Double d1, Double d2) {
            return n * (d1 + d2);
        }
    }

    public static void demo() {

        Calculate<A, Double> c = A::new;

        Calculate2<A, Double> c2 = (n) -> new A(n);

        A a = c.create();
        Double result = a.calculate(10., 5.);
        System.out.println("result = " + result);

        A a1 = c2.create(2.0);
        Double result1 = a1.calculate(10., 5.);
        System.out.println("result = " + result1);
    }
}

class Demo8 {

    @FunctionalInterface
    interface Calculate<N> {

        N calc(N n1, N n2);
    }

    static class A {

        double n;

        A(Double n) {

            this.n = n;
        }

        Double calculate(Double d1, Double d2) {

            return (d1 + d2) / n;
        }

        String sudetiString(String a1, String a2) {

            return a1 + a2;
        }
    }

    public static void demo() {

        A a = new A(2.0);

        Calculate<Double> c = a::calculate;

        Calculate<String> c2 = a::sudetiString;

        Double result = c.calc(10.0, 11.0);
        System.out.println("result = " + result);

        String result1 = c2.calc("a ", "b");
        System.out.println("result = " + result1);
    }
}

class Demo9 {

    @FunctionalInterface
    interface Method {

        void method();
    }

    static class A {

        public void methodA() {

            System.out.println("Class A");
        }
    }

    static class B {

        public void methodB() {
            System.out.println("Class B");
        }

    }

    public static void demo() {

        A a = new A();
        B b = new B();

        check(a::methodA);
        check(b::methodB);
    }

    static void check(Method m) {

        m.method();
    }
}

class Employee {

    private String name;

    private double salary;

    private String department;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

