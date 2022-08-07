package com.example.myoncoappbeta.appointment;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface AppointmentDao {
    /**
     * Requête sql pour accéder et manipuler la base de données pour la table appointment
     */
    @Insert
    void addAppointment(AppointmentModel model);

    @Query("select * from appointment")
    public List<AppointmentModel> getAppointment();

    @Query("delete from appointment where 'key' = :id")
    void deleteData(int id);

    @Query("update appointment SET title = :title, doctor_name = :doctor_name,  starting_date = :starting_date, hour = :hour, rdv_type = :rdv_type where 'key'=:key")
    void updateData(String title, String doctor_name, String starting_date, String hour, String rdv_type,  int key);
}
