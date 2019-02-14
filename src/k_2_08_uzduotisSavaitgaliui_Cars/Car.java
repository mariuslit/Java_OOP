package k_2_08_uzduotisSavaitgaliui_Cars;

/*
  +    Susikurti klasę Car su laukais gamintojas, modelis, metai, kaina, variklioTuris, kuroTipas;
  +    Nuskaityti duomenų failą duotą Moodle ir susidėti visus duomenis į Car[];
  +    Atspausdinti į failą nuskaitytus duomenis, naudojant iš klasės toString() funkiją;
  +    Šiuos metodus/funkcijas apsirašyti main klasėje:
  +        Rasti seniausią mašiną ir ją atspausdinti;
  +        Rasti naujausią mašiną ir ją atspausdinti;
  +        Rasti visas mašinas naujesnes nei 2010 metai ir jas atspausdinti;
  +        Rasti visas mašinas, kurios yra pagamintos tarp 2000 ir 2010 metų ir jas atspausdinti;
  +        Rasti visas VW markės mašinas ir jas atspausdinti;
  +        Rasti didžiausią variklio tūrį turinčią mašiną ir ją atspausdinti;
  +        Rasti benzininį variklį turinčių mašinų kiekį;

       Mano sugalvota užduotis
  +        Atspausdinti visas mašinas didėjančia tvarka pagal pagaminimo metus
*/
public class Car {

    private String gamintojas;
    private String modelis;
    private Integer metai;
    private Integer kaina;
    private Double variklioTuris;
    private String kuroTipas;

    public Car(String gamintojas, String modelis, Integer metai, Integer kaina, Double variklioTuris, String kuroTipas) {
        this.gamintojas = gamintojas;
        this.modelis = modelis;
        this.metai = metai;
        this.kaina = kaina;
        this.variklioTuris = variklioTuris;
        this.kuroTipas = kuroTipas;
    }

    @Override
    public String toString() {

        StringBuilder txt = new StringBuilder();

        txt.append("Automobilis: ").append(gamintojas);
        txt.append(" ").append(modelis);
        txt.append(", Metai: ").append(metai);
        txt.append(", Kaina: ").append(kaina);
        txt.append(" €, Variklis: ").append(variklioTuris.intValue() * 1000);
        txt.append(" cm2, Kuras: ").append(kuroTipas.equals("D") ? "dyzelis" : "benzinas");

        return txt.toString();
    }

    public String getGamintojas() {
        return gamintojas;
    }

    public void setGamintojas(String gamintojas) {
        this.gamintojas = gamintojas;
    }

    public String getModelis() {
        return modelis;
    }

    public void setModelis(String modelis) {
        this.modelis = modelis;
    }

    public Integer getMetai() {
        return metai;
    }

    public void setMetai(Integer metai) {
        this.metai = metai;
    }

    public Integer getKaina() {
        return kaina;
    }

    public void setKaina(Integer kaina) {
        this.kaina = kaina;
    }

    public Double getVariklioTuris() {
        return variklioTuris;
    }

    public void setVariklioTuris(Double variklioTuris) {
        this.variklioTuris = variklioTuris;
    }

    public String getKuroTipas() {
        return kuroTipas;
    }

    public void setKuroTipas(String kuroTipas) {
        this.kuroTipas = kuroTipas;
    }
}
