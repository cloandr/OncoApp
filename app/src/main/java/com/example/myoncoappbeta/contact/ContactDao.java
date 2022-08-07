package com.example.myoncoappbeta.contact;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ContactDao {

    /**
     * Requête sql pour accéder et manipuler la base de données pour la table contact
     */
    @Insert
    void addContact(ContactModel model);

    @Query("select * from contact")
    List<ContactModel> getContact();

    @Query("delete from contact where 'key' = :id")
    void deleteData(int id);

    @Query("update contact SET firstname = :firstname, lastname = :lastname, speciality = :speciality, phone =:phone, mail=:mail where 'key'=:key")
    void updateData(String firstname, String lastname, String speciality, String phone, String mail, int key);



}
