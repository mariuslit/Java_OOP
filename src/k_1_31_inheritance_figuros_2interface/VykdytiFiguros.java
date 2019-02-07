package k_1_31_inheritance_figuros_2interface;

public class VykdytiFiguros {

    /*
     * + 3 Sukurti bazinę klasę Figura ir vaikines klases Staciakampis, Kvadratas, StaciakampisTrikampis.
     * +      Sukurti funckiją, kuri grąžina perimetrą.
     * +      Sukurti funkciją, kuri grąžina plotą.
     * +      Užkloti toString() funkciją, kad jis gražintų figūros perimetrą ir plotą.
     */
    public static void main(String[] args) {

        Kvadratas kvadratas = new Kvadratas(5.0);

        // paveldėjimas + interfeisai

        // interfeisas InterfeisasFiguroms
        System.out.println("kvadrato plotas " + kvadratas.plotas(kvadratas.getKrastine(), kvadratas.getKrastine())); // metodas įgyvendintas tėvinėje klasėje
        System.out.println("kvadrato perimeras " + kvadratas.perimetras(kvadratas.getKrastine(), kvadratas.getKrastine())); // metodas įgyvendintas tėvinėje klasėje

        System.out.println(kvadratas.plotas(3.3, 6.6)); // panaudotas tėvinės klasės Figuros metodas

        System.out.println(kvadratas.kelkSkaiciuKvadratu(6d)); // panaudotas neprivalomas interfeiso (default) InterfeisasFiguroms metodas
        System.out.println(kvadratas.sudekSkaicius(6d)); // panaudotas antras neprivalomas interfeiso (default) InterfeisasFiguroms metodas

        // interfeisas InterfeisasMetoduLobynas
        kvadratas.spausdinkFigurosVarda(kvadratas); // panaudotas įgyvendintas interfeiso InterfeisasMetoduLobynas metodas
        kvadratas.spausdinkFigurosVarda(); // panaudotas neprivalomas (default) interfeiso InterfeisasMetoduLobynas metodas
        kvadratas.spausdinkFigurosVarda("tikriausiai čia kvadratas"); // panaudotas antras neprivalomas (default) interfeiso InterfeisasMetoduLobynas metodas



        System.out.println("--------------");
        Staciakampis staciakampis = new Staciakampis(3.0, 4.0);
        System.out.println("stačiakampio plotas " + staciakampis.plotas(staciakampis.getKrastineX(), staciakampis.getKrastineY()));
        System.out.println("stačiakampio perimeras " + staciakampis.perimetras(staciakampis.getKrastineX(), staciakampis.getKrastineY()));
        System.out.println("--------------");
        StaciakampisTrikampis staciakampisTrikampis = new StaciakampisTrikampis(3.0, 4.0);
        System.out.println("stačiakampio trikampio plotas " + staciakampisTrikampis.plotas());
        System.out.println("stačiakampio trikampio perimeras " + staciakampisTrikampis.perimetras());
    }
}
