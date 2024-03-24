package com.example.yammy;



import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        //création de base des donnes

MyDB mbd= new MyDB(MainActivity2.this);

//création d'une liste déroulante pour ville

        Spinner spinner = findViewById(R.id.spinner123);

        String[] items = {"Agadir", "Rabat", "Casablanca", "Marrakech", "Eljadida"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        RadioButton radioButton1 = findViewById(R.id.radioButton1);
       RadioButton radioButton2 = findViewById(R.id.radioButton2);
       TextInputEditText EditEmail = findViewById(R.id.EditEmail);
       TextInputEditText EditPassword = findViewById(R.id.EditPassword);

        Button CrCompte = findViewById(R.id.CrCompte);

        CrCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it2=new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(it2);

                String radioButtonValue = "";
                if (radioButton1.isChecked()) {
                    radioButtonValue = "Recruteur cherche des Cv et pose des annonces de travail";
                } else {
                    radioButtonValue = "Candidat cherche des annonces et pose des Cv";
                }
                
                String email = EditEmail.getText().toString();
                String password = EditPassword.getText().toString();
                String ville = spinner.getSelectedItem().toString();

                 //ajouter les données a la base des données
                    mbd.ajouterUtilisatuer(radioButtonValue, email, ville, password);

                }
            });


    }
}