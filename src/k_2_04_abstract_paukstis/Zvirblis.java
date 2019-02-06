package k_2_04_abstract_paukstis;

public class Zvirblis extends Paukstis{

    public Zvirblis() {
        super();
    }

    @Override
    public String gautiPavadinimą() {
        return "zvirblis";
    }

    @Override
    public Integer gautiGyvenimoAmziu() {

        return 3;
    }

    @Override
    public Double gautiSvorį() {

        return 0.5;
    }

}
