package a_learning;

public class Beginer {

    public static void main(String[] args) {
        // Class       Primitive
        // Data Type   Data Type   Default     MAX value                         MIN value
        // ---------   ---------   ---------   -------------------               ----------------------------
        // Byte        byte	       0           +127                              -128
        // Short       short	   0           +32,767                           -32,768
        // Integer     int	       0           +2,147,483,647                    -2,147,483,648
        // Long        long	       0L          +9,223,372,036,854,775,807        -9,223,372,036,854,775,808
        //                                                                       .
        // Float       float	   0.0f        +3.402,823,5 E+38                 (-)1.4 E-45
        // Double      double      0.0d        +1.797,693,134,862,315,7 E+308    (-)4.9 E-324
        //                                                                       .
        // Boolean     boolean	   false       true                              false
        //                                                                       .
        // Character   char	       '\u0000'                                      .
        // String                  null                                          .
        // Array                                                                 .
        // Object                                                                .


        byte a = 0;
        short b = 0;
        int c = 0;
        long d = 0;

        float e = 0;
        double f = 0;

        char g = '\u0000', g1 = 'a', g2 = 5;
        String h = "-simbolių eilutė-";

        boolean i = false;

        System.out.println(a + b + c + d + e + f + g + h + i);
        main1();
    }

    public static void main1() {

        Byte a = 0;
        Short b = 0;
        Integer c;
        Long i = 0L;
        Float j = 0F; // 0f
        Double k = 0D; // 0d, 0.0
        Character l = 'a';
        String o = "Žodis";
        Boolean p = false;


//      Klasės      Primity-    Dfault      Priskyrimas
//                  vus         reikšmė
//        Byte        byte        0           a = 0;
//        Short       short       0           b = 0;
//        Integer     int         0           c = 0;
//        Long        long        0L          d = 0L;
//        Float       float       0.0f        e = 0F; // 0f
//        Double      double      0.0d        f = 0D; // 0d, 0.0
//        Character   char        '\u0000'    g = 'a';
//        String      String      null        h = "Žodis";
//        Boolean     boolean     false       i = false;

//      Iniciavimas
//        int a;                      // kintamojo paskelbimas
//        int b = 0;                  // kintamojo iniciavimas
//        int C = 5, d = 66, e = 777;

        String mariusLitvinasIrIndrėLitvinienė = "pirmas suolas";
        String pirmasSuolas = "Marius Litvinas ir Indrė Litvinienė";

        System.out.println(mariusLitvinasIrIndrėLitvinienė);
        System.out.println(pirmasSuolas);
    }
}


