package com.example.myoncoappbeta.user;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class UserData {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int key;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "last_name")
    private String last_name;

    @ColumnInfo(name = "age")
    private int age;

    @ColumnInfo(name = "ssn") //ssn -> social_security_number
    private String ssn;

    @ColumnInfo(name = "notes")
    private String notes;

    public int getKey() {
        return key;
    }

    public void setKey(int k) {
        this.key = k;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.last_name = n;
    }

    public String getLast_name () {
        return last_name;
    }

    public void setLast_name(String p) {
        this.last_name = p;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int a) {
        this.age = a;
    }

    public String getSsn () {
        return ssn;
    }

    public void setSsn(String num) {
        this.ssn = num;
    }

    public String getNotes () {
        return notes;
    }

    public void setNotes(String comm) {
        this.notes = comm;
    }
}
