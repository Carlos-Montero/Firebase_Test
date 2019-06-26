package com.example.carlos.firebase_test.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Drug DB class. (NOT USED)
 * Definition of all the entities (tables that you want to create for that database).
 * Definition of the list of operation that we would like to perform on table.
 */

@Database(entities = {Drug.class}, version = 1)
public abstract class DrugDatabase extends RoomDatabase {

    public abstract DrugDAO drugDAO();

    private static volatile DrugDatabase INSTANCE;

    public static DrugDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DrugDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DrugDatabase.class, "DrugDatabase.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}