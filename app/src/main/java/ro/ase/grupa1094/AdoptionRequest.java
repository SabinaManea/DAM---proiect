package ro.ase.grupa1094;

import java.io.Serializable;

enum Animal {
    CAT, DOG, BIRD
}
public class AdoptionRequest implements Serializable {
    private String numeAdoptator;
    private int phoneNumber;
    private String email;
    private Animal animal;

    public AdoptionRequest(String numeAdoptator, int phoneNumber, String email, Animal animal) {
        this.numeAdoptator = numeAdoptator;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.animal = animal;
    }

    public String getNumeAdoptator() {
        return numeAdoptator;
    }

    public void setNumeAdoptator(String numeAdoptator) {
        this.numeAdoptator = numeAdoptator;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "AdoptionRequest{" +
                "numeAdoptator='" + numeAdoptator + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", animal=" + animal +
                '}';
    }
}
