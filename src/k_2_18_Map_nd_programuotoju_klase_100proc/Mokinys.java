package k_2_18_Map_nd_programuotoju_klase_100proc;

public class Mokinys {

    String vardas;
    String pavarde;
    Integer prioritetas;

    public Mokinys(String vardasPavarde, Integer prioritetas) {
        this.vardas = vardasPavarde.split("_")[0];
        this.pavarde = vardasPavarde.split("_")[1];
        this.prioritetas = prioritetas;
    }

    @Override

    public String toString() {

        return vardas + "_" + pavarde + " " + prioritetas;
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

    public Integer getPrioritetas() {
        return prioritetas;
    }

    public void setPrioritetas(Integer prioritetas) {
        this.prioritetas = prioritetas;
    }
}
