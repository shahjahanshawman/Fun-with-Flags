package com.example.assignment;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ResultsDAO {

    @Query("Select * FROM Results")
    List<Results> getScores();

    @Query("Select Count(*) FROM Results")
    int getCount();

    @Insert
    void insert(Results scores);

    @Query("Delete  From  Results Where level =:level")
    void deleteScores(int level);

}


