package com.example.metro;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListaEmpleadosActivity extends AppCompatActivity {

    ListView lstEmpleados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_empleados);

        lstEmpleados = findViewById(R.id.lstEmpleados);
        EmpleadosAdapter adapter = new EmpleadosAdapter(getApplicationContext());
        lstEmpleados.setAdapter(adapter);
    }
}