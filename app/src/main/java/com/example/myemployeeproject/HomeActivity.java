package com.example.myemployeeproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private TextView mtvempid;
    private TextView mtvempname;
    private TextView mtvempemail;
    private TextView mtvempphoneno;
    private TextView mtvempdesignation;
    private TextView mtvempbloodgroup;
    private DatabaseHelper dbHelper;
    private RecyclerView reCView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mtvempid=findViewById(R.id.tv_empid);
        mtvempname=findViewById(R.id.tv_empname);
        mtvempemail=findViewById(R.id.tv_empemail);
        mtvempphoneno=findViewById(R.id.tv_empphnno);
        mtvempdesignation=findViewById(R.id.tv_empdesignation);
        mtvempbloodgroup=findViewById(R.id.tv_empbloodgrp);


       // Bundle data=getIntent().getExtras();
      //  Employee details=(Employee) data.getSerializable("EMPLOYEEDETAILS");
      //  mtvempid.setText(details.Employee_Id);
      //  mtvempname.setText(details.Employee_Name);
      //  mtvempemail.setText(details.Employee_Email);
      //  mtvempphoneno.setText(String.valueOf(details.Employee_Phone_Number));
      //  mtvempdesignation.setText(details.Employee_Designation);
      //  mtvempbloodgroup.setText(details.Employee_Blood_Group);
        reCView=findViewById(R.id.recycler_view_employeeList);
        reCView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        dbHelper=new DatabaseHelper(HomeActivity.this);
        SetAdapter();
    }

    private void SetAdapter(){
        ArrayList<Employee> employeeList=dbHelper.DeleteDatabaseDetails(dbHelper.getReadableDatabase());
        EmployeeAdapter employeeadapter=new EmployeeAdapter(HomeActivity.this,employeeList);
        reCView.setAdapter(employeeadapter);
    }
    public void floatingbutton(View view){
        startActivityForResult(new Intent(HomeActivity.this,MainActivity.class),101);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode== Activity.RESULT_OK && requestCode==101){
           SetAdapter();
        }
    }
}