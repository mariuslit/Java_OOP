package k_2_13_collections_namuDarbas_saskaios;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Saskata {

    private LocalDate data;
    private String klientoVardas;
    private BigDecimal suma;

    public Saskata(LocalDate data, String klientoVardas, BigDecimal suma) {
        this.data = data;
        this.klientoVardas = klientoVardas;
        this.suma = suma;
    }

    @Override
    public String toString() {

        return data + " " + klientoVardas + " " + suma;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getKlientoVardas() {
        return klientoVardas;
    }

    public void setKlientoVardas(String klientoVardas) {
        this.klientoVardas = klientoVardas;
    }

    public BigDecimal getSuma() {
        return suma;
    }

    public void setSuma(BigDecimal suma) {
        this.suma = suma;
    }
}
