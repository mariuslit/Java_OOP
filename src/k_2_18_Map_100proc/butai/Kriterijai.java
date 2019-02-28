package k_2_18_Map_100proc.butai;

public class Kriterijai {

    Integer kambariuSkaiciusMIN;
    Integer kambariuSkaiciusMAX;

    Double kvadraturaMIN;
    Double kvadraturaMAX;

    Double nuomosKainaMIN;
    Double nuomosKainaMAX;

    public Kriterijai(Integer kambariuSkaiciusMIN, Integer kambariuSkaiciusMAX, Double kvadraturaMIN, Double kvadraturaMAX, Double nuomosKainaMIN, Double nuomosKainaMAX) {
        this.kambariuSkaiciusMIN = kambariuSkaiciusMIN;
        this.kambariuSkaiciusMAX = kambariuSkaiciusMAX;
        this.kvadraturaMIN = kvadraturaMIN;
        this.kvadraturaMAX = kvadraturaMAX;
        this.nuomosKainaMIN = nuomosKainaMIN;
        this.nuomosKainaMAX = nuomosKainaMAX;
    }

    public String toString() {
        return

                kambariuSkaiciusMIN + " " +
                kambariuSkaiciusMAX + " " +
                kvadraturaMIN + "\n" +
                kvadraturaMAX + " " +
                nuomosKainaMIN + "\n" +
                nuomosKainaMAX;
    }

    public Integer getKambariuSkaiciusMIN() {
        return kambariuSkaiciusMIN;
    }

    public void setKambariuSkaiciusMIN(Integer kambariuSkaiciusMIN) {
        this.kambariuSkaiciusMIN = kambariuSkaiciusMIN;
    }

    public Integer getKambariuSkaiciusMAX() {
        return kambariuSkaiciusMAX;
    }

    public void setKambariuSkaiciusMAX(Integer kambariuSkaiciusMAX) {
        this.kambariuSkaiciusMAX = kambariuSkaiciusMAX;
    }

    public Double getKvadraturaMIN() {
        return kvadraturaMIN;
    }

    public void setKvadraturaMIN(Double kvadraturaMIN) {
        this.kvadraturaMIN = kvadraturaMIN;
    }

    public Double getKvadraturaMAX() {
        return kvadraturaMAX;
    }

    public void setKvadraturaMAX(Double kvadraturaMAX) {
        this.kvadraturaMAX = kvadraturaMAX;
    }

    public Double getNuomosKainaMIN() {
        return nuomosKainaMIN;
    }

    public void setNuomosKainaMIN(Double nuomosKainaMIN) {
        this.nuomosKainaMIN = nuomosKainaMIN;
    }

    public Double getNuomosKainaMAX() {
        return nuomosKainaMAX;
    }

    public void setNuomosKainaMAX(Double nuomosKainaMAX) {
        this.nuomosKainaMAX = nuomosKainaMAX;
    }
}
