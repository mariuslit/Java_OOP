package k_2_13_collections_klasesDarbas_darbuotojai;

public class Employee implements Comparable<Employee> {

    private String vardas;
    private String pavarde;
    private String departamentas;
    private Double alga;

    public Employee(String vardas, String pavarde, String departamentas, Double alga) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.departamentas = departamentas;
        this.alga = alga;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;    // apsauginiai tikrinimai
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;

        return
                this.vardas != null && this.vardas.equals(other.vardas) &&
                this.pavarde != null && this.pavarde.equals(other.pavarde) &&
                this.departamentas != null && this.departamentas.equals(other.departamentas) &&
                this.alga != null && this.alga.equals(other.alga);
    }

    @Override
    public int compareTo(Employee o) {

        Employee employee = (Employee) o;
//        if (getVardas() < ((Employee) employee).getVardas()) return -1;
//        if (getVardas() > employee.getVardas()) return 1;

        int comp = getVardas().compareTo(employee.getVardas());
        if (comp != 0) return comp;

        comp = getPavarde().compareTo(employee.getPavarde());
        if (comp != 0) return comp;

        comp = getDepartamentas().compareTo(employee.getDepartamentas());
        if (comp != 0) return comp;

        return getAlga().compareTo(employee.getAlga());
    }

    @Override
    public String toString() {

        return vardas + " " + pavarde + " " + departamentas + " " + alga;
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

    public String getDepartamentas() {
        return departamentas;
    }

    public void setDepartamentas(String departamentas) {
        this.departamentas = departamentas;
    }

    public Double getAlga() {
        return alga;
    }

    public void setAlga(Double alga) {
        this.alga = alga;
    }
}
