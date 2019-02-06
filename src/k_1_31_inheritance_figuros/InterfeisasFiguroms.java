package k_1_31_inheritance_figuros;

interface InterfeisasFiguroms {

    Double perimetras();

    Double plotas();

    default Double kelkSkaiciuKvadratu(Double sk) {
        return sk * sk;
    }

    default Double sudekSkaicius(Double sk) {
        return sk + sk;
    }
}
