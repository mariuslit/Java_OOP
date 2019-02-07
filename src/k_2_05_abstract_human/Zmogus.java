package k_2_05_abstract_human;

public abstract class Zmogus {

    private String vardas;
    private String pavardas;
    private Integer amzius;

    public Zmogus(String vardas, String pavardas, Integer amzius) {
        this.vardas = vardas;
        this.pavardas = pavardas;
        this.amzius = amzius;
    }

    public abstract String toString();

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavardas() {
        return pavardas;
    }

    public void setPavardas(String pavardas) {
        this.pavardas = pavardas;
    }

    public Integer getAmzius() {
        return amzius;
    }

    public void setAmzius(Integer amzius) {
        this.amzius = amzius;
    }
}
