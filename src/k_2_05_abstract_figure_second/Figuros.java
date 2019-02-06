package k_2_05_abstract_figure_second;

public abstract class Figuros {

    public abstract Double plotas();

    public abstract Double perimetras();

    // 1. Paskaičiuokite kokie turėtų būti visų perimetrai, kad plotai būtų vienodi, tarkime lygūs 100.
    public abstract Double perimetrasIsPloto(Double plotas);

    // 2. Paskaičiuokite kokie turėtų būti visų plotai, kad perimetrai būtų vienodi, tarkime lygūs 100.
    public abstract Double plotasIsPerimetro(Double perimetras);
}
