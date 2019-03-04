package k_2_12_collections_namuDarbas_Employee_salary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestSalayrEmployee {
/*
    +    Tarkime turime objektą Employee ir objektą Salary, kuriame yra
    +        Employee tipo laukas ir
    +        Double tipo laukas reiškiantis išmokėtą atlyginimą.
    -    Sukurkite sąrašą darbuotojų ir jų atlyginimų (gali būti keli to pačio darbuotojo įrašai)
            ir aprašykite tokius veiksmus naudojant duomenų srautus/vamzdynus:
    -    Išrinkite kiek ir kokiam darbuotojui yra išmokėta ir išveskite
            mažėjimo tvarka pagal išmokėtą sumą:
            vardas - išmokėta suma
    -    Suskaičiuokite kiek išmokėjimų (ne suma bet kiek kartų buvo išmokėta) yra
            kiekvienam darbuotojui ir atspausdinkite:
                vardas - kiek kartų išmokėta
*/


    public static void main(String[] args) throws IOException {

        List<Employee> employees = skaityti(new File("").getAbsolutePath() + "\\src\\k_2_12_collections_namuDarbas_Employee_salary\\darbuotojai.txt");

        List<Salary> salaries = new ArrayList<>();

        salaries.add(new Salary(employees.get(0),1000.01));
        salaries.add(new Salary(employees.get(5),2200.01));
        salaries.add(new Salary(employees.get(4),1200.01));
        salaries.add(new Salary(employees.get(3),1500.01));
        salaries.add(new Salary(employees.get(0),1300.01));
        salaries.add(new Salary(employees.get(2),1520.01));
        salaries.add(new Salary(employees.get(1),1750.01));
        salaries.add(new Salary(employees.get(1),2000.01));
        salaries.add(new Salary(employees.get(4),2500.01));
        salaries.add(new Salary(employees.get(5),3000.01));

        // todo pabaigti su rūšiavimais, naudoti Colection sort ir lambda
//        Collections.sort(salaries, Employee::compareTo);
//        Collections.sort(zodynas, Zmogus::compareTo);

        for (Salary s : salaries) {

            System.out.println(s.toString());
        }

    }

    public static List<Employee> skaityti(String failas) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {


            String line = br.readLine();

            List<Employee> employees = new ArrayList<>();

            while (line != null) {

                String[] arr = line.split(" ");

                Employee sf = new Employee(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3]);

                employees.add(sf);
                line = br.readLine();
            }
            return employees;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }
}
