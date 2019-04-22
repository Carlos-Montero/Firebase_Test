package com.example.carlos.firebase_test.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import java.util.List;

/*
Drug DAO Interface.
Acts is an intermediary between the user and the database.
All operations are difined below.
 */

@Dao
public interface DrugDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long save(Drug drug);

    //@Query("DELETE FROM drugs")
    //void deleteAllUsers();

    @Delete
    void deleteDrug(Drug drug);

    @Query("SELECT * from drugs ORDER BY id ASC")
    List<Drug> getAllDrugs();

    @Query("SELECT * from drugs ORDER BY id ASC")
    LiveData<List<Drug>> getAllDrugsLive();

    @Query("SELECT * from drugs WHERE id = :drugId")
    List<Drug> getDrugById(String drugId);


}
