package com.example.myoncoappbeta.treatment;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "treatment")
public class TreatmentModel {

    /**
     *  paramétratage de la table et de ces colonnes pour les traitements
     */
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int key;

    @ColumnInfo(name="title")
    private String title;

    @ColumnInfo(name = "mode")
    private String mode;

    @ColumnInfo(name = "dose")
    private String dose;

    @ColumnInfo(name="unit")
    private String unit;

    @ColumnInfo(name="start")
    private String start;

    @ColumnInfo(name="endate")
    private String endate;



    @ColumnInfo(name = "freq1")
    private String freq1;

    @ColumnInfo(name = "freq2")
    private String freq2;

    @ColumnInfo(name = "freq3")
    private String freq3;

    //accesseurs de la table

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

    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }



    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEndate() {
        return endate;
    }

    public void setEndate(String endate) {
        this.endate = endate;
    }

    public String getFreq1() {
        return freq1;
    }

    public void setFreq1(String freq1) {
        this.freq1 = freq1;
    }

    public String getFreq2() {
        return freq2;
    }

    public void setFreq2(String freq2) {
        this.freq2 = freq2;
    }

    public String getFreq3() {
        return freq3;
    }

    public void setFreq3(String freq3) {
        this.freq3 = freq3;
    }
}
