package com.example.metro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PerfilesAdapter extends BaseAdapter {
    ArrayList<String> perfiles;
    Context context;

    public PerfilesAdapter(ArrayList perfiles, Context context) {
        this.perfiles = perfiles;
        this.context = context;
    }

    @Override
    public int getCount() {
        return perfiles.size();
    }

    @Override
    public Object getItem(int position) {
        return perfiles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.perfil_row, parent, false);

        ImageView imgPerfil = view.findViewById(R.id.imgPerfilRow);
        TextView tvTipo = view.findViewById(R.id.tvTipoPerfilRow);
        TextView tvDescripcion = view.findViewById(R.id.tvDescripcionPerfilRow);

        tvTipo.setText(MainActivity.PERFILES[position]);
        tvDescripcion.setText(perfiles.get(position));
        imgPerfil.setImageDrawable(MainActivity.imgsPerfil[position]);
        return view;
    }
}
