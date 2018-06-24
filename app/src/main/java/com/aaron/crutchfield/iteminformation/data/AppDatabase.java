package com.aaron.crutchfield.iteminformation.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by Aaron Crutchfield on 6/19/2018.
 */
@Database(entities = {ItemEntry.class}, version = 6, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "itemDatabase";
    private static AppDatabase sInstance;

    static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return sInstance;
    }

    public abstract ItemDao itemDao();
}
