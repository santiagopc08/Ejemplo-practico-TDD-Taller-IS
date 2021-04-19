package com.example.metro;

import junit.framework.TestCase;

public class BuscarEmpleadoActivityTest extends TestCase {

    private Empleado empleadoActual;

    public void testEmpleadoInexistente() {
        MainActivity.inicializarInfo();
        empleadoActual = BuscarEmpleadoActivity.buscarEmpleado(987);
        assertNull(empleadoActual);
    }

    public void testEmpleadoExistente() {
        MainActivity.inicializarInfo();
        empleadoActual = BuscarEmpleadoActivity.buscarEmpleado(123);
        assertNotNull(empleadoActual);
    }

    public void testEncontrarTodasLasJornadas() {
        MainActivity.inicializarInfo();
        empleadoActual = BuscarEmpleadoActivity.buscarEmpleado(456);
        BuscarEmpleadoActivity.empleadoActual = empleadoActual;
        assertEquals(3, BuscarEmpleadoActivity.encontrarJornada("").size());
    }
}