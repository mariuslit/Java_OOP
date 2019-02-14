package a_fundamental.filesJava;

public class Salary {

    private Employee2 employee;
    private Double atlyginimas;

    public Salary(Employee2 employee, Double atlyginimas) {
        this.employee = employee;
        this.atlyginimas = atlyginimas;
    }

    public Employee2 getEmployee() {
        return employee;
    }

    public void setEmployee(Employee2 employee) {
        this.employee = employee;
    }

    public Double getAtlyginimas() {
        return atlyginimas;
    }

    public void setAtlyginimas(Double atlyginimas) {
        this.atlyginimas = atlyginimas;
    }

    public String toString() {
        return employee.toString();
    }
}
