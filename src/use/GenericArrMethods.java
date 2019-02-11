package use;

import java.util.Arrays;

public interface GenericArrMethods<E> {

    default <E extends Comparable<E>> E[] addElment(E[] arr, E element) {

        E[] arr2 = Arrays.copyOf(arr, arr.length + 1);
        arr2[arr2.length - 1] = element;
        return arr2;
    }

    // surykiuoja msyvą didėjimo tvarka
    default <E extends Comparable<E>> E[] arraySortAsseding(E[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                int smallest = i;

                if (arr[j].compareTo(arr[i]) < 0) {

                    smallest = j;
                }
                arr = swap(arr, i, smallest);
            }
        }
        return arr;
    }

    default <E extends Comparable<E>> E[] swap(E[] arr, int i, int j) {

        if (i != j) {

            E temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return arr;
    }

    default <V> int numberOfValues(V[] arr, V value) {

        int n = 0;

        if (value == null) {

            for (V item : arr) {
                if (item == null) {
                    n++;
                }
            }
        } else {

            for (V item : arr) {
                if (value.equals(item)) {
                    n++;
                }
            }
        }
        return n;
    }


}
