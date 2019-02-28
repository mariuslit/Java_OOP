package xxx_kastinimas;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Kastinimas {

    public static void main(String[] args) {

        // Data Type	             Default        number max                       number min
        // -----------------------------------------------------------------------------------------------------
        // byte	                     0              +127                            -128
        // short	                 0              +32,767                         -32,768
        // int	                     0              +2,147,483,647                  -2,147,483,648
        // long	                     0L             +9,223,372,036,854,775,807      -9,223,372,036,854,775,808
        // -----------------------------------------------------------------------------------------------------
        // float	                 0.0f           +3.402,823,5 E+38               (-)1.4 E-45
        // double                	 0.0d           +1.797,693,134,862,315,7 E+308  (-)4.9 E-324
        // -----------------------------------------------------------------------------------------------------
        // char	                     '\u0000'
        // String (or any object)  	 null
        // boolean	                 false          true                            false

        short sh = 5;
        int x = sh;
        int iiii = 327695;
        short sss = (short) iiii;
        System.out.println(sss);
    }
}

class Double_apvalinimas {

    public static void main(String[] args) {

        System.out.println(4.055);
        System.out.println(4.5);

        NumberFormat d = new DecimalFormat("#0.00");
        // TODO: 2019-02-13  kodėl 0.055 apvalinamas į 0.5
        System.out.println(d.format(4.055));
        System.out.println(d.format(4.5));
    }
}
