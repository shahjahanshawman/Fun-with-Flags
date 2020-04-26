package com.example.assignment;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Results.class}, version = 1)
public abstract class AchievementDatabase extends RoomDatabase {
    public abstract AchievementDAO achievementDAO();
}
