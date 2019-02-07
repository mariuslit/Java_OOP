package k_1_31_inheritance_figuros_2interface;

public class Kvadratas extends Figuros implements InterfeisasFiguroms, InterfeisasMetoduLobynas {

    private Double krastine;

    public void spausdinkFigurosVarda(Object obj) {
        System.out.println(obj.getClass().getSimpleName());
    }

    public Double perimetras() {
        return 0d;
    }

    public Double plotas() {
        return 0d;
    }

    public Kvadratas(Double krastine) {
        this.krastine = krastine;
    }

    public Double getKrastine() {
        return krastine;
    }

    public void setKrastine(Double krastine) {
        this.krastine = krastine;
    }
}
