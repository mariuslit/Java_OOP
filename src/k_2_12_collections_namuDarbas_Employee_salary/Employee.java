package k_2_12_collections_namuDarbas_Employee_salary;

public class Employee implements Comparable<Employee>{

    private String name;
    private String lastNam;
    private Integer age;
    private String position;

    public Employee(String name, String lastNam, Integer age, String position) {
        this.name = name;
        this.lastNam = lastNam;
        this.age = age;
        this.position = position;
    }

    @Override
    public int compareTo(Employee o) {

        Employee employee = (Employee) o;
        if (getAge() < employee.getAge()) return -1;
        if (getAge() > employee.getAge()) return 1;

        int comp = getName().compareTo(employee.getName());
        if (comp != 0) return comp;

        comp = getPosition().compareTo(employee.getPosition());
        if (comp != 0) return comp;

        return getLastNam().compareTo(employee.getLastNam());
    }

    @Override
    public String toString() {
        return position + " " + name + " " + lastNam + " " + age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastNam() {
        return lastNam;
    }

    public void setLastNam(String lastNam) {
        this.lastNam = lastNam;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
