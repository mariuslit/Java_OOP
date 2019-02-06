package k_2_05_abstract_figure_second;

public class Apskritimas extends Figuros {

    private Double spindulys;

    public Double getSpindulys() {
        return spindulys;
    }

    public void setSpindulys(Double spindulys) {
        this.spindulys = spindulys;
    }

    Apskritimas(Double spindulys) {
        this.spindulys = spindulys;
    }

    public Double plotas() {
        return Math.PI * spindulys * spindulys;
    }

    public Double perimetras() {
        return 2 * Math.PI * spindulys;
    }

    public Double perimetrasIsPloto(Double plotas) {

        // gauname ir priskiriame naują spindulį iš ploto s = pi * r2 -> r = sqr(s/pi)
        this.spindulys = Math.sqrt(plotas / Math.PI);

        return perimetras();
    }

    public Double plotasIsPerimetro(Double perimetras) {

        // gauname ir priskiriame naują spindulį iš perimetro p = 2 * pi * r -> r = p/2/pi)
        this.spindulys = perimetras/2/ Math.PI;

        return plotas();
    }
}
