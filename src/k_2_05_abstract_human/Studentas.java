package k_2_05_abstract_human;

public class Studentas extends Zmogus {

    //  Studentas klasėje saugomas kursas, studijų kryptis.
    //  Darbuotojo klasėje saugoma kiek metų dirba toje srityje, specialybė.

    private String studijuKryptis;
    private Integer kursas;

    @Override
    public String toString() {

        System.out.println("vardas: " + getVardas());
        System.out.println("pavardė: " + getPavardas());
        System.out.println("amžius: " + getAmzius());
        System.out.println("studijų kryptis: " + getStudijuKryptis());
        System.out.println("kursas: " + getKursas());
        return "-----------------------------------------------\n";
    }

    public String getStudijuKryptis() {
        return studijuKryptis;
    }

    public void setStudijuKryptis(String studijuKryptis) {
        this.studijuKryptis = studijuKryptis;
    }

    public Integer getKursas() {
        return kursas;
    }

    public void setKursas(Integer kursas) {
        this.kursas = kursas;
    }
}
