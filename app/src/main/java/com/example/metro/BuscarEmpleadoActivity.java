package com.example.metro;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class BuscarEmpleadoActivity extends AppCompatActivity {

    static Empleado empleadoActual;
    static Calendar calendar = Calendar.getInstance();
    EditText txtCedula, txtFecha;
    Button btnBuscar, btnBuscarJornada;
    TextView tvPerfil, tvNombre, tvApellido, tvCedula;
    ConstraintLayout busquedaContainer, perfilContainer;
    ImageView imgPerfil;
    ListView lstJornadas;

    public static ArrayList<Jornada> encontrarJornada(String fecha) {
        ArrayList<Jornada> jornadas = new ArrayList<>();
        if (fecha.length() > 1) {
            for (Jornada jornada : empleadoActual.getHistJornadas()) {
                if (jornada.getFecha().get(Calendar.YEAR) == calendar.get(Calendar.YEAR) &&
                        jornada.getFecha().get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                        jornada.getFecha().get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)) {
                    jornadas.add(jornada);
                }
            }
        } else {
            jornadas = empleadoActual.getHistJornadas();
        }
        return jornadas;
    }

    public static Empleado buscarEmpleado(int cedula) {
        for (Empleado empleado : MainActivity.EMPLEADOS) {
            if (empleado.getCedula() == cedula) {
                return empleado;
            }
        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_empleado);

        txtCedula = findViewById(R.id.txtCedulaBuscar);
        btnBuscar = findViewById(R.id.btnBuscar);
        tvPerfil = findViewById(R.id.tvTipoPerfil);
        tvNombre = findViewById(R.id.tvNombreBuscar);
        tvApellido = findViewById(R.id.tvApellidoBuscar);
        tvCedula = findViewById(R.id.tvCedulaBuscar);
        busquedaContainer = findViewById(R.id.buscarEmpleadoContainer);
        perfilContainer = findViewById(R.id.perfilEmpleadoContainer);
        imgPerfil = findViewById(R.id.imgPerfilBuscar);
        txtFecha = findViewById(R.id.txtFecha);
        btnBuscarJornada = findViewById(R.id.btnBuscarJornadas);
        lstJornadas = findViewById(R.id.lstJornadas);

        btnBuscar.setOnClickListener((v -> {
            buscar();
        }));

        btnBuscarJornada.setOnClickListener(v -> {
            buscarJornada();
        });

        seleccionarFecha();
    }

    private void seleccionarFecha() {
        txtFecha.setOnClickListener(v -> {
            obtenerFecha(txtFecha);
        });
    }

    private void obtenerFecha(EditText txtFecha) {
        DatePickerDialog.OnDateSetListener fechaSeleccionadaListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

                txtFecha.setText(format.format(calendar.getTime()));
            }
        };

        new DatePickerDialog(BuscarEmpleadoActivity.this, fechaSeleccionadaListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void buscarJornada() {
        ArrayList<Jornada> jornadas = encontrarJornada(txtFecha.getText().toString());
        JornadaAdapter adapter = new JornadaAdapter(getApplicationContext(), jornadas);
        lstJornadas.setAdapter(adapter);
    }

    private void buscar() {
        String cedula = txtCedula.getText().toString();
        if (cedula.length() > 0) {
            empleadoActual = buscarEmpleado(Integer.parseInt(cedula));
            if (empleadoActual != null) {
                perfilContainer.setVisibility(View.VISIBLE);
                busquedaContainer.setVisibility(View.GONE);
                imgPerfil.setImageDrawable(MainActivity.imgsPerfil[empleadoActual.getPerfil()]);
                tvPerfil.setText(MainActivity.PERFILES[empleadoActual.getPerfil()]);
                tvNombre.setText(empleadoActual.getNombre());
                tvApellido.setText(empleadoActual.getApellido());
                tvCedula.setText(empleadoActual.getCedula() + "");
            } else {
                Toast.makeText(getApplicationContext(), "El empleado no se encontró.", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Debe ingresar la cedula.", Toast.LENGTH_SHORT).show();
        }
    }
}