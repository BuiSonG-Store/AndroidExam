package com.example.androidexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText ed_Name,ed_Des,ed_Salary;
    Button btn_add,btn_delete,btn_update;
    AppData database;
    RecyclerView List_item ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_Name = findViewById(R.id.ed_name);
        ed_Des = findViewById(R.id.ed_des);
        ed_Salary = findViewById(R.id.ed_salary);
        List_item = findViewById(R.id.rcv_list);
        btn_add = findViewById(R.id.btn_add);
        btn_update = findViewById(R.id.btn_Update);
        btn_delete = findViewById(R.id.btn_delete);

        database = AppData.getAppDatabase(this);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAdd();
            }
        });

        List<Employee> list = database.employeeDao().getAll_employee();

        EmployeeAdapter adapter = new EmployeeAdapter(this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        List_item.setLayoutManager(layoutManager);
        List_item.setAdapter(adapter);

    }

    private void onAdd(){
        Toast.makeText(this,"Add",Toast.LENGTH_SHORT).show();
        Employee employee = new Employee();
        employee.name = ed_Name.getText().toString();
        employee.designation = ed_Des.getText().toString();
        employee.salary = ed_Salary.getText().toString();
        long id = database.employeeDao().insert_employee(employee);
        if (id>0){
            Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();
        }
    }

}