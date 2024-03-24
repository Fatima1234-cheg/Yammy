package com.example.yammy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;

import com.google.android.material.textfield.TextInputEditText;
import com.example.yammy.MyDB;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
  Button Insp;
        Insp=findViewById(R.id.Insp);
        MyDB myDB = new MyDB(this); // Crée une instance de votre classe MyDB
        SQLiteDatabase db = myDB.getReadableDatabase();

        Button btncnx ;
        btncnx= findViewById(R.id.btncnx);

        btncnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1= new Intent( MainActivity.this,MainActivity3.class);
                startActivity(it1);

            }


        }
        );

        Insp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent( MainActivity.this,MainActivity2.class);
                startActivity(it);

            }
        });




    }
}