package k_1_30_Class_Object.namuDarbai;

public class Mokinys {
    private String vardas;
    private String pavarde;
    private String klase;
    private Integer[] pazymiai;

    public Mokinys(String vardas, String pavarde, String klase, Integer[] pazymiai) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.klase = klase;
        this.pazymiai = pazymiai;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getKlase() {
        return klase;
    }

    public void setKlase(String klase) {
        this.klase = klase;
    }

    public Integer[] getPazymiai() {
        return pazymiai;
    }

    public void setPazymiai(Integer[] pazymiai) {
        this.pazymiai = pazymiai;
    }
}
