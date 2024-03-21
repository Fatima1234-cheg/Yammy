package com.example.yammy;



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

MyDB mbd= new MyDB(MainActivity2.this);

        Spinner spinner = findViewById(R.id.spinner123);

        // Créer un tableau de chaînes pour les éléments de la liste déroulante
        String[] items = {"Agadir", "Rabat", "Casablanca", "Marrakech", "Eljadida"};

        // Créer un adaptateur ArrayAdapter avec le tableau d'éléments et le layout par défaut
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);

        // Spécifier le layout à utiliser lorsque la liste déroulante est ouverte (dropdown layout)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Appliquer l'adaptateur au Spinner
        spinner.setAdapter(adapter);


        RadioButton radioButton1 = findViewById(R.id.radioButton1);
       RadioButton radioButton2 = findViewById(R.id.radioButton2);
       TextInputEditText EditEmail = findViewById(R.id.EditEmail);
       TextInputEditText EditPassword = findViewById(R.id.EditPassword);

        Button CrCompte = findViewById(R.id.CrCompte);

        CrCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String radioButtonValue = "";
                if (radioButton1.isChecked()) {
                    radioButtonValue = "Recruteur cherche des Cv et pose des annonces de travail";
                } else {
                    radioButtonValue = "Candidat cherche des annonces et pose des Cv";
                }

                String email = EditEmail.getText().toString();
                    String password = EditPassword.getText().toString();
                    String ville = spinner.getSelectedItem().toString();

                    // Ajouter l'utilisateur uniquement si l'email n'existe pas encore
                    mbd.ajouterUtilisatuer(radioButtonValue, email, ville, password);
                }
            });


    }
}