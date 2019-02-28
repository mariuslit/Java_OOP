package a_fundamental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fund_20_Collections_sort_compareTo {

    public static void main(String[] args) {
/*
  +   Sukurkite kolekciją List saugoti žmonių klasės objektus
  +   Įdėkite keletą žmonių į kolekciją ir atspausdinkite žmones tokia rūšiavimo tvarka.
          departamentas a-z (ascending)
          vardas        z-a (descending)
          asmens kodo   a-z (ascending)
          salary        z-a (descending)
  +   Pabandykite įdėti į kolekciją du skirtingus žmones bet su tuo pačiu asmens kodu. Patikrinkite kas atsitiks?
*/

        List<Zmogus> zmones = new ArrayList<>();

        zmones.add(new Zmogus(
                "Marius",
                "Litvinas    ",
                "111",
                "pardavimai",
                9.00));
        zmones.add(new Zmogus("Darius", "Andraitis   ", "333", "gamyba    ", 9.05));
        zmones.add(new Zmogus("Rytis", "Briedaitis   ", "777", "pardavimai", 9.00));
        zmones.add(new Zmogus("Andrius", "Petraitis  ", "222", "tyrimai   ", 10.01));
        zmones.add(new Zmogus("Jonas", "Jonaitis     ", "666", "tyrimai   ", 20.00));
        zmones.add(new Zmogus("Giedrius", "Matusa    ", "444", "tyrimai   ", 25.00));
        zmones.add(new Zmogus("Saulius", "Briedauskas", "999", "gamyba    ", 15.00));
        zmones.add(new Zmogus("Saulius", "Briedauskas", "555", "pardavimai", 15.00));
        zmones.add(new Zmogus("Saulius", "Briedauskas", "888", "pardavimai", 5.00));
        zmones.add(new Zmogus("Saulius", "Briedauskas", "777", "pardavimai", 16.00));
        zmones.add(new Zmogus("Saulius", "Briedauskas", "888", "pardavimai", 1.00));
        zmones.add(new Zmogus("Saulius", "Briedauskas", "888", "pardavimai", 15.00));

        String ss = "----------------------------------";
        System.out.println(ss);
        System.out.println("pirminis sąrašas:\n");
        for (Zmogus zm : zmones) {

            System.out.println(zm.toString());
        }
        System.out.println(ss);


        // Collection išsaugo rikšmę

        // rūšiavimas įgivendinant Comparable interfeisą pagal visus compareTo aprašytus kriterijus
        Collections.sort(zmones, (o1, o2) -> o1.compareTo(o2));
//        Collections.sort(zmones, Zmogus::compareTo); // (sutrumpinta lambda forma)

        // rūšiavimas tik pagal vieną kriterijų
//        Collections.sort(zmones, (o1, o2) -> o1.getVardas().compareTo(o2.getVardas()));


        System.out.println("Sąrašas sort by:");
        System.out.println("    departamentas a-z (ascending)");
        System.out.println("    vardas        z-a (descending)");
        System.out.println("    asmens kodo   a-z (ascending)");
        System.out.println("    salary        z-a (descending)\n");
        for (Zmogus zm : zmones) {

            System.out.println(zm.toString());
        }
        System.out.println(ss);
    }
}

class Zmogus
        implements Comparable<Zmogus>
{

    private String vardas;
    private String pavarde;
    private String asmensKodas;
    private long id;
    private String department;
    private Double salary;

    public Zmogus(String vardas, String pavarde, String asmensKodas, String department, Double salary) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.asmensKodas = asmensKodas;
        this.id = Long.parseLong(asmensKodas);
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {

        return department + " " + vardas + " " + pavarde + " " + asmensKodas + " " + salary;
    }


    @Override
    public int compareTo(Zmogus o) {

//        Zmogus employee = (Zmogus) o;
//      sort by:
//      departamentas a-z (ascending)
//      vardas        z-a (descending)
//      asmens kodo   a-z (ascending)
//      salary        z-a (descending)

        if (this.getDepartment() != null && o.getDepartment() != null &&
                !this.getDepartment().equals(o.getDepartment())) {
            return this.getDepartment().compareTo(o.getDepartment());
        }

        if (this.getVardas() != null && o.getVardas() != null &&
                !this.getVardas().equals(o.getVardas())) {
            return o.getVardas().compareTo(this.getVardas());
        }

        if (this.getAsmensKodas() != null && o.getAsmensKodas() != null &&
                !this.getAsmensKodas().equals(o.getAsmensKodas())) {
            return this.getAsmensKodas().compareTo(o.getAsmensKodas());
        }

        // tinkamas tik skaitinėms reikšmėms
        if (this.getSalary() != null && o.getSalary() != null) {
            if (this.getSalary() < o.getSalary()) return 1;
            if (this.getSalary() > o.getSalary()) return -1;
        }

        return 0;
    }

//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Zmogus employee = (Zmogus) o;
//
//        if (id != employee.id) return false;
//        if (vardas != null ? !vardas.equals(employee.vardas) : employee.vardas != null) return false;
//        if (department != null ? !department.equals(employee.department) : employee.department != null) return false;
//        return salary != null ? salary.equals(employee.salary) : employee.salary == null;
//    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getAsmensKodas() {
        return asmensKodas;
    }

    public void setAsmensKodas(String asmensKodas) {
        this.asmensKodas = asmensKodas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}



