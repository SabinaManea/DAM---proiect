package ro.ase.grupa1094;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AnimalDAO {
    @Insert
    void insertAnimal(Animal animal);

    @Query("SELECT * FROM animale")
    List<Animal> getAnimale();

    @Query("UPDATE animale SET name = :name, phoneNumber = :phoneNumber, tipAnimal = :tipAnimal WHERE id = :id")
    void updateAnimal(Long id, String name, String phoneNumber, TipAnimal tipAnimal);

    @Delete
    void deleteAnimal(Animal animal);
}
