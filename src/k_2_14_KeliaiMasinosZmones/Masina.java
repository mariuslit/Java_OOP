package k_2_14_KeliaiMasinosZmones;

public class Masina {

    String gamintojas;
    String numeriai;

    public Masina(String gamintojas, String numeriai) {
        this.gamintojas = gamintojas;
        this.numeriai = numeriai;
    }

    @Override
    public String toString() {

        return gamintojas + " -- " + numeriai;
    }

    @Override
    public boolean equals(Object obj) {
        Masina masina = (Masina) obj;
        return gamintojas.equals(masina.gamintojas) && numeriai.equals(masina.numeriai);
    }

    public String getGamintojas() {
        return gamintojas;
    }

    public void setGamintojas(String gamintojas) {
        this.gamintojas = gamintojas;
    }

    public String getNumeriai() {
        return numeriai;
    }

    public void setNumeriai(String numeriai) {
        this.numeriai = numeriai;
    }
}
