package com.example.yammy;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputEditText;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
         MyDB mbd3 = new MyDB(MainActivity3.this);

        Spinner spinner1 = findViewById(R.id.spinnercat);
        Spinner spinner2 = findViewById(R.id.spinnersectuer);
        Spinner spinner3 = findViewById(R.id.spinnerville);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.cat, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.secteur, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.ville, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);

        Button suivant = findViewById(R.id.Suivant);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Code à exécuter lors de la sélection d'un élément dans le spinner 1
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Récupération des données des champs
                Intent it3 = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(it3);
                TextInputEditText titre = findViewById(R.id.Titre);
                TextInputEditText typeDeContact = findViewById(R.id.Typedecontact);
                TextInputEditText description = findViewById(R.id.Description);

                String titre1 = titre.getText().toString();
                String typeDeContact1 = typeDeContact.getText().toString();
                String description1 = description.getText().toString();
                String ville1 = spinner3.getSelectedItem().toString();
                String categorie1 = spinner1.getSelectedItem().toString();
                String secteur1 = spinner2.getSelectedItem().toString();
                mbd3.ajouterAnnonces(titre1, categorie1, secteur1, typeDeContact1, description1, ville1);
            }

        });


}}



