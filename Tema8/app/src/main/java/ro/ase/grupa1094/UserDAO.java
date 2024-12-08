package ro.ase.grupa1094;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM users")
    List<User> getUser();

    @Query("UPDATE users SET name = :name, password = :password WHERE id = :id")
    void updateUser(Long id, String name, String password);

    @Delete
    void deleteUser(User user);
}
