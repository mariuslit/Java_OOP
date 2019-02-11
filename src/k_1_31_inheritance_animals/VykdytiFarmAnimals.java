package k_1_31_inheritance_animals;

public class VykdytiFarmAnimals {

    /*
     * 1   Sukurti bazinę klasę Animal ir vaikines klases Cat, Dog, Cow, Sheep, Chicken.
     *         Užkloti toString funkciją, kad jis gražintų kokį garsą skleidžia gyvūnas.
     * 2   Sukurti klasę Farm kuri turėtų Animal masyvą
     *         ir masyvą užpildykite bent po keliais kiekvienos Animal vaikinės klasės objektais.
     *         Farm klasė toString() turi išspausdinti kiek kokių gyvūnų yra ir jų skleidžiamą garsą.
     */

    public static void main(String[] args) {

        Farm farm = new Farm();

        farm.animals[0] = new Cat(); // 2
        farm.animals[1] = new Dog(); // 2
        farm.animals[2] = new Cow(); // 1
        farm.animals[3] = new Sheep(); // 1
        farm.animals[4] = new Chicken(); // 4
        farm.animals[5] = new Cat();
        farm.animals[6] = new Chicken();
        farm.animals[7] = new Chicken();
        farm.animals[8] = new Dog();
        farm.animals[9] = new Zuvis(); // 1
        farm.animals[10] = new Chicken();

        System.out.println(farm.toString());
    }
}
