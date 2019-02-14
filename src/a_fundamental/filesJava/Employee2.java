package a_fundamental.filesJava;

public class Employee2 {

    private String name;

    private double salary;

    private String department;

    public Employee2(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee2(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}