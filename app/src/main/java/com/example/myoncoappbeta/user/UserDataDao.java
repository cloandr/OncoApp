package com.example.myoncoappbeta.user;

import java.util.List;

import androidx.room.Insert;
import androidx.room.Query;

public interface UserDataDao {
    @Insert
    void insertAll(UserData data);

    @Query("select * from UserData")
    List<UserData> getAllData();

    @Query("delete from UserData where 'key' = :id")
    void deleteData(int id);

    @Query("update UserData SET name = :name, last_name = :last_name, age= :age, ssn= :ssn, notes = :notes where 'key'=:key")
    void updateData(String name, String last_name, int age, String ssn, String notes, int key);
}
