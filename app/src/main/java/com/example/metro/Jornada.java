package com.example.metro;

import java.util.Calendar;

public class Jornada {
    private Calendar fecha;
    private int hIni, hFin;

    public Jornada(Calendar fecha, int hIni, int hFin) {
        this.fecha = fecha;
        this.hIni = hIni;
        this.hFin = hFin;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public int gethIni() {
        return hIni;
    }

    public void sethIni(int hIni) {
        this.hIni = hIni;
    }

    public int gethFin() {
        return hFin;
    }

    public void sethFin(int hFin) {
        this.hFin = hFin;
    }
}
