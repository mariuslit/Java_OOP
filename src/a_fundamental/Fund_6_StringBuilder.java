package a_fundamental;

public class Fund_6_StringBuilder {

    public static void main(String args[]) {

        StringBuilder sb = new StringBuilder("StringBuildre: ");

        sb.append("tekstas").append(" antras ").append(3);

        System.out.println(sb);


        String txt = sb.append(" StringBuilder paverstas į String").toString();

        System.out.println(txt);
    }
    // atsakymas:
    // StringBuildre: tekstas antras 3
}
