package com.example.myoncoappbeta.treatment;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TreatmentDao {

    /**
     * Requête sql pour accéder et manipuler la base de données pour la table tratment
     */

    @Insert
    public void addTreatment(TreatmentModel treatmentModel);

    @Query("select * from treatment")
    List<TreatmentModel> getTreatment();

    @Query("delete from treatment where 'key'=:id")
    void deleteData(int id);

    @Query("update treatment SET title = :title, mode = :mode, dose =:dose, unit = :unit, start = :start, endate = :endate, freq1 = :freq1, freq2 = :freq2, freq3 = :freq3 where 'key '= :key")
    void updateData(String title,String mode, String dose, String unit, String start, String endate, String freq1, String freq2, String freq3, int key);

}
