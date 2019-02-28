package k_2_14_testai_juniTest;

public class Zmogus {
    private final String vardas;
    private final String pavarde;
    private final Integer amzius;

    public Zmogus(String vardas, String pavarde, Integer amzius) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.amzius = amzius;
    }

    public String getVardasPavarde() {
        return vardas + " " + pavarde;
    }

    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public Integer getAmzius() {
        return amzius;
    }
}
