package k_2_05_interface_mokejimai;

public class Client implements Payment {

    // +  Modifikuokite klasę Klientas (Client), kad joje galima būtų kaupti atliktų mokėjimų sumas (naudokite masyvą).

    private String saskaita;
    private String vardas;
    private Double suma;
    private Double[] mokejimai;

    public Client(String saskaita, String vardas, Double suma, Double[] mokejimai) {
        this.saskaita = saskaita;
        this.vardas = vardas;
        this.suma = suma;
        this.mokejimai = mokejimai;
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

    public Double[] getMokejimai() {
        return mokejimai;
    }

    public void setMokejimai(Double[] mokejimai) {
        this.mokejimai = mokejimai;
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
