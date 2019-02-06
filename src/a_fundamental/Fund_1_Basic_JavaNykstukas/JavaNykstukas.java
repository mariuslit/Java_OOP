package a_fundamental.Fund_1_Basic_JavaNykstukas;

public class JavaNykstukas {

    private String firstName;
    public String lastName;
//    public String name;

    JavaNykstukas(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }
}

