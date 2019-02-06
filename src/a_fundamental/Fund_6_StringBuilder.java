package a_fundamental;

public class Fund_6_StringBuilder {

    public static void main(String args[]) {

        StringBuilder sb = new StringBuilder("StringBuildre: ");
        sb.append("tekstas").append(" antras ").append(3);
        System.out.println(sb.toString());

        String sss = "String:        " + "tekstas" + " antras " + 7;
        System.out.println(sss);
    }
    // atsakymas:
    // StringBuildre: tekstas antras 3
    // String:        tekstas antras 7
}
