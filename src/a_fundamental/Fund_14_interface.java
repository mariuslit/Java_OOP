package a_fundamental;

public interface Fund_14_interface {

    // trys metodai: metodas_1/_2/_3 yra public abstract pagal nutylėjimą (default), todėl public abstract rašyti nereikia
    void metodas_1();

    String metodas_2();

    Integer metodas_3();

    // default - įgyvendinti neprivaloma, bet galima (overridding)
    default void metodas_4() {
        System.out.println("tai ketvirtasis sąsajos Fund_14_Interface metodas, default - reiškia įgyvendinti neprivaloma");
        System.out.println(metodas_5());
    }

    static String metodas_5() {
        return "tai penktasis sąsajos Fund_14_Interface metodas, static - reiškia gali būti pasiekiamas ir naudojamas tik pačio interfeiso viduje";
    }

    default void metodas_6() { // skirtas perrašymui (overridding)
        System.out.println("tai šeštasis sąsajos Fund_14_Interface metodas, šis metodas bus perrašytas (overridding)");
    }
}

/**
 * klasė įgyvendina vieną intefeisą (bet gali įgyvendinti kelis surašytus po "implements" ir atskirtus klableliais)
 */
class AA implements Fund_14_interface {

    // Privalomas metodo "metodas_1" įgyendinimas
    public void metodas_1() {
        System.out.println("Privaloma įgyvendinti sąsajoje Fund_14_Interface nurodytus metodus:");
    }

    // Privalomas metodo "metodas_2" įgyendinimas
    public String metodas_2() {
        return "metodas_1, metodas_2, metodas_3";
    }

    // Privalomas metodo "metodas_3" įgyendinimas
    public Integer metodas_3() {
        System.out.print("čia trečiasis Integer tipo metodas, grąžina skaitinę reikšmę: ");
        return 3;
    }

    @Override
    public void metodas_6() {
        System.out.println("tai šeštasis sąsajos Fund_14_Interface metodas, šis metodas yra perrašytas: anotacija @Override");
    }
}

class TestInterface{

    public static void main(String[] args) {
        AA aa = new AA();
        aa.metodas_1();
        System.out.println(aa.metodas_2());
        System.out.println(aa.metodas_3());
        aa.metodas_4(); // šis metodas
        aa.metodas_6(); // perrašytas metodas
    }
}
