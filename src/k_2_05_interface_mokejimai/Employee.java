package k_2_05_interface_mokejimai;

public class Employee implements Payment{

    String saskaita;
    String vardas;
    Double suma;

    public Employee(String saskaita, String vardas, Double suma) {
        this.saskaita = saskaita;
        this.vardas = vardas;
        this.suma = suma;
    }

    public String getSaskaita() {
        return saskaita;
    }

    public void setSaskaita(String saskaita) {
        this.saskaita = saskaita;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public Double getSuma() {
        return suma;
    }

    public void setSuma(Double suma) {
        this.suma = suma;
    }


    @Override
    public String bankAccount() {
        return getSaskaita();
    }

    @Override
    public String accountOwner() {
        return getVardas();
    }

    @Override
    public Double amount() {
        return getSuma();
    }
}
