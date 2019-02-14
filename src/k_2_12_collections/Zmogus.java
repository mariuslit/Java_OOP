package k_2_12_collections;

public class Zmogus implements Comparable<Zmogus> {

    private String vardas;
    private String pavarde;
    private String asmensKodas;
    private long id;
    private String department;
    private Double salary;

    public Zmogus(String vardas, String pavarde, String asmensKodas, String department, Double salary) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.asmensKodas = asmensKodas;
        this.id = Long.parseLong(asmensKodas);
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {

        return vardas + " " + pavarde + " " + asmensKodas;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getAsmensKodas() {
        return asmensKodas;
    }

    public void setAsmensKodas(String asmensKodas) {
        this.asmensKodas = asmensKodas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Zmogus o) {

        Zmogus employee = (Zmogus) o;
        if (getId() < employee.getId()) return -1;
        if (getId() > employee.getId()) return 1;

        int comp = getVardas().compareTo(employee.getVardas());
        if (comp != 0) return comp;

        comp = getDepartment().compareTo(employee.getDepartment());
        if (comp != 0) return comp;

        return getSalary().compareTo(employee.getSalary());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zmogus employee = (Zmogus) o;

        if (id != employee.id) return false;
        if (vardas != null ? !vardas.equals(employee.vardas) : employee.vardas != null) return false;
        if (department != null ? !department.equals(employee.department) : employee.department != null) return false;
        return salary != null ? salary.equals(employee.salary) : employee.salary == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (vardas != null ? vardas.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }
}
