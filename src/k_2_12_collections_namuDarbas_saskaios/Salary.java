package k_2_12_collections_namuDarbas_saskaios;

public class Salary {

    private Employee employee;
    private Double salary;

    public Salary(Employee employee, Double salary) {
        this.employee = employee;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return employee.toString() + " " + salary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
