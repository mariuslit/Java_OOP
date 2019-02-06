package k_1_31_inheritance_figuros;

public class StaciakampisTrikampis extends Figuros {

    private Double statinisX;
    private Double statinisY;

    public StaciakampisTrikampis(Double statinisX, Double statinisY) {
        this.statinisX = statinisX;
        this.statinisY = statinisY;
    }

    // overloading
    public Double plotas() {

        return (statinisX * statinisY) / 2;
    }

    // overloading
    public Double perimetras() {

        return statinisX + statinisY + Math.sqrt(statinisX * statinisX + statinisY * statinisY);
    }

    public Double getStatinisX() {
        return statinisX;
    }

    public void setStatinisX(Double statinisX) {
        this.statinisX = statinisX;
    }

    public Double getStatinisY() {
        return statinisY;
    }

    public void setStatinisY(Double statinisY) {
        this.statinisY = statinisY;
    }
}
