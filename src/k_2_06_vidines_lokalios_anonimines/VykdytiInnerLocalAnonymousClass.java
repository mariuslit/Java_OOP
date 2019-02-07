package k_2_06_vidines_lokalios_anonimines;

public class VykdytiInnerLocalAnonymousClass {
//     vidinės klasės (inner class)
//      +    Tarkime turime klasę Employee ir jos vidinę klasę Address.
//      +        Tegul klasėje Employee turime du laukus - String name, (Double atlyginimas?) ir Address address,
//      +        o Address klasė turi laukus - String city, String street, String number.
//      -    Sukurkite keletą darbuotojų su vardu ir adresu
//      -        ir pabandykit nustatyti iš kelių skirtingų miestų yra darbuotojai.
//      -    Nustatykite iš kelių skirtingų miestų ir gatvių yra darbuotoja

    public static void main(String[] args) {

        // išorinė klasė
        Employee employee1 = new Employee("Marius");
        employee1.setAddress("Kaunas", "Riešutų", 5);
        System.out.println(employee1.getName());
        System.out.println(employee1.getAddress().getFullAdress());

        // vidinė klasė
        Employee.Address address = employee1.new Address("Miestas-default", "Gatvė-default", 0);
        address.setCity("Klaipėda");
        System.out.println(address.getFullAdress());



        Employee employee2 = new Employee("Darius");
        employee2.setAddress("Kaunas", "Briedžių", 7);
        Employee employee3 = new Employee("Andrius");
        employee3.setAddress("Vilnius", "Rožių", 85);
    }
}
