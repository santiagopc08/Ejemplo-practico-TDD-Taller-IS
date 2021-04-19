package com.example.metro;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaPerfilesActivity extends AppCompatActivity {

    ListView lstPerfiles;
    //      Tipo    Descripcion
    ArrayList<String> perfiles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_perfiles_avticity);

        lstPerfiles = findViewById(R.id.lstPerfiles);
        perfiles.add("Este es el perfil de un mécanico, que se encarga de hacer las cosas que hacen los mecánicos.");
        perfiles.add("El conductor se encarga de conducir.");
        perfiles.add("El coordinador coordina todo lo que se tenga que coordinar.");
        perfiles.add("El encargado de la limpieza hace que todo esté reluciente.");
        perfiles.add("El supervisor mira con sus ojos.");

        PerfilesAdapter adapter = new PerfilesAdapter(perfiles, getApplicationContext());
        lstPerfiles.setAdapter(adapter);
    }
}