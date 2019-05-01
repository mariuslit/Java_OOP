package a_fundamental;

public class Fund_26_Enum {

    public static void main(String[] args) {

        Eee eee = Eee.five;
        System.out.println("savaitės diena penktadienis, jo skaičius=" + (eee.ordinal() + 1));
    }
}

enum Eee {

    // .ordinl() nurodo enum'o eilės numerį (indeksą)
    one, // ordinl nr = 0
    two,
    three,
    four,
    five, // ordinl nr = 4
    six,
    seven
}