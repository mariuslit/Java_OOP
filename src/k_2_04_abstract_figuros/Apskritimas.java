package k_2_04_abstract_figuros;

public class Apskritimas extends Figuros {

    private Double spindulys;

    Apskritimas(Double spindulys) {
        this.spindulys = spindulys;
    }

    public Double plotas() {
        return Math.PI * spindulys * spindulys;
    }

    public Double perimetras() {
        return 2 * Math.PI * spindulys;
    }


}
