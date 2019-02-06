package k_2_05_abstract_figure_second;

public class Vykdyti {
    /*
      +  Sukurkite abstrakčią klasę Figura kurioje būtų aprašyti abstraktūs metodai plotui ir perimetrui paskaičiuoti:
      +  Tada sukurkite dukterines klases Studentas, Kvadratas, Trikampis (lygiakraštis).
      +     1. Paskaičiuokite kokie turėtų būti visų perimetrai, kad plotai būtų vienodi, tarkime lygūs 100.
      +     2. Paskaičiuokite kokie turėtų būti visų plotai, kad perimetrai būtų vienodi, tarkime lygūs 100.
      + Pastaba: apsirašykite Figura klasėje tokius abstrakčius metodus ir po to juos
      +     aprašykite dukterinėse klasėse, kad kaip parametrą pateikus plotą arba
      +     perimetrą, jie paskaičiuotų ir nustatytų atitinkamos figūros kraštinę ar spindulį.
    */

    public static void main(String[] args) {
        Apskritimas a = new Apskritimas(10.0);
        System.out.println("Apskritimo spindulys r, perimetras p, plotas s");
        System.out.println(" p= " + a.perimetras());
        System.out.println(" s= " + a.plotas());
        System.out.println(" r= " + a.getSpindulys());
        System.out.println();
        System.out.println(" p= " + a.perimetrasIsPloto(100.0));
        System.out.println(" r= " + a.getSpindulys());
        System.out.println();
        System.out.println(" s= " + a.plotasIsPerimetro(100.0));
        System.out.println(" r= " + a.getSpindulys());
    }
}
