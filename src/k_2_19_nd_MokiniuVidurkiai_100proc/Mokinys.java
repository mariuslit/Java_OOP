package k_2_19_nd_MokiniuVidurkiai_100proc;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class Mokinys {

    private String vardas;
    private String pavarde;
    private String klase;
    private List<Double> vidurkiai;
    private Double vidurkiuSuma; // tik get
    private Double bendrasVidurkis; // tik get

    // sort by class
    // get didžiausias vidurkis, jei keli - imti pirmąjį iš saršo
    // get mžiausias vidurkis jei keli - imti pirmąjį iš saršo


    public Mokinys(String vardas, String pavarde, String klase, List<Double> vidurkiai, Double vidurkiuSuma) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.klase = klase;
        this.vidurkiai = vidurkiai;
        this.vidurkiuSuma = vidurkiuSuma;
        this.bendrasVidurkis = 0d;
    }

    @Override
    public String toString() {

        NumberFormat decimalFormat = new DecimalFormat("#0.0 ");
        String vid = decimalFormat.format((getBendrasVidurkis()));

        decimalFormat = new DecimalFormat("#0");
        String vid2 = decimalFormat.format((getBendrasVidurkis()));

        return String.format("%-20s", vardas + " " + pavarde) + vid + vid2;
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

    public List<Double> getVidurkiai() {
        return vidurkiai;
    }

    public void setVidurkiai(List<Double> vidurkiai) {
        this.vidurkiai = vidurkiai;
    }

    public Double getBendrasVidurkis() {

        return vidurkiuSuma / getVidurkiai().size();
    }

    public void setBendrasVidurkis(Double bendrasVidurkis) {
        this.bendrasVidurkis = bendrasVidurkis;
    }

    public Double getVidurkiuSuma() {
        return vidurkiuSuma;
    }

    public void setVidurkiuSuma(Double vidurkiuSuma) {
        this.vidurkiuSuma = vidurkiuSuma;
    }

    public void addVidurki(Double vidurkis) {
        this.vidurkiuSuma += vidurkis;
        getVidurkiai().add(vidurkis);
    }


}
