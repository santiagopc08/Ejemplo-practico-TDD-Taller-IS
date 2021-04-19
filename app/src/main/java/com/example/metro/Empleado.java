package com.example.metro;

import java.util.ArrayList;

public class Empleado {
    private String nombre, apellido;
    private int perfil, cedula;
    private ArrayList<Jornada> histJornadas;

    public Empleado(String nombre, String apellido, int perfil, int cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.perfil = perfil;
        this.cedula = cedula;
        histJornadas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public ArrayList<Jornada> getHistJornadas() {
        return histJornadas;
    }

    public void setHistJornadas(ArrayList<Jornada> histJornadas) {
        this.histJornadas = histJornadas;
    }
}
