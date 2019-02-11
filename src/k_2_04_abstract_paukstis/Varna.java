package k_2_04_abstract_paukstis;

public class Varna extends Paukstis {

    public Varna() {
        super();
    }

    @Override
    public String gautiPavadinima() {
        return "varna";
    }

    @Override
    public Integer gautiGyvenimoAmziu() {

        return 5;
    }

    @Override
    public Double gautiSvori() {

        return 0.7;
    }
}
