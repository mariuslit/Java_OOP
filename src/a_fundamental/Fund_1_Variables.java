package a_fundamental;

public class Fund_1_Variables {

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

        System.out.println(">" + '\u0000' + "<");
        System.out.println("Byte max value               +" + Byte.MAX_VALUE);
        System.out.println("Short max value              +" + Short.MAX_VALUE);
        System.out.println("Integer max value            +" + Integer.MAX_VALUE);
        System.out.println("Long max value               +" + Long.MAX_VALUE);
        System.out.println();

        //                                                    1234567 9012345678901234567890123456789
        System.out.println("Float number                 +" + 340282340000000000000000000000000000000.0);
        System.out.println("Float max value              +" + Float.MAX_VALUE);

        //                                                    1234567890123456 890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678
        System.out.println("Double number                +" + 179769313486231570000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0);
        System.out.println("Double max value             +" + Double.MAX_VALUE);
        System.out.println();

        System.out.println("Byte 3 < Short 5 =           " + (Byte.MAX_VALUE < Short.MAX_VALUE));
        System.out.println("Short 5 < Integer 10 =       " + (Short.MAX_VALUE < Integer.MAX_VALUE));
        System.out.println("Integer 10 < Long 19 =       " + (Integer.MAX_VALUE < Long.MAX_VALUE));

        System.out.println("Long 19 < Float 38.0 =       " + (Long.MAX_VALUE < Float.MAX_VALUE));
        System.out.println("Long 38.0 < Double 308.0 =   " + (Long.MAX_VALUE < Double.MAX_VALUE));
    }
}
