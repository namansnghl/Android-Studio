package com.example.sqldemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.TextView;

public class displayDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);
        DbManager db = new DbManager(this);
        SQLiteDatabase database =  db.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM stud_info", new String[]{});

        if (cursor != null){
            cursor.moveToFirst();
        }

        StringBuilder builder = new StringBuilder();
        do{
            String name = cursor.getString(0);
            String reg_no = cursor.getString(1);
            String contact = cursor.getString(2);
            String email = cursor.getString(3);

            builder.append("\n\nName - "+name+"\nRegisteration ID - "+reg_no+"\nContact - "+contact+"\nMail ID - "+email);
        }while (cursor.moveToNext());

        TextView textView = (TextView)findViewById(R.id.displayData);
        textView.setText(builder.toString());
    }
}
