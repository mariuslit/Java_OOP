package a_fundamental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fund_24_Casting {

    public static void main(String[] args) {

        List<Object> list = new ArrayList<>();
        List<?> list2 = list;
        list.add("a");
        list.add(100);

        Object o = list.get(0);

        // kastinant objektus vyksta sutikrinimas at tas tipas atitinka kastinamą tipą
        // būtina tikrinti prieš kastinams su instanceOf
        if (o instanceof String) {

            String lenght = (String) o;
            // kompiliatorius tikrina ir meta klaidą jeigu objeko tipas neattiinka kastinamo objekto tipo
            int len = ((String) o).length();
            System.out.println(o);
        }


        // kastinant primityvus tipus keičiasi tipas
        // primityvūs tipai kastinami
        System.out.println((int) 1000000000000000000L);
        System.out.println((int) 1000000000000000000L);
        System.out.println((int) (100.0/33.0));

        // int	    +2_147_483_647  -2_147_483_648
        // short           +32_767         -32_768
        int in = 32_770;
        short sh = (short) in; // konvertuoja teisingai tik iki short rėžių
        System.out.println(sh);

        // double   +1.797_693_134_862_315_7 E+308  (-)4.9 E-324
        // byte	    +127                            -128
        double db = 127.9;
        byte by = (byte) db; // konvertuoja teisingai tik iki byte rėžių
        System.out.println(by);
    }
}
