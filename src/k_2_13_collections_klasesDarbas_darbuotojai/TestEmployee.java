package k_2_13_collections_klasesDarbas_darbuotojai;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class TestEmployee {
/*
        +   Sukurti klasę Employee su
        +      vardas,
        +      pavarde,
        +      departamentas,
        +      alga.
        +   Nuskaityti duomenų failą(moodle įkeltas) ir įdėti objektus į List‘ą;
            TODO: 2019-02-14 Stream
        +                    Išrikiuoti pagal vardą,
        +                       jei vardai vienodi pagal pavardę, ...
        +                       Departamentą, ...
        +                       Algą.
        +   Rasti daugiausiai uždirbantį darbuotoją;
        +   Nufiltruoti į kitą List‘ą uždirbančius daugiau nei 1000;
        +   Rasti visus skirtingus departamentų tipus ir
               suskaičiuoti kiek jų yra(duomenų saugojimui naudoti Map kolekciją); // čia geriau tinka Set
        +   Surasti vienodus objektus;
        +   Atspausdinti atsakymų į failą nereikia;
        -   Visiems veiksmams atlikti galima naudoti Stream() biblioteką tik tada
               jei viską atlikote objektiniu(paprastuoju) būdu,
               tai yra susikuriant po metodą kiekvienam veiksmui atlikti.
*/

    public static void main(String[] args) throws IOException {

        List<Employee> employees = skaityti(new File("").getAbsolutePath() + "\\src\\k_2_13_collections_klasesDarbas_darbuotojai\\darbuotojai.txt");
        spausdinti(employees, "Pradinis sąrašas");

        Collections.sort(employees);
        spausdinti(employees, "Surūšiuota pagal Vardą, Pavardę, Departamentą, Algą");

        // todo perdaryti su Stream
        employees.stream().sorted();
//        spausdinti(sorted, "STREAM -> Surūšiuota pagal Vardą, Pavardę, Departamentą, Algą");

//        if (true) return;

        spausdintiDaugiausiaiUzdirbanciusDarbuotojus(employees);

        Double atlyginimasPalyginimui = 1000d;
        List<Employee> uzdirbantysDaugiauNei = gautiUzdirbanciusDaugiauNei(employees, atlyginimasPalyginimui);
        NumberFormat d = new DecimalFormat("#0.00");
        spausdinti(uzdirbantysDaugiauNei, "Darbuotojai uždirbantys daugiau nei " +
                d.format(atlyginimasPalyginimui) + " € (viso yra " + uzdirbantysDaugiauNei.size() + " darbuotojai)");


        Map<String, String> departamentai = rastiVisusUnikaliusDepartamentus(employees);
        System.out.println("\n****************\nDepartamentai: " + departamentai.size() + "\n");
        departamentai.keySet().forEach(System.out::println);

        Map<Employee, Integer> obj = vienodiEmployee(employees);
        spausdinti(new ArrayList<>(obj.keySet()), "Vienodi objektai: " + obj.size());

    }


    // Surasti vienodus objektus;
    public static Map<Employee, Integer> vienodiEmployee(List<Employee> employees) {

        Map<Employee, Integer> vienodi = new TreeMap<>();
        Set<Employee> unique = new TreeSet<>(employees);

        System.out.println(unique.size());

        for (Employee uniklus : unique) {

            int n = rastiPasikrtojanciuObjektuSkaiciu(uniklus, employees);

            if (n > 1) {

                uniklus.setVardas(n + " " + uniklus.getVardas());
                vienodi.put(uniklus, n);
            }
        }
        return vienodi;
    }

    public static int rastiPasikrtojanciuObjektuSkaiciu(Employee uniklus, List<Employee> employees) {
        int n = 0;

        for (Employee employee : employees) {

            if (uniklus.equals(employee)) { // paprastesnis, kai apsirašai equals metodą
//            if (equalsEmploe(uniklus, employee)) {
                n++;
            }
        }
        return n;
    }

    // todo Objektų palyginimas, gal yra paprastesnis būdas
    public static boolean equalsEmploe(Object a, Object b) {
        return a instanceof Employee &&
                b instanceof Employee &&
                a.toString().equals(b.toString());
//        return  a.equals(b);
    }

    // Rasti visus skirtingus departamentų tipus ir suskaičiuoti kiek jų yra(duomenų saugojimui naudoti Map kolekciją);
    public static Map<String, String> rastiVisusUnikaliusDepartamentus(List<Employee> employees) {

        Map<String, String> departamentai = new HashMap<>();

        int n = 0;
        for (Employee employee : employees) {

            departamentai.put(employee.getDepartamentas(), ++n + "");
        }

//        spausdinti(departamentai.toArray(), "viso yra  " + departamentai.size() + " deprtamentų:");
        return departamentai;
    }

    // Nufiltruoti į kitą List‘ą uždirbančius daugiau nei 1000;
    public static List<Employee> gautiUzdirbanciusDaugiauNei(List<Employee> employees, Double n) {

        List<Employee> perliukai = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getAlga() > n) {
                perliukai.add(employee);
            }
        }
        return perliukai;
    }

    // Rasti daugiausiai uždirbantį darbuotoją;
    public static void spausdintiDaugiausiaiUzdirbanciusDarbuotojus(List<Employee> employees) {

        List<Employee> du = new ArrayList<>();
        Double max = 0d;

        for (Employee employee : employees) {
            max = Math.max(max, employee.getAlga());
        }

        for (Employee employee : employees) {
            if (max.equals(employee.getAlga())) {
                du.add(employee);
            }
        }

        spausdinti(du, "Daugiausiai uždirbantys darbuotojai yra");
    }

    public static void spausdinti(List<Employee> saskataFakturas, String title) {

        System.out.println("---------------------------------------------------");
        System.out.println(title);
        System.out.println("{");
        for (Employee s : saskataFakturas) {

            System.out.println("    " + s.toString());
        }
        System.out.println("}");
    }

    public static List<Employee> skaityti(String failas) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {


            String line = br.readLine();

            List<Employee> fakturos = new ArrayList<>();

            while (line != null) {

                String[] arr = line.split(" ");

                Employee sf = new Employee(arr[0], arr[1], arr[2], Double.parseDouble(arr[3]));

                fakturos.add(sf);
                line = br.readLine();
            }
            return fakturos;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }

}
