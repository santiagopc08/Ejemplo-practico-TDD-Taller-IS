package com.example.metro;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class JornadaAdapter extends BaseAdapter {
    Context context;
    ArrayList<Jornada> jornadas;

    public JornadaAdapter(Context context, ArrayList<Jornada> jornadas) {
        this.context = context;
        this.jornadas = jornadas;
    }

    @Override
    public int getCount() {
        return jornadas.size();
    }

    @Override
    public Object getItem(int position) {
        return jornadas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.jornada_row, parent, false);

        TextView tvHoraInicio, tvHoraFin, tvFecha;
        tvHoraInicio = view.findViewById(R.id.tvHoraInicioJornadaRow);
        tvHoraFin = view.findViewById(R.id.tvHoraFinJornadaRow);
        tvFecha = view.findViewById(R.id.tvFechaJornadaRow);

        tvHoraFin.setText("" + jornadas.get(position).gethFin());
        Calendar c = jornadas.get(position).getFecha();
        Log.i("TAG", "onCreate: " + c.get(Calendar.DAY_OF_MONTH));
        tvFecha.setText(c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DAY_OF_MONTH));
        tvHoraInicio.setText("" + jornadas.get(position).gethIni());
        return view;
    }
}
