package com.example.test3;

public class Employee {
    String Id;
    String Emp_Name;
    String Emp_dept;
    String Emp_salary;

    public Employee(String id, String emp_Name, String emp_dept, String emp_salary) {
        Id = id;
        Emp_Name = emp_Name;
        Emp_dept = emp_dept;
        Emp_salary = emp_salary;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getEmp_Name() {
        return Emp_Name;
    }

    public void setEmp_Name(String emp_Name) {
        Emp_Name = emp_Name;
    }

    public String getEmp_dept() {
        return Emp_dept;
    }

    public void setEmp_dept(String emp_dept) {
        Emp_dept = emp_dept;
    }

    public String getEmp_salary() {
        return Emp_salary;
    }

    public void setEmp_salary(String emp_salary) {
        Emp_salary = emp_salary;
    }
}
