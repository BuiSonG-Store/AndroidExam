package com.example.androidexam;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Employee.class},version = 1)
    public abstract class AppData extends RoomDatabase {
        private static AppData appDatabase;
        public abstract EmployeeDao employeeDao();

        public static AppData getAppDatabase(Context context){
            if (appDatabase == null){
                appDatabase = Room.databaseBuilder(context, AppData.class,"employee.db").allowMainThreadQueries().build();
            }
            return appDatabase;
        }}
