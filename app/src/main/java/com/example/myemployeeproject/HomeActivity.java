package com.example.myemployeeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private TextView mtvempid;
    private TextView mtvempname;
    private TextView mtvempemail;
    private TextView mtvempphoneno;
    private TextView mtvempdesignation;
    private TextView mtvempbloodgroup;

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

        Bundle data=getIntent().getExtras();
        Employee details=(Employee) data.getSerializable("EMPLOYEEDETAILS");
        mtvempid.setText(details.Employee_Id);
        mtvempname.setText(details.Employee_Name);
        mtvempemail.setText(details.Employee_Email);
        mtvempphoneno.setText(String.valueOf(details.Employee_Phone_Number));
        mtvempdesignation.setText(details.Employee_Designation);
        mtvempbloodgroup.setText(details.Employee_Blood_Group);


       // Toast.makeText(HomeActivity.this,details.Employee_Id,Toast.LENGTH_SHORT).show();
      //  Toast.makeText(HomeActivity.this,details.Employee_Name,Toast.LENGTH_SHORT).show();
     //   Toast.makeText(HomeActivity.this,String.valueOf(details.Employee_Phone_Number),Toast.LENGTH_SHORT).show();
      //  Toast.makeText(HomeActivity.this,details.Employee_Email,Toast.LENGTH_SHORT).show();
      //  Toast.makeText(HomeActivity.this,details.Employee_Designation,Toast.LENGTH_SHORT).show();
    }
}