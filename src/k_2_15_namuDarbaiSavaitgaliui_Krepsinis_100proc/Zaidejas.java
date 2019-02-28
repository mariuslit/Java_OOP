package k_2_15_namuDarbaiSavaitgaliui_Krepsinis_100proc;

public class Zaidejas implements Comparable<Zaidejas> {

    private Integer numeris;
    private String vardas;
    private String pavarde;

    private Integer nepataikyta; // 0 metė, bet nepataikė
    private Integer baudos; //      1 taskas
    private Integer dvitaskiai; //  2 taskai
    private Integer tritaskiai; //  3 taskai

    public Zaidejas(Integer numeris, String vardas, String pavarde) {
        this.numeris = numeris;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.nepataikyta = 0;
        this.baudos = 0;
        this.dvitaskiai = 0;
        this.tritaskiai = 0;
    }

//        @Override
//    public boolean equals(Object obj) {
//
//        Zaidejas zd = (Zaidejas) obj;
//        return this.numeris.equals(zd.numeris);
//    }

    @Override
    public int compareTo(Zaidejas obj) {
/*      Tritaškių metimų skaičius
        Dvitaškių metimų skaičius
        Baudų metimų skaičius
        Nepataikytų metimų skaičius
        Tikslumas */

        if (this.getTaiklumas() != null && this.getTaiklumas() > obj.getTaiklumas()) return 1;
        if (this.getTaiklumas() != null && this.getTaiklumas() < obj.getTaiklumas()) return -1;
//
//        if (this.getNepataikyta() != null && this.getNepataikyta() > o.getNepataikyta()) return 1;
//        if (this.getNepataikyta() != null && this.getNepataikyta() < o.getNepataikyta()) return -1;
//
//        if (this.getBaudos() != null && this.getBaudos() > o.getBaudos()) return 1;
//        if (this.getBaudos() != null && this.getBaudos() < o.getBaudos()) return -1;
//
//        if (this.getDvitaskiai() != null && this.getDvitaskiai() > o.getDvitaskiai()) return 1;
//        if (this.getDvitaskiai() != null && this.getDvitaskiai() < o.getDvitaskiai()) return -1;
//
//        if (this.getTritaskiai() != null && this.getTritaskiai() > o.getTritaskiai()) return 1;
//        if (this.getTritaskiai() != null && this.getTritaskiai() < o.getTritaskiai()) return -1;

        return 0;
    }

    @Override
    public String toString() {

        StringBuilder txt = new StringBuilder();
        txt
                .append(String.format("Nr. %-2d", getNumeris()))
                .append(String.format(" %-20.20s: ", getVardas() + " " + getPavarde()))
        ;

        return txt.toString();
    }

    public String toStringAll() {

        StringBuilder txt = new StringBuilder();
        txt
                .append(String.format("| %-3d ", getNumeris()))
                .append(String.format("| %-21.21s ", getVardas() + " " + getPavarde()))
                .append(String.format("| %-6d ", getBaudos()))
                .append(String.format("| %-5d ", getDvitaskiai()))
                .append(String.format("| %-5d ", getTritaskiai()))
                .append(String.format("| %-6d ", getNepataikyta()))
                .append(String.format("| %-6d ", getTaskai()))
                .append(String.format("| %7.1f", getTaiklumas()))
                .append(" % |")
        ;

        return txt.toString();
    }

    public Double getTaiklumas() {

        return getMetimuSkaicius().equals(0) ? 0 : 100 - (double) (getNepataikyta()) / getMetimuSkaicius() * 100;
    }

    public Integer getMetimuSkaicius() {
        return getNepataikyta() + getBaudos() + getDvitaskiai() + getTritaskiai();
    }

    public Integer getNumeris() {
        return numeris;
    }

    public void setNumeris(Integer numeris) {
        this.numeris = numeris;
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

    public Integer getNepataikyta() {
        return nepataikyta;
    }

    public void setNepataikyta() {
        this.nepataikyta++;
    }

    public Integer getBaudos() {
        return baudos;
    }

    public void setBaudos() {
        this.baudos++;
    }

    public Integer getDvitaskiai() {
        return dvitaskiai;
    }

    public void setDvitaskiai() {
        this.dvitaskiai++;
    }

    public Integer getTritaskiai() {
        return tritaskiai;
    }

    public void setTritaskiai() {
        this.tritaskiai++;
    }

    public Integer getTaskai() {
        return getBaudos() + getDvitaskiai() * 2 + getTritaskiai() * 3;
    }
}
