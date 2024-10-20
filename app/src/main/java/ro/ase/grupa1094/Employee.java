package ro.ase.grupa1094;

public class Employee {
    private String nume;
    private String rol;
    private String telefon;
    private String email;
    private String responsabilitati;

    public Employee(String nume, String rol, String telefon, String email, String responsabilitati) {
        this.nume = nume;
        this.rol = rol;
        this.telefon = telefon;
        this.email = email;
        this.responsabilitati = responsabilitati;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResponsabilitati() {
        return responsabilitati;
    }

    public void setResponsabilitati(String responsabilitati) {
        this.responsabilitati = responsabilitati;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "nume='" + nume + '\'' +
                ", rol='" + rol + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", responsabilitati='" + responsabilitati + '\'' +
                '}';
    }
}
