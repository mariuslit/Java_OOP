package a_fundamental;

/**
 * vidinių (inner) klasių kūrimas ir anaudojimas
 * <p>
 * vidinės klasės gali būti dviejų tipų - paprastos ir statinės (pažymėtos static).
 */
public class Fund_11_Class_Inner {

    public static void main(String[] args) {

        A isorines_Kl_Obj = new A();

        // sukuriami vidinės klasės objektai
        A.B vidinesPaprastos_Kl_Obj = isorines_Kl_Obj.new B(); // paprastos
        A.B2 vidinesStatines_Kl_Obj = new A.B2(); // statinės


// todo paklausti Džiugo kaip pasiekti B2 klasės kintamuosius ir metodus
//        A.this.a_text
//
//        A-klasė.this.išorinės-klasės-laukas-ar-metodas
//        ClassA.fieldB = 3;

        isorines_Kl_Obj.a_text = "čia išorinės klasės kintamasis";
        System.out.println(isorines_Kl_Obj.a_text);

        vidinesPaprastos_Kl_Obj.b_text = "čia vidinės paprastos klasės kintamasis";
        System.out.println(vidinesPaprastos_Kl_Obj.b_text);

        vidinesPaprastos_Kl_Obj.b_text = "čia vidinės statinės klasės kintamasis";
        System.out.println(vidinesPaprastos_Kl_Obj.b_text);
    }
}

class A {

    String a_text = "bet koks tekstas";

    class B {
        String b_text;

        // anoniminė ar ne ???
        class C {

        }

        void print() {
            System.out.println(A.this.a_text);
        }
    }


    static class B2 {
        String b2_text;
    }
}


