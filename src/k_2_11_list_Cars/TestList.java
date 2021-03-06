package k_2_11_list_Cars;

import k_2_08_uzduotisSavaitgaliui_Cars.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestList {

    public static void main(String[] args) {

        Car[] cars2 = new Car[]{
                new Car("VW", "Galant", 2019, 50000, 2.5, "B"),
                new Car("Mitsubishi", "Galant", 2019, 50000, 2.5, "B"),
                new Car("Mitsubishi", "Galant", 2019, 50000, 2.5, "B"),
                new Car("Mitsubishi", "Galant", 2019, 50000, 2.5, "B"),
                new Car("Opel", "Galant", 2019, 50000, 2.5, "B")
        };
//        System.out.println(cars2[4].toString());
//        System.out.println();

        List<Car> cars = new ArrayList<>();
        try {

            cars = skaityti(new File("").getAbsolutePath() + "\\src\\k_2_11_list_Cars\\cars.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }

        cars.add(new Car("Mitsubishi", "Galant", 2019, 50000, 2.5, "B"));
        cars.add(new Car("Opel", "Galant", 2019, 50000, 2.5, "B"));
        cars.add(new Car("Toyota", "Galant", 2019, 50000, 2.5, "B"));
        cars.add(new Car("Ford", "Galant", 2019, 50000, 2.5, "B"));

        for (int i = 0; i < cars.size(); i++) {

            System.out.println(cars.get(i).getGamintojas());
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
