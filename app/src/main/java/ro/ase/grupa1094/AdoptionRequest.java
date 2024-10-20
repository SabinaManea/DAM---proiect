package ro.ase.grupa1094;

public class AdoptionRequest {
    private String adoptator;
    private String animal;
    private String data_cerere;
    private String stare_cerere;

    public AdoptionRequest(String adoptator, String animal, String data_cerere, String stare_cerere) {
        this.adoptator = adoptator;
        this.animal = animal;
        this.data_cerere = data_cerere;
        this.stare_cerere = stare_cerere;
    }

    public String getAdoptator() {
        return adoptator;
    }

    public void setAdoptator(String adoptator) {
        this.adoptator = adoptator;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getData_cerere() {
        return data_cerere;
    }

    public void setData_cerere(String data_cerere) {
        this.data_cerere = data_cerere;
    }

    public String getStare_cerere() {
        return stare_cerere;
    }

    public void setStare_cerere(String stare_cerere) {
        this.stare_cerere = stare_cerere;
    }

    @Override
    public String toString() {
        return "AdoptionRequest{" +
                "adoptator='" + adoptator + '\'' +
                ", animal='" + animal + '\'' +
                ", data_cerere='" + data_cerere + '\'' +
                ", stare_cerere='" + stare_cerere + '\'' +
                '}';
    }
}
