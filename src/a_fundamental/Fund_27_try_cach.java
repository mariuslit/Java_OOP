package a_fundamental;

public class Fund_27_try_cach {

    public static void main(String[] args) {

        int a = 1;
        int b = 0;
        int c = 1;

        // try ir cach blokai privalomi, finaly neprivalomas
        try {

            c = a / b;

            if (c > 0) {

                // sąmoningas klaidos sukūrimas
                throw new ArithmeticException("aritmetinė klaida");
            }
            System.out.println(c);

        } catch (ArithmeticException e) {

            System.out.println(e);
        } finally {
            System.out.println("Vis tiek atspausdinu, c=" + c);
        }

    }
}
