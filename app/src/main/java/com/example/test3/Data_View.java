package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Data_View extends AppCompatActivity {
    ListView mylist;
    Dbhelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__view);
        mylist = (ListView) findViewById(R.id.Mylist);
        dbhelper = new Dbhelper(Data_View.this);
        ArrayList<HashMap<String , String>> datarecive = dbhelper.fetchdata();
        ListAdapter adapter = new SimpleAdapter(this , datarecive , R.layout.customlayout ,  new String[]{"Id" , "Emp_Name" , "Emp_dept" , "Emp_salary"} , new int[]{R.id.Editid , R.id.Editname , R.id.Editdept , R.id.Editsalary});
        mylist.setAdapter(adapter);
    }
}