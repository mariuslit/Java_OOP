package k_1_29_try_catch.namuDarbai;

public class Darbuotojas {
    private String vards;
    private String pavarde;
    private Integer amzius;
    private String pareigos;

    public Darbuotojas(String vards, String pavarde, Integer amzius, String pareigos) {
        this.vards = vards;
        this.pavarde = pavarde;
        this.amzius = amzius;
        this.pareigos = pareigos;
    }

    public String getVards() {
        return vards;
    }

    public void setVards(String vards) {
        this.vards = vards;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public Integer getAmzius() {
        return amzius;
    }

    public void setAmzius(Integer amzius) {
        this.amzius = amzius;
    }

    public String getPareigos() {
        return pareigos;
    }

    public void setPareigos(String pareigos) {
        this.pareigos = pareigos;
    }
}
