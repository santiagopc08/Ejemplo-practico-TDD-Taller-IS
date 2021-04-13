package com.company;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    public void mostrarInfoEmpleadoExistente() {
        assertTrue(Main.mostrarInfoEmpleado(123456));
    }

    @org.junit.jupiter.api.Test
    public void mostrarInfoEmpleadoInexistente() {
        assertFalse(Main.mostrarInfoEmpleado(987654));
    }
}