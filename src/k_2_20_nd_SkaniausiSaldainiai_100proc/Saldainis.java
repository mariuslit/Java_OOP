package k_2_20_nd_SkaniausiSaldainiai_100proc;

public class Saldainis {

    private String gamintojas;
    private String pavadinimas;
    private Integer skanumas;

    public Saldainis(String gamintojas, String pavadinimas, Integer skanumas) {
        this.gamintojas = gamintojas;
        this.pavadinimas = pavadinimas;
        this.skanumas = skanumas;
    }

    public String toString() {

        return String.format("%-22s ", pavadinimas) + " " + skanumas;
    }

    public String getGamintojas() {
        return gamintojas;
    }

    public void setGamintojas(String gamintojas) {
        this.gamintojas = gamintojas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public Integer getSkanumas() {
        return skanumas;
    }

    public void setSkanumas(Integer skanumas) {
        this.skanumas = skanumas;
    }
}
