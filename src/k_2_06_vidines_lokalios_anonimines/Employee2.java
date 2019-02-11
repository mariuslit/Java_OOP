package k_2_06_vidines_lokalios_anonimines;

public class Employee2 { // todo pabaigti

    //    public class Employee {
    private String name;
    private Double atlyginimas;
    private Address address;
    private Address1 address1;

    public Employee2(String name, Double atlyginimas, String city, String street, String number) {
        this.name = name;
        this.atlyginimas = atlyginimas;
        this.address = new Address(city, street, number);
        this.address1 = new Address1(city, street, number);
    }

    @Override
    public String toString() {
        return "Vardas: " + name
                + " Atlyginimas: " + atlyginimas
                + " Adresas: " + address.toString();
    }

    class Address {
        private String city;
        private String street;
        private String number;

        public Address(String city, String street, String number) {
            this.city = city;
            this.street = street;
            this.number = number;
        }

        public void Test() {
            System.out.println(Employee2.this.toString());
        }

        @Override
        public String toString() {
            return "Miestas: " + city + " Gatve: " + street + " Numeris: " + number;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }

    static class Address1 {
        private String city;
        private String street;
        private String number;

        public Address1(String city, String street, String number) {
            this.city = city;
            this.street = street;
            this.number = number;
        }

        public void Test() {
            System.out.println("Test");
        }

        @Override
        public String toString() {
            return "Miestas: " + city + " Gatve: " + street + " Numeris: " + number;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAtlyginimas() {
        return atlyginimas;
    }

    public void setAtlyginimas(Double atlyginimas) {
        this.atlyginimas = atlyginimas;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address1 getAddress1() {
        return address1;
    }

    public void setAddress1(Address1 address1) {
        this.address1 = address1;
    }
}
