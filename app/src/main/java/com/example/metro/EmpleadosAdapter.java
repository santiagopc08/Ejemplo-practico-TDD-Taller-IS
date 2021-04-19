package com.example.metro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EmpleadosAdapter extends BaseAdapter {

    Context context;

    public EmpleadosAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return MainActivity.EMPLEADOS.size();
    }

    @Override
    public Object getItem(int position) {
        return MainActivity.EMPLEADOS.get(position);
    }

    @Override
    public long getItemId(int position) {
        return MainActivity.EMPLEADOS.get(position).getCedula();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.empleado_row, parent, false);

        ImageView imgPerfil = view.findViewById(R.id.imgEmpleadoRow);
        TextView tvNombre = view.findViewById(R.id.tvNombreEmpleadoRow), tvApellido = view.findViewById(R.id.tvApellidoEmpleadoRow),
                tvPerfil = view.findViewById(R.id.tvPerfilEmpleadoRow), tvCedula = view.findViewById(R.id.tvCedulaEmpleadoRow);

        Empleado empleado = MainActivity.EMPLEADOS.get(position);
        imgPerfil.setImageDrawable(MainActivity.imgsPerfil[empleado.getPerfil()]);
        tvPerfil.setText(MainActivity.PERFILES[empleado.getPerfil()]);
        tvNombre.setText(empleado.getNombre());
        tvApellido.setText(empleado.getApellido());
        tvCedula.setText("" + empleado.getCedula());
        return view;
    }
}
