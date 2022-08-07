package com.example.myoncoappbeta;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import static com.example.myoncoappbeta.BuildConfig.VERSION_CODE;

import com.example.myoncoappbeta.appointment.AppointmentDao;
import com.example.myoncoappbeta.appointment.AppointmentModel;
import com.example.myoncoappbeta.contact.ContactDao;
import com.example.myoncoappbeta.contact.ContactModel;
import com.example.myoncoappbeta.treatment.TreatmentDao;
import com.example.myoncoappbeta.treatment.TreatmentModel;

@Database(entities = {AppointmentModel.class, ContactModel.class, TreatmentModel.class}, version = VERSION_CODE, exportSchema = false)
public abstract class MyAppDatabseClass extends RoomDatabase {

    /**
     * Création de la base de données
     * */
    private static MyAppDatabseClass instance;

    public abstract AppointmentDao getAppointmentDao();

    public abstract ContactDao getContactDao();

    public abstract TreatmentDao getTreatmentDao();

    static MyAppDatabseClass getDatabase(final Context context) {
        if (instance == null) {
            synchronized (MyAppDatabseClass.class) {
                instance = Room.databaseBuilder(context, MyAppDatabseClass.class, "DATABASE").allowMainThreadQueries().build();
            }
        }
        return instance;


    }




}
