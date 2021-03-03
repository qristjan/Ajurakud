package ajurakudroot.loom;

public class Loom {

    private String nimi;
    private Double elupunktid;

    protected void smash(Integer bros) {
        System.out.println("SMASH");
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public Double getElupunktid() {
        return elupunktid;
    }

    public void setElupunktid(Double elupunktid) {
        this.elupunktid = elupunktid;
    }
}
