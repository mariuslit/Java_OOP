package k_2_11_list;

public class Containe<T> {

    private int size;
    private T[] element;

    public Containe(int size, T[] element) {
        element = (T[]) new Object[10];
        size = 0;
    }

    public void add() {

        ++size;
    }

//    nebaigta
//    public T get(int indx) {
//
//        if (indx >= size) {
//            throw new IndexOutOfBoundsException("Index: " + indx);
//
//        }
//        return ;
//    }

}
