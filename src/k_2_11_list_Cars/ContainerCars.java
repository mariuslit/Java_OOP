package k_2_11_list_Cars;

import k_2_08_uzduotisSavaitgaliui_Cars.Car;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContainerCars<E> {

    public List<E> cars;

    public static void main(String[] args) {

        ContainerCars cc = new ContainerCars();
        cc.cars = new ArrayList<>();

        try {

            cc.cars = skaityti("C:\\Coding\\Java_OOP\\src\\k_2_11_list_Cars\\cars.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }

        cc.cars.add(new Car("Mitsubishi", "xxx", 2019, 40000, 2.5, "B"));
        cc.cars.add(new Car("Opel", "fff", 2019, 50000, 1.9, "D"));
        cc.cars.add(new Car("Toyota", "ddd", 2019, 80000, 2.0, "B"));
        cc.cars.add(new Car("Ford", "nnn", 2019, 20000, 1.5, "B"));

        for (int i = 0; i < cc.cars.size(); i++) {

            System.out.println(cc.cars.get(i));
            StringBuilder s;
        }
    }

    public static List<Car> skaityti(String failas) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            String line = br.readLine();

            List<Car> cars = new ArrayList<>();

            int lines = Integer.parseInt(line);

            for (int i = 0; i < lines; i++) {
                line = br.readLine();

                String[] arr = line.split(" ");
                Car car = new Car(arr[0],
                        arr[1],
                        Integer.parseInt(arr[2]),
                        Integer.parseInt(arr[3]),
                        Double.parseDouble(arr[4]),
                        arr[5]);
                cars.add(car);
            }

            return cars;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }
}
