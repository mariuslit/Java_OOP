package k_2_11_generic_list_lambda_interface_namuDarbai;

import k_2_08_uzduotisSavaitgaliui_Cars.Car;

import java.io.*;
import java.util.*;

public class TestEmployee {


    public static void main(String[] args) throws IOException {

        List<Employee> employees, employees2;
        employees =
                skaityti(new File("").getAbsolutePath() + "\\src\\k_2_11_generic_list_lambda_interface_namuDarbai\\dataEmployee.txt");

        employees2 =
                skaityti(new File("").getAbsolutePath() + "\\src\\k_2_11_generic_list_lambda_interface_namuDarbai\\dataEmployee2.txt");

        Objects.requireNonNull(employees).addAll(employees2);

        // TODO: 2019-02-12 išsistudijuoti viską iki galo
        // būtina įgyvendinti ...implements Comparable<Employee> ir būtinai Overide comparTo
//        Collections.sort(employees);

        // naudoti kai nenori įgyveninti Comparable
        Collections.sort(employees, (o1, o2) -> o1.getVardas().compareTo(o2.getVardas()));


        // todo surūšiuoti pagal vardą ir atspausdinti

        for (Employee e : employees) {

            System.out.println(e.toString() + " --- hash code " + e.hashCode());
        }

        // todo surūšiuoti pagal gaunamą atlyginimą ir atspausdinti
    }


    public static List<Employee> skaityti(String failas) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            String line = br.readLine();

            List<Employee> cars = new ArrayList<>();

//            int lines = Integer.parseInt(line);

            while (line != null) {
                String[] arr = line.split(" ");
                Employee employee = new Employee(arr[0], Double.parseDouble(arr[1]));
                cars.add(employee);
                line = br.readLine();
            }

            return cars;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }
}
