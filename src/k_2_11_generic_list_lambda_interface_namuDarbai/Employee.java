package k_2_11_generic_list_lambda_interface_namuDarbai;

public class Employee implements Comparable<Employee> {

    String vardas;
    Double atlyginimas;

    public Employee(String vardas, Double atlyginimas) {
        this.vardas = vardas;
        this.atlyginimas = atlyginimas;
    }

    @Override
    public int compareTo(Employee o) {

            return this.atlyginimas.compareTo(o.getAtlyginimas());
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public Double getAtlyginimas() {
        return atlyginimas;
    }

    public void setAtlyginimas(Double atlyginimas) {
        this.atlyginimas = atlyginimas;
    }

    public String toString() {

        return "Darbuotojas: " + getVardas() + ", atlyginimas: " + getAtlyginimas();
    }
}
