package com.example.test3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class Dbhelper extends SQLiteOpenHelper {
    String DatabaseName = "EmpData.db";
    public Dbhelper(@Nullable Context context) {
        super(context, "EmpData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create Table Employee(Id integer primary key autoincrement , Emp_Name text , Emp_dept text , Emp_salary Integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("Drop Table if exists Employee");
    }
    public boolean Insertdata(String Emp_name , String Emp_dept , int Emp_salary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues inserted = new ContentValues();
        inserted.put("Emp_Name" , Emp_name);
        inserted.put("Emp_dept" , Emp_dept);
        inserted.put("Emp_salary" , Emp_salary);
        long result = db.insert("Employee", null , inserted);
        if (result > 0 ){
            return true;
        }
        else {
            return false;
        }
    }
    public ArrayList<HashMap<String , String>> fetchdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor getdata = db.rawQuery("Select Id, Emp_Name , Emp_dept , Emp_salary From Employee" , null);
        ArrayList<HashMap<String , String>> record = new ArrayList<>();
        while (getdata.moveToNext()){
            HashMap<String , String> coloumn = new HashMap<>();
            coloumn.put("Id" , getdata.getString(0));
            coloumn.put("Emp_Name" , getdata.getString(1));
            coloumn.put("Emp_dept" , getdata.getString(2));
            coloumn.put("Emp_salary" , getdata.getString(3));
            record.add(coloumn);
        }
        return record;
    }
    public Cursor fetchdata2(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * From Employee" , null);
        return cursor;
    }
}
