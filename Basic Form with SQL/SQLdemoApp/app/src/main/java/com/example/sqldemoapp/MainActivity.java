package com.example.sqldemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button insert;
    EditText t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        t1 = (EditText)findViewById(R.id.name);
        t2 = (EditText)findViewById(R.id.regno);
        t3 = (EditText)findViewById(R.id.contact);
        t4 = (EditText)findViewById(R.id.email);
        insert = (Button)findViewById(R.id.button2);
    }

    public void startdbapp(View view)
    {
        //new DbManager(this);
        if(t1.length()==0){
            t1.setError("Fill this Blank");
        }
        else if(t2.length()==0){
            t2.setError("Fill this Blank");
        }
        else if(t3.length()==0){
            t3.setError("Fill this Blank");
        }
        else if(t4.length()==0){
            t4.setError("Fill this Blank");
        }
        else{
            DbManager db = new DbManager(this);
            String res = db.addRecord(t1.getText().toString(), t2.getText().toString(), t3.getText().toString(), t4.getText().toString());
            Toast.makeText(this, res, Toast.LENGTH_LONG).show();

            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
        }


    }

    public void goToDisplay (View view){
        Intent intent = new Intent (this, displayDetails.class);
        startActivity(intent);
    }

    public void deleteTable (View view){
        DbManager db = new DbManager(this);
        String res = db.deleteRecords();
        Toast.makeText(this, res, Toast.LENGTH_LONG).show();

        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
    }

    }
