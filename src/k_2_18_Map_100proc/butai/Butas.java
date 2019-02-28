package k_2_18_Map_100proc.butai;

public class Butas {

    Integer numeris;
    String adresas;
    Integer kambariuSkaicius;
    Double kvadratura;
    Double nuomosKaina;

    public Butas(Integer numeris, String adresas, Integer kambariuSkaicius, Double kvadratura, Double nuomosKaina) {
        this.numeris = numeris;
        this.adresas = adresas;
        this.kambariuSkaicius = kambariuSkaicius;
        this.kvadratura = kvadratura;
        this.nuomosKaina = nuomosKaina;
    }

    public String toString() {
        return "\n" +
                String.format("%-2.15s ", numeris) + " " +
                String.format("%-18.20s ", adresas) + " " +
                String.format("%-1.15s ", kambariuSkaicius) + " " +
                String.format("%-4.15s ", kvadratura) + " " +
                String.format("%-5.15s", nuomosKaina);
    }

    public Integer getNumeris() {
        return numeris;
    }

    public void setNumeris(Integer numeris) {
        this.numeris = numeris;
    }

    public String getAdresas() {
        return adresas;
    }

    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }

    public Integer getKambariuSkaicius() {
        return kambariuSkaicius;
    }

    public void setKambariuSkaicius(Integer kambariuSkaicius) {
        this.kambariuSkaicius = kambariuSkaicius;
    }

    public Double getKvadratura() {
        return kvadratura;
    }

    public void setKvadratura(Double kvadratura) {
        this.kvadratura = kvadratura;
    }

    public Double getNuomosKaina() {
        return nuomosKaina;
    }

    public void setNuomosKaina(Double nuomosKaina) {
        this.nuomosKaina = nuomosKaina;
    }
}
