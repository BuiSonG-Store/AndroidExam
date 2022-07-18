package com.example.androidexam;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "employee")
public class Employee {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "designation")
    public String designation;
    @ColumnInfo(name = "salary")
    public int salary;
}
