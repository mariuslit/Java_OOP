package k_1_31_inheritance_animals;

import java.util.Arrays;

public class Farm {

    public Animal[] animals = new Animal[11];

    public String toString() {

        // gauti unikalių objektų klasių masyvą
        String[] uniq = unikaliuKlasiuMasyvas(animals);

        atspausdintiGyvunus(animals, uniq);

        return "";
    }

    public String[] unikaliuKlasiuMasyvas(Animal[] arr) {

        // sukuriamas objektų klasių vardų masyvas
        String[] objNames = getStringArry(arr);

        // sukuriamas unikalių vardų masyvas
        String[] unique = new String[]{};

        // jeigu masyve yra bent vienas elementas
        if (arr != null) {

            // pirmajį narį priskiria pirmajam unique
            unique = new String[1];
            unique[0] = objNames[0];

            for (String item : objNames) {

                if (!isElementInArray(unique, item)) {

                    unique = addElment(unique, item);
                }
            }
        }

        return unique;
    }

    public String[] getStringArry(Object[] arr) {

        String[] objNames = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {

            objNames[i] = arr[i].getClass().getSimpleName();
        }

        return objNames;
    }

    // tikrina ar masyve toks elementas yra
    public boolean isElementInArray(String[] arr, String element) {

        for (String item : arr) {

            // jei randa masyve elementa - grąžina true
            if (item.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public String[] addElment(String[] arr, String element) {

        String[] arr2 = Arrays.copyOf(arr, arr.length + 1);
        arr2[arr2.length - 1] = element;
        return arr2;
    }

    public void atspausdintiGyvunus(Animal[] animals, String[] names) {

        for (String name : names) {

            String sako ="";
            int n = 0;
            for (int i = 0; i < animals.length; i++) {

                if (name.equals(animals[i].getClass().getSimpleName())) {
                    n++;
                    sako=animals[i].toString();
                }
            }
            System.out.println(n + " " + name + " sako " + sako);
        }
    }
}



