package com.example.sqldemoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbManager extends SQLiteOpenHelper {

    private static final String dbname="Student.db";
    public DbManager(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "create table stud_info (name text, reg_no varchar(7) primary key, contact varchar(10), email text)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS stud_info");
        onCreate(db);
    }

    public String addRecord(String name, String reg_no, String contact, String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("reg_no", reg_no);
        cv.put("contact", contact);
        cv.put("email", email);

        long res = db.insert("stud_info",null, cv);
        if (res==-1){
            return "Failed";
        }
        else{
            return "Successfully Submitted";
        }
    }

    public String deleteRecords(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ "stud_info");
        db.execSQL("vacuum");
        return "Deleted all Records successfully";
    }
}
