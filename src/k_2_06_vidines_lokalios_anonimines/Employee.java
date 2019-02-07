package k_2_06_vidines_lokalios_anonimines;

public class Employee {

    private String name;
    private Address address;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(String city, String street, Integer number) {
        this.address = new Address(city, street, number);
    }

    /**
     * vidinė klasė
     */
    class Address {

        private String city;
        private String street;
        private Integer number;

        public Address(String city, String street, Integer number) {
            this.city = city;
            this.street = street;
            this.number = number;
        }

        public String getFullAdress() {
            return city + " " + street + " " + number;
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

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }
    }
}
