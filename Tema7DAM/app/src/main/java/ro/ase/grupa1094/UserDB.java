package ro.ase.grupa1094;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDB extends RoomDatabase {
    private static UserDB instance;
    public static final String databaseName = "Users.db";
    public static UserDB getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context, UserDB.class, databaseName)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract UserDAO getUserDAO();
}
