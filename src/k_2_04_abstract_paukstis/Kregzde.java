package k_2_04_abstract_paukstis;

public class Kregzde extends Paukstis{

    public Kregzde() {
        super();
    }

    @Override
    public String gautiPavadinima() {
        return "kregzde";
    }

    @Override
    public Integer gautiGyvenimoAmziu() {

        return 9;
    }

    @Override
    public Double gautiSvori() {

        return 0.4;
    }
}
