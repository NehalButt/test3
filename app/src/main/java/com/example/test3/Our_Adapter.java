package com.example.test3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Our_Adapter extends BaseAdapter {
    Context context;
    ArrayList<Employee> mydata;
    LayoutInflater Ourlayout;

    public Our_Adapter(Context context, ArrayList<Employee> mydata) {
        this.context = context;
        this.mydata = mydata;
        Ourlayout = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = Ourlayout.inflate(R.layout.mytablayout , null);
        TextView Id = view.findViewById(R.id.Myid);
        TextView Name = view.findViewById(R.id.Myname);
        TextView Dept = view.findViewById(R.id.Mydept);
        TextView Salary = view.findViewById(R.id.Mysalary);
        Employee data = mydata.get(i);
        Id.setText(data.Emp_Name);
        Name.setText(data.Emp_dept);
        Dept.setText(data.Emp_dept);
        Salary.setText(data.Emp_salary);
        return view;
    }
}
