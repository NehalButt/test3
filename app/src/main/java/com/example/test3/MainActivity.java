package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Emp_name , Emp_dept , Emp_salary;
    Button Save , View;
    Dbhelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Emp_name = (EditText) findViewById(R.id.Emp_Name);
        Emp_dept = (EditText) findViewById(R.id.Emp_dept);
        Emp_salary = (EditText) findViewById(R.id.Emp_salary);
        Save = (Button) findViewById(R.id.Save);
        View = (Button) findViewById(R.id.View);
        dbhelper = new Dbhelper(MainActivity.this);


        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                String empname = Emp_name.getText().toString();
                String empdept = Emp_dept.getText().toString();
                int empsalary = Integer.parseInt(Emp_salary.getText().toString());
                if (empsalary < 20000) {
                    Emp_salary.requestFocus();
                    Emp_salary.setError("Salary must be 20,000");
                } else if (empsalary > 50000) {
                    Emp_salary.requestFocus();
                    Emp_salary.setError("Salary must be 100,000");
                } else {
                    boolean sucess = dbhelper.Insertdata(empname, empdept, empsalary);
                    if (sucess == true) {
                        Toast.makeText(MainActivity.this, "Data Inserted Sucessfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        View.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(android.view.View view) {
            Intent intent = new Intent(MainActivity.this , Data_View.class);
            startActivity(intent);
        }
        });
    }
}