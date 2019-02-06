package k_1_31_inheritance_figuros;

public interface InterfeisasMetoduLobynas {

    void spausdinkFigurosVarda(Object obj);

    default void spausdinkFigurosVarda() {
        System.out.println("trikampis čia, o gal kvadratas, nežinau");
    }

    default void spausdinkFigurosVarda(String vardas) {
        System.out.println("figuros vardas yra " + vardas);
    }
}
