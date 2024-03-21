package com.example.yammy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.database.Cursor;
public class MyDB extends SQLiteOpenHelper {
    public MyDB(Context context) {
        super(context, "inscriptionUtilisateur.db", null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table utilisateurs(  RADIO_SELECTION  TexT,Email Text,Ville Text,Motdepasse text)");


    }

    EditText txt1;

    public EditText getTxt1() {
        return txt1;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public void ajouterUtilisatuer(String RadioButtonValue, String Email, String Ville, String Password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(" RADIO_SELECTION", RadioButtonValue);
        values.put("Email", Email);
        values.put("Ville", Ville);
        values.put("Motdepasse", Password);
        db.insert("utilisateurs", null, values);
        db.close();
    }

}



