package com.example.myemployeeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText metemployee_id;
    private EditText metemployee_name;
    private EditText metemployee_phn_no;
    private EditText metdesignation;
    private EditText metemail_address;
    private String position_array_bloodgroup="";
    private Spinner spin_bloodgrp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        metemployee_id=findViewById(R.id.et_employee_id);
        metemployee_name=findViewById(R.id.et_employee_name);
        metemployee_phn_no=findViewById(R.id.et_phone_number);
        metdesignation=findViewById(R.id.et_designation);
        metemail_address=findViewById(R.id.et_email_address);

        spin_bloodgrp= findViewById(R.id.spinner_bloodgroup);
        String[] mbloodgroup= getResources().getStringArray(R.array.blood_group);
        ArrayAdapter<String> adapter_array=new ArrayAdapter<String>(MainActivity.this,R.layout.spinner_layout,R.id.spn_textview,mbloodgroup);
        spin_bloodgrp.setAdapter(adapter_array);
        spin_bloodgrp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position>0){
                     position_array_bloodgroup = mbloodgroup[position];

                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    public void EmployeeDetails(View view){
        String empid=metemployee_id.getText().toString();
        String empname=metemployee_name.getText().toString();
        long empphnno=!metemployee_phn_no.getText().toString().isEmpty()?Long.parseLong(metemployee_phn_no.getText().toString()):0;
        String empemail=metemail_address.getText().toString();
        String empdesignation=metdesignation.getText().toString();


        if(metemployee_id.getText().toString().trim().equalsIgnoreCase("")){
            metemployee_id.setError("Id cannot be empty");
        }
        else if(metemployee_name.getText().toString().trim().equalsIgnoreCase("")){
            metemployee_name.setError("Name cannot be empty");
        }
        else if(metemployee_phn_no.getText().toString().trim().equalsIgnoreCase("")){
            metemployee_phn_no.setError("Phone Number cannot be empty");
        }
        else if(metemail_address.getText().toString().trim().equalsIgnoreCase("")){
            metemail_address.setError("Email-Address cannot be empty");
        }
        else if(metdesignation.getText().toString().trim().equalsIgnoreCase("")){
            metdesignation.setError("Designation cannot be empty");
        }
        else if (position_array_bloodgroup.isEmpty()){
            Toast.makeText(MainActivity.this,"Select your blood group",Toast.LENGTH_SHORT).show();
        }

        else{
            Toast.makeText(MainActivity.this,"Employee Details Successfully Added",Toast.LENGTH_SHORT).show();
            Employee empdetails=new Employee();
            empdetails.Employee_Id=empid;
            empdetails.Employee_Name=empname;
            empdetails.Employee_Phone_Number=empphnno;
            empdetails.Employee_Email=empemail;
            empdetails.Employee_Designation=empdesignation;
            empdetails.Employee_Blood_Group=position_array_bloodgroup;
            Intent mintent=new Intent(MainActivity.this,HomeActivity.class);
            mintent.putExtra("EMPLOYEEDETAILS",empdetails);
            startActivity(mintent);
            metemployee_id.setText("");
            metemployee_name.setText("");
            metemployee_phn_no.setText("");
            metemail_address.setText("");
            metdesignation.setText("");
            spin_bloodgrp.setSelection(0);


        }








    }



}