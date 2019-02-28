package k_2_18_Map_100proc.studentai;

public class Studentas {

    String vardas;
    String pavarde;
    String grupe;

    public Studentas(String vardas, String pavarde, String grupe) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.grupe = grupe;
    }

    @Override
    public String toString() {

        return vardas + " " + pavarde + " " + grupe;
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

    public String getGrupe() {
        return grupe;
    }

    public void setGrupe(String grupe) {
        this.grupe = grupe;
    }
}
