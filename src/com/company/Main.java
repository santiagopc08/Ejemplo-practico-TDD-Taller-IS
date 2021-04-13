package com.company;

import java.util.ArrayList;

public class Main {

    private static ArrayList<Empleado> empleados = new ArrayList<>();
    private static String[] tipos = {"Mecanico", "Conductor", "Coordinador", "Limpieza", "Supervisor"};

    public static void main(String[] args) {
        empleados.add(new Empleado(tipos[0], "Alberto", "Álvarez", 123456));
    }

    /**
     * return true if employee with given id exists and shows its info
     * false if employee does not exists
     * */
    public static boolean mostrarInfoEmpleado(int cedula){
        for (Empleado empleado: empleados) {
            if (empleado.getCedula() == cedula){
                System.out.println("La información del empleado es: ");
                System.out.println("Nombre: " + empleado.getNombre());
                System.out.println("Apellido: " + empleado.getApellido());
                System.out.println("Perfil: " + empleado.getTipo());
                return true;
            }
        }
        return false;
    }
}
