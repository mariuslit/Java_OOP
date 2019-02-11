package a_fundamental;

public class Fund_16_abstract_vs_interface {

    /** kuo skiriasi ir kas bendro tarp abstract ir interface?
     ** kada naudoti abstract, o kada interface?
     *
     *   1   paveldinti / įgyvendinanti klasė - AAA
     *   2   abstrakti klasė      (paveldima) - AAAabstract
     *   3   interfeisas      (įgyvendinamas) - AAAinterface, BBBinterface
     *------------------------------------------------------------------------------------------------------------------
     *         [ ABSTRACT CLASS ]                              [ INTERFACE ]
     *
     *>> SUKŪRIMAS
     *         public abstract class AAAabstract {}             public interface AAAinterface {}
     *
     *>> NAUDOJIMAS
     *         public class AAA extends AAAabstract {}          public class AAA implements AAAinterface, BBBinterface {}
     *
     *>> KAS BENDRO
     *         turi abstract metodus                            turi abstract metodus (pagal nutylėjimą laikomi abstract)
     *
     *>> PAGRINDINIAI SKIRTUMAI
     *         paveldėti galima tik vieną abstract klasę        įgyvendinti glima kelis interfeisus
     *         gali turėti įvairių kintamųjų:                   gali turėti tik static ir final kintamuosius
     *         (Static, non-static, final, non-final)
     *
     *
     * kas extendina abtrakčią klasė privalo aprašyti visų interfeisų (kuriuos įgyvenda abstrakti klasė) metodus
     *------------------------------------------
     * pagrindinis panaudojimas:
     *    abstract klasė nudojama, kad sumažinti kodo kiekį
     *    interfeisas reikalingas kaip metodų biblioteka, pvz matematinių formulių metode
     *
     */
}
