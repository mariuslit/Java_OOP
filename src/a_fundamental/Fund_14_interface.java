package a_fundamental;

public interface Fund_14_interface {

    static void main(String[] args) {

        AA aa = new AA();
        aa.metodas_1();
        System.out.println(aa.metodas_2());
        System.out.println(aa.metodas_3());
        aa.metodas_4(); // iškviečiamas default metodas
        aa.metodas_6(); // iškviečiamas perrašytas default metodas
        System.out.println(AAAinterface.metodas_5());
    }
}

interface AAAinterface {

    // visi trys metodai pagal nutylėjimą yra public abstract, todėl public abstract rašyti nereikia
    /*public abstract*/ void metodas_1();

    /*public abstract*/ String metodas_2();

    /*public abstract*/ Integer metodas_3();

    // default - įgyvendinti neprivaloma, bet galima perrašyti (overiding)
    default void metodas_4() {
        System.out.println("tai metodas_4 sąsajos Fund_14_Interface metodas, " +
                "default - reiškia įgyvendinti neprivaloma, default galima naudoti, kaip metodų biblioteką");
    }

    // static - naudojamas tik interfeiso viduje
    static String metodas_5() {
        return "tai metodas_5 sąsajos Fund_14_Interface metodas, " +
                "static - reiškia gali būti pasiekiamas ir naudojamas tik pačio interfeiso viduje";
    }

    // aprastas metodas, skirtas perrašymui (overiding) pavyzdyje
    default void metodas_6() {
        metodas_4();
        System.out.println("tai default metodas_6 sąsajos Fund_14_Interface metodas, šis metodas bus perrašytas (overiding)");
    }
}

/**
 * klasė įgyvendina vieną intefeisą (bet gali įgyvendinti kelis surašytus po "implements" ir atskirtus klableliais)
 */
class AA implements AAAinterface {

    // Privalomas metodo "metodas_1" įgyendinimas
    public void metodas_1() {
        System.out.println("Įgyvendintas sąsajoje AAAinterface metodas_1");
    }

    // Privalomas metodo "metodas_2" įgyendinimas
    public String metodas_2() {
        return "Įgyvendintas sąsajoje AAAinterface  metodas_2, String tipo metodas grąžina šį tekstą";
    }

    // Privalomas metodo "metodas_3" įgyendinimas
    public Integer metodas_3() {
        System.out.print("Įgyvendintas sąsajoje AAAinterface  metodas_3, Integer tipo metodas grąžina skaitinę reikšmę: ");
        return 3;
    }

    @Override
    public void metodas_6() {
        System.out.println("tai metodas_6 sąsajos Fund_14_Interface metodas, šis metodas yra perrašytas: anotacija @Override");
    }
}
