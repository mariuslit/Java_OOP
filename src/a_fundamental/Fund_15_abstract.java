package a_fundamental;

/**
 * abstract klasė
 * glima išplėsti (extends) jeigu Fund_15_abstract nėra final tipo
 */
public abstract class Fund_15_abstract /*extends TestAbstract*/ {

    /**
     * ši klasė turi du privalomus įgyvendinti metudus (abstract):
     */
    public abstract String zmogausID();

    public abstract void spausdinti(String txt);

    /**
     * ši klasė turi ir savo kintamuosius ir konstruktorių ir savo metodus:
     */
    private String vardas;
    private Integer amzius;

    public Fund_15_abstract(String vardas, Integer amzius) {
        this.vardas = vardas;
        this.amzius = amzius;
    }


    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public Integer getAmzius() {
        return amzius;
    }

    public void setAmzius(Integer amzius) {
        this.amzius = amzius;
    }
}

class AAA extends Fund_15_abstract {

    public AAA(String vardas, Integer amzius) {
        super(vardas, amzius); // jei paveldima klasė turi konstruktorių privaloma jį panaudoi su super
    }

    @Override
    public String zmogausID() {
        return getVardas() + "_" + getAmzius();
    }

    @Override
    public void spausdinti(String text) {
        System.out.println(text);
    }
}

class TestAbstract {

    public static void main(String[] args) {

        // norint sukurti abstrakčios klasės objektą reikia perrašyti
        // jos abtarkčius metodus objekto sukūrimo metu
        Fund_15_abstract xxx = new Fund_15_abstract("Marius", 44) {
            @Override
            public String zmogausID() {
                return null;
            }

            @Override
            public void spausdinti(String txt) {

            }
        };

        AAA aaa = new AAA("Marius", 44);
        aaa.spausdinti(aaa.zmogausID());
    }
}


// testas kai abstrakti klasė neturi abstract metodų
abstract class ABase {

    boolean b;
    Boolean bb=true;
    int size = 10;

    int methodB() {
        return this.size += 2;
    }
}

class ss {

    public static void main(String[] args) {

        ABase a = new ABase(){};
        System.out.println(a.methodB());
        boolean ssb = a.b;
        Boolean ssbb = a.bb;

        System.out.println(ssb);
        System.out.println(ssbb);
    }
}



