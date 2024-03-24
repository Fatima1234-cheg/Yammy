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

    public static boolean verifierUtilisateur(String email, String mot) { return true;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table utilisateurs(  RADIO_SELECTION  TexT,Email Text,Ville Text,Motdepasse text)");
        db.execSQL("Create table Annonces(  Titre  Text, Categorie Text, Secteur Text,Typedecontact Text,Description Text, Ville Text)");


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
    public void ajouterAnnonces(String Titre, String Categorie, String Secteur, String Typedecontact, String Description, String Ville) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Titre", Titre);
        values.put("Categorie", Categorie);
        values.put("Secteur", Secteur);
        values.put("typedecontact", Typedecontact);
        values.put("Description", Description);
        values.put("Ville", Ville);

        db.insert("Annonces", null, values);
        db.close();
    }


}



