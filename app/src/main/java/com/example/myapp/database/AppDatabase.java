package com.example.myapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapp.dao.DepenseDao;
import com.example.myapp.dao.InfosPersonneDao;
import com.example.myapp.dao.MontantDao;
import com.example.myapp.dao.UserDao;
import com.example.myapp.entities.Depense;
import com.example.myapp.entities.InfosPersonne;
import com.example.myapp.entities.Montant;
import com.example.myapp.entities.User;

@Database(entities = {Depense.class, InfosPersonne.class,
        Montant.class, User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase db = null;

    public static synchronized AppDatabase getDatabase(Context context){
        if (db==null){
            db = Room.databaseBuilder(context,
                    AppDatabase.class, "daycount_db").build();
        }
        return db;
    }

    private void clearAllTablesForDb(){
        if (db!=null){
            db.clearAllTables();
        }
    }
    public abstract UserDao userDao();
    public abstract MontantDao montantDao();
    public abstract InfosPersonneDao infosPersonneDao();
    public abstract DepenseDao depenseDao();

}
