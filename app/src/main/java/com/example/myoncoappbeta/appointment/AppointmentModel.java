package com.example.myoncoappbeta.appointment;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "appointment")

public class AppointmentModel {

    /**
     *  paramétratage de la table et de ces colonnes pour les rdv
     */
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int key;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "doctor_name")
    private String doctor_name;

    @ColumnInfo(name = "starting_date")
    private String starting_date;

    @ColumnInfo(name = "hour")
    private String hour;

    @ColumnInfo(name = "rdv_type")
    private String rdv_type;


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(String starting_date) {
        this.starting_date = starting_date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getRdv_type() {
        return rdv_type;
    }

    public void setRdv_type(String rdv_type) {
        this.rdv_type = rdv_type;
    }

}
