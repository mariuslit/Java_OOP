package k_1_31_inheritance_figuros;

/**
 *  tėvinė klasė
 */
public class Figuros {

    public String toString() {

        return "panaudota tėvinė klasė";
    }

    public Double perimetras(Double x, Double y) {

        return x * 2 + y * 2;
    }

    public Double plotas(Double x, Double y) {

        return x * y;
    }
}
