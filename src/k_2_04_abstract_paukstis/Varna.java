package k_2_04_abstract_paukstis;

public class Varna extends Paukstis {

    public Varna() {
        super();
    }

    @Override
    public String gautiPavadinimą() {
        return "varna";
    }

    @Override
    public Integer gautiGyvenimoAmziu() {

        return 5;
    }

    @Override
    public Double gautiSvorį() {

        return 0.7;
    }
}
