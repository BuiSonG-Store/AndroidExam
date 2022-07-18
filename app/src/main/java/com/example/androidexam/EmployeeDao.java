package com.example.androidexam;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Insert(onConflict = REPLACE)
    long insert_employee(Employee employee);
    @Update
    int update_employee(Employee user);
    @Delete
    int delete_employee(Employee user);
    @Query("SELECT * FROM employee")
    List<Employee> getAll_employee();
    @Query("SELECT * FROM employee WHERE id = :id")
    Employee find_employee(int id);
}
