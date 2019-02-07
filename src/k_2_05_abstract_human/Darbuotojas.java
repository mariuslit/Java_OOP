package k_2_05_abstract_human;

public class Darbuotojas extends Zmogus {

    //  Darbuotojo klasėje saugoma kiek metų dirba toje srityje, specialybė.

    private String pareigos;
    private Integer stazas;

    public Darbuotojas(String vardas, String pavardas, Integer amzius, String studijuKryptis, Integer kursas) {
        super(vardas, pavardas, amzius);
        this.pareigos = studijuKryptis;
        this.stazas = kursas;
    }

    @Override
    public String toString() {

        System.out.println("vardas: " + getVardas());
        System.out.println("pavardė: " + getPavardas());
        System.out.println("amžius: " + getAmzius());
        System.out.println("pareigos: " + getPareigos());
        System.out.println("dirba šioje srityje (metų): " + getStazas());
        return "-----------------------------------------------\n";
    }

    public String getPareigos() {
        return pareigos;
    }

    public void setPareigos(String pareigos) {
        this.pareigos = pareigos;
    }

    public Integer getStazas() {
        return stazas;
    }

    public void setStazas(Integer stazas) {
        this.stazas = stazas;
    }
}
