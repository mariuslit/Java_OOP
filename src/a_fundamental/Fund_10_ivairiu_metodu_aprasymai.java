package a_fundamental;

public class Fund_10_ivairiu_metodu_aprasymai {

    public static void main(String[] args) {

        pvz_compareTo();
    }


    static void pvz_compareTo(){

        // compareTo
        // x.compareTo(y) metodas palygina du skaičius ir grąžina:
        //  0 - jeigu jie lygūs
        // -1 - jeigu x < y
        //  1 - jeigu x > y
        Integer x = 5;
        System.out.println(x.compareTo(3)); // 1
        System.out.println(x.compareTo(5)); // 0
        System.out.println(x.compareTo(8)); // -1
    }
}
