package ro.ase.grupa1094;

import java.io.Serializable;

enum TipAnimal{
    CAT, DOG, BIRD
}

public class Animal implements Serializable {
    private String name;
    private String phoneNumber;
    private String email;
    private TipAnimal tipAnimal;

    public Animal(String name, String phoneNumber, String email, TipAnimal tipAnimal) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.tipAnimal = tipAnimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipAnimal getTipAnimal() {
        return tipAnimal;
    }

    public void setTipAnimal(TipAnimal tipAnimal) {
        this.tipAnimal = tipAnimal;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", tipAnimal=" + tipAnimal +
                '}';
    }
}
