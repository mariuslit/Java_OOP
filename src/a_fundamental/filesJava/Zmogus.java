package a_fundamental.filesJava;

public class Zmogus {

    private String vardas;
    private String pavarde;
    private String asmensKodas;

    public Zmogus(String vardas, String pavarde, String asmensKodas) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.asmensKodas = asmensKodas;
    }

    public String toString() {
        return vardas + " " + pavarde + " " + asmensKodas;
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

    public String getAsmensKodas() {
        return asmensKodas;
    }

    public void setAsmensKodas(String asmensKodas) {
        this.asmensKodas = asmensKodas;
    }
}
