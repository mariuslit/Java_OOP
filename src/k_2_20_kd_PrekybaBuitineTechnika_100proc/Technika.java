package k_2_20_kd_PrekybaBuitineTechnika_100proc;

public class Technika {

    private String pavadinimas;
    private Integer kodas;
    private Integer kiekis;
    private Double kaina;

    public Technika(String pavadinimas, Integer kodas, Integer kiekis, Double kaina) {
        this.pavadinimas = pavadinimas;
        this.kodas = kodas;
        this.kiekis = kiekis;
        this.kaina = kaina;
    }


    public String toStringSandelisRez() {

        return String.format("%-25s %-3s %2s", pavadinimas, kodas, kiekis);
    }

    public String toStringUzsakymaiRez() {

        return String.format("%-25s %-3s %2s %4.2f", pavadinimas, kodas, kiekis, kaina);
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public Integer getKodas() {
        return kodas;
    }

    public void setKodas(Integer kodas) {
        this.kodas = kodas;
    }

    public Integer getKiekis() {
        return kiekis;
    }

    public void setKiekis(Integer kiekis) {
        this.kiekis = kiekis;
    }

    public Double getKaina() {
        return kaina;
    }

    public void setKaina(Double kaina) {
        this.kaina = kaina;
    }
}
