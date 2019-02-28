package k_2_19_PrekybaElektronikosPrekemis_100proc;

public class Telefonas {

    private Integer id;
    private String modelis;
    private Double kaina;
    private Integer pardavimuSkaicius;
    private Double apyvarta;

    public Telefonas(Integer id, String modelis, Double kaina) {
        this.id = id;
        this.modelis = modelis;
        this.kaina = kaina;
        this.pardavimuSkaicius = 0;
        this.apyvarta = 0d;
    }

    @Override
    public String toString() {

        return id + " " + modelis + " " + kaina + ", parduota vnt: " + pardavimuSkaicius+ ", apyvarta €: " + getApyvarta();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelis() {
        return modelis;
    }

    public void setModelis(String modelis) {
        this.modelis = modelis;
    }

    public Double getKaina() {
        return kaina;
    }

    public void setKaina(Double kaina) {
        this.kaina = kaina;
    }

    public Integer getPardavimuSkaicius() {
        return pardavimuSkaicius;
    }

    public void setPardavimuSkaicius(Integer pardavimuSkaicius) {
        this.pardavimuSkaicius += pardavimuSkaicius;
    }

    public Double getApyvarta() {
        return pardavimuSkaicius * kaina;
    }

    public void setApyvarta(Double apyvarta) {
        this.apyvarta = apyvarta;
    }
}
