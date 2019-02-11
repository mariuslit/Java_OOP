package a_fundamental;

class Fund_11_ClassAnonymous {
}

// Sąsaja su vienu abstrakčiu metodu vadinamas funkcine. Jai galima naudoti anotaciją @FunctionalInterface.
@FunctionalInterface
interface Skaiciuoti {

    double veiksmas(int a); // abstraktus (be realizacijos) metodas

    default double kvadratas(int a) { // metodas su realizacija
        return a * a;
    }
}

class Operacijos {

    // Java anonimnės klasės tai tokios klasės kurios yra lokalios klasės arba vdinės klasės be pavdinimo

    // Sąsajos įdiegimas anonimine klase
    Skaiciuoti ano = new Skaiciuoti() {

        @Override
        public double veiksmas(int a) {
            return a + Math.sqrt(a);
        }
    };

    // MainCars:
    public static void main(String[] args) {

        Operacijos op = new Operacijos();
        System.out.println(op.ano.veiksmas(9));
        System.out.println(op.ano.kvadratas(5));
    }
}


/**
 * Anoniminės sąsajos įdiegimas lambda išraiška
 */
class OperacijosLambdaIsraiska {

    // lambda išraiška perrašo vienintelį metodą veiksmas
    Skaiciuoti lam = (int a) -> {
        return Math.pow(a, 2);
    };

    // MainCars:
    public static void main(String[] s) {

        OperacijosLambdaIsraiska opr = new OperacijosLambdaIsraiska();
        System.out.println(opr.lam.veiksmas(9));
        System.out.println(opr.lam.kvadratas(5));
    }
}
