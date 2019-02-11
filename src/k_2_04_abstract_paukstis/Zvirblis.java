package k_2_04_abstract_paukstis;

public class Zvirblis extends Paukstis{

    public Zvirblis() {
        super();
    }

    @Override
    public String gautiPavadinima() {
        return "zvirblis";
    }

    @Override
    public Integer gautiGyvenimoAmziu() {

        return 3;
    }

    @Override
    public Double gautiSvori() {

        return 0.5;
    }

}
