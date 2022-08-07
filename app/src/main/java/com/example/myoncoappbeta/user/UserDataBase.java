package com.example.myoncoappbeta.user;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class UserDataBase extends RoomDatabase {
    public abstract UserDataDao getDao();

    private static UserDataBase instance;

    static UserDataBase getDatabase(final Context context) {
        if(instance == null) {
            synchronized ( (UserDataBase.class)) {
                instance = Room.databaseBuilder(context, UserDataBase.class, "DATABASE").allowMainThreadQueries().build();
            }
        }
        return instance;
    }
}
