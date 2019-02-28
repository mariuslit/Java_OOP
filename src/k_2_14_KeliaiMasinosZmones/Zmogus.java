package k_2_14_KeliaiMasinosZmones;

public class Zmogus {

    private String vardas;
    private String pavarde;

    public Zmogus(String vardas, String pavarde) {
        this.vardas = vardas;
        this.pavarde = pavarde;
    }

    @Override
    public boolean equals(Object obj) {
        Zmogus zmogus = (Zmogus) obj;
        return vardas.equals(zmogus.vardas) && pavarde.equals(zmogus.pavarde);
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
}
