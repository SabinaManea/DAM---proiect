package ro.ase.grupa1094;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

enum TipAnimal{
    CAT, DOG, BIRD
}
@Entity(tableName = "Animale")
public class Animal implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", tipAnimal=" + tipAnimal +
                '}';
    }
}
