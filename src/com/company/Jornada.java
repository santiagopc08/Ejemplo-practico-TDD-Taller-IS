package com.company;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.Date;


public class Jornada {
    private Empleado empleado;
    private int idJornada , turno;
    private String observacion , horaInicio ,horaFin;
    private Date fecha = new Date();




    public Jornada (Empleado empleado , int idJordana, int turno , String observacion , Date fecha , String horaInicio , String horaFin) {
        this.empleado= empleado;
        this.idJornada = idJordana;
        this.turno=turno;
        this.observacion = observacion;
        this.fecha = fecha;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

}
