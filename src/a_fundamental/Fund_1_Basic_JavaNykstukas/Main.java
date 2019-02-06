package a_fundamental.Fund_1_Basic_JavaNykstukas;

public class Main {

    public static void main(String[] args) {

        JavaNykstukas studentas = new JavaNykstukas("Tomas", "Vetlovas");


        JavaNykstukas studentas2 = new JavaNykstukas("", "");
        studentas2.setFirstName("Kamilė");
        studentas2.setLastName("Bykova");


        System.out.println(studentas.getName());
        System.out.println(studentas2.getName());

    }
}
