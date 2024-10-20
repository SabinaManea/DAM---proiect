package ro.ase.grupa1094;

public class Donation {
    private String donator;
    private int suma;
    private String dataDonatiei;
    private String detaliiDonatie;

    public Donation(String donator, int suma, String dataDonatiei, String detaliiDonatie) {
        this.donator = donator;
        this.suma = suma;
        this.dataDonatiei = dataDonatiei;
        this.detaliiDonatie = detaliiDonatie;
    }

    public String getDonator() {
        return donator;
    }

    public void setDonator(String donator) {
        this.donator = donator;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public String getDataDonatiei() {
        return dataDonatiei;
    }

    public void setDataDonatiei(String dataDonatiei) {
        this.dataDonatiei = dataDonatiei;
    }

    public String getDetaliiDonatie() {
        return detaliiDonatie;
    }

    public void setDetaliiDonatie(String detaliiDonatie) {
        this.detaliiDonatie = detaliiDonatie;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "donator='" + donator + '\'' +
                ", suma=" + suma +
                ", dataDonatiei='" + dataDonatiei + '\'' +
                ", detaliiDonatie='" + detaliiDonatie + '\'' +
                '}';
    }
}
