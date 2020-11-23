package com.example.myemployeeproject;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int Version=1;

    private static final String TABLE_NAME="employee_info";

    private static final String COL_ID="id";
    private static final String COL_EMPLOYEE_ID="employee_id";
    private static final String COL_EMPLOYEE_NAME="employee_name";
    private static final String COL_EMPLOYEE_EMAIL="employee_email";
    private static final String COL_EMPLOYEE_MOB="employee_mob";
    private static final String COL_EMPLOYEE_DEGN="employee_degn";
    private static final String COL_EMPLOYEE_BLOOD="employee_blood";

    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+ "("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_EMPLOYEE_ID+" TEXT,"+COL_EMPLOYEE_NAME+" TEXT,"
            +COL_EMPLOYEE_EMAIL+" TEXT,"+COL_EMPLOYEE_MOB+" INTEGER,"+COL_EMPLOYEE_DEGN+" TEXT,"+COL_EMPLOYEE_BLOOD+" TEXT)";

    public DatabaseHelper(@Nullable Context context){
        super(context,"employee.db",null, Version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void InsertDetailsIntoDatabase(SQLiteDatabase db,Employee employee){
        ContentValues cv=new ContentValues();
        cv.put(COL_EMPLOYEE_ID,employee.Employee_Id);
        cv.put(COL_EMPLOYEE_NAME,employee.Employee_Name);
        cv.put(COL_EMPLOYEE_EMAIL,employee.Employee_Email);
        cv.put(COL_EMPLOYEE_MOB,employee.Employee_Phone_Number);
        cv.put(COL_EMPLOYEE_DEGN,employee.Employee_Designation);
        cv.put(COL_EMPLOYEE_BLOOD,employee.Employee_Blood_Group);

        long values=db.insert(TABLE_NAME,null,cv);
        Log.i("DATABASE VALUES",String.valueOf(values));
    }
    public ArrayList<Employee> DeleteDatabaseDetails(SQLiteDatabase dbm){
        ArrayList<Employee> emloyeelist=new ArrayList<Employee>();
        Cursor cursor=dbm.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        if (cursor.moveToFirst()){
            do {
                Employee empdelete= new Employee();
                empdelete.id=cursor.getInt(cursor.getColumnIndex(COL_ID));
                empdelete.Employee_Id=cursor.getString(cursor.getColumnIndex(COL_EMPLOYEE_ID));
                empdelete.Employee_Email=cursor.getString(cursor.getColumnIndex(COL_EMPLOYEE_EMAIL));
                empdelete.Employee_Name=cursor.getString(cursor.getColumnIndex(COL_EMPLOYEE_NAME));
                empdelete.Employee_Phone_Number=cursor.getInt(cursor.getColumnIndex(COL_EMPLOYEE_MOB));
                empdelete.Employee_Blood_Group=cursor.getString(cursor.getColumnIndex(COL_EMPLOYEE_BLOOD));
                empdelete.Employee_Designation=cursor.getString(cursor.getColumnIndex(COL_EMPLOYEE_DEGN));

                emloyeelist.add(empdelete);

            }while (cursor.moveToNext());
        }

        return emloyeelist;
    }

}
