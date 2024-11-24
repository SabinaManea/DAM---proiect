package ro.ase.grupa1094;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Animal.class}, version = 1, exportSchema = false)
public abstract class AnimalDB extends RoomDatabase {
    private static AnimalDB instance;
    public static final String databaseName = "Animale.db";
    public static AnimalDB getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context, AnimalDB.class, databaseName)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract AnimalDAO getAnimalDAO();
}
