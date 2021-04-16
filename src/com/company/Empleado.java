package com.company;

public class Empleado {
    private String tipo, nombre, apellido;
    private int cedula;

    public Empleado(String tipo, String nombre, String apellido, int cedula) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
}
