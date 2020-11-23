package com.example.myemployeeproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder> {
    private Context context;
    private ArrayList<Employee> employeeList;

    public EmployeeAdapter(Context context,ArrayList<Employee> employeeList){
        this.context=context;
        this.employeeList=employeeList;
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EmployeeHolder emplist=new EmployeeHolder(LayoutInflater.from(context).inflate(R.layout.add_data_files,parent,false));
        return emplist;
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
       Employee empholder=employeeList.get(position);

       holder.mtvempid.setText(empholder.Employee_Id);
       holder.mtvempname.setText(empholder.Employee_Name);
       holder.mtvempemail.setText(empholder.Employee_Email);
       holder.mtvempphn.setText(String.valueOf(empholder.Employee_Phone_Number));
       holder.mtvempdegn.setText(empholder.Employee_Designation);
       holder.mtvempbloodgrp.setText(empholder.Employee_Blood_Group);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class EmployeeHolder extends RecyclerView.ViewHolder {
        private TextView mtvempid;
        private TextView mtvempname;
        private TextView mtvempemail;
        private TextView mtvempphn;
        private TextView mtvempdegn;
        private TextView mtvempbloodgrp;

        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            mtvempid=itemView.findViewById(R.id.tv_empid);
            mtvempname=itemView.findViewById(R.id.tv_empname);
            mtvempemail=itemView.findViewById(R.id.tv_empemail);
            mtvempphn=itemView.findViewById(R.id.tv_empphnno);
            mtvempdegn=itemView.findViewById(R.id.tv_empdesignation);
            mtvempbloodgrp=itemView.findViewById(R.id.tv_empbloodgrp);
        }
    }
}
