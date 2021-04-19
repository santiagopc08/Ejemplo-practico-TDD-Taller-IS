package com.example.metro;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static final String[] PERFILES = {"MECANICO", "CONDUCTOR", "COORDINADOR", "LIMPIEZA", "SUPERVISOR"};
    public static final Drawable[] imgsPerfil = new Drawable[5];
    public static final ArrayList<Empleado> EMPLEADOS = new ArrayList<>();
    Button btnVerPerfiles, btnVerEmpleados, btnBuscarEmpleado;

    public static void inicializarInfo() {

        EMPLEADOS.add(new Empleado("Juan", "Jaramillo", 2, 123));
        EMPLEADOS.add(new Empleado("Alberto", "Suárez", 1, 456));
        EMPLEADOS.add(new Empleado("Lina", "Martínez", 0, 789));

        EMPLEADOS.get(1).getHistJornadas().add(new Jornada(Calendar.getInstance(), 5, 13));

        EMPLEADOS.get(1).getHistJornadas().add(new Jornada(Calendar.getInstance(), 14, 22));

        EMPLEADOS.get(1).getHistJornadas().add(new Jornada(Calendar.getInstance(), 14, 22));
        EMPLEADOS.get(1).getHistJornadas().get(0).getFecha().set(Calendar.DAY_OF_MONTH, 1);
        EMPLEADOS.get(1).getHistJornadas().get(1).getFecha().set(Calendar.DAY_OF_MONTH, 3);
        EMPLEADOS.get(1).getHistJornadas().get(2).getFecha().set(Calendar.DAY_OF_MONTH, 5);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuscarEmpleado = findViewById(R.id.btnBuscarEmpleado);
        btnVerPerfiles = findViewById(R.id.btnVerPerfiles);
        btnVerEmpleados = findViewById(R.id.btnVerEmpleados);

        imgsPerfil[0] = getApplicationContext().getDrawable(R.drawable.mechanic);
        imgsPerfil[1] = getApplicationContext().getDrawable(R.drawable.driver);
        imgsPerfil[2] = getApplicationContext().getDrawable(R.drawable.coordinator);
        imgsPerfil[3] = getApplicationContext().getDrawable(R.drawable.household);
        imgsPerfil[4] = getApplicationContext().getDrawable(R.drawable.engineer);

        inicializarInfo();

        verPerfiles();
        buscarEmpleado();
        verEmpleados();
    }

    private void verEmpleados() {
        btnVerEmpleados.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), ListaEmpleadosActivity.class));
        });
    }

    private void buscarEmpleado() {
        btnBuscarEmpleado.setOnClickListener((view) -> {
            startActivity(new Intent(getApplicationContext(), BuscarEmpleadoActivity.class));
        });
    }

    private void verPerfiles() {
        btnVerPerfiles.setOnClickListener((view) -> {
            startActivity(new Intent(getApplicationContext(), ListaPerfilesActivity.class));
        });
    }
}