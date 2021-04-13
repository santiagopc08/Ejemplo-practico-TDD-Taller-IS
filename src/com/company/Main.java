package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    private static ArrayList<Empleado> empleados = new ArrayList<>();
    private static String[] tipos = {"Mecanico", "Conductor", "Coordinador", "Limpieza", "Supervisor"};

    private static ArrayList<Jornada> jornadas = new ArrayList<>();

    public static void main(String[] args) {

        empleados.add(new Empleado(tipos[0], "Alberto", "Álvarez", 123456));
        jornadas.add(new Jornada((new Empleado(tipos[0], "Alberto", "Álvarez", 123456)),001,10,"Excelente Desempeño",null,"7:00 ","14:00"));
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


    /**
     *Mostrar las novedades del mes , los turnos  y el perfil del empleado
     *
     * **/
    public  static boolean mostrarNovedades(int cedula , Date fechaInicio , Date fechaFin){
        for(Jornada jornada: jornadas){
            if(jornada.getEmpleado().getCedula()==cedula ){
                while (jornada.getFecha().after(fechaInicio) && jornada.getFecha().before(fechaFin)){
                    System.out.println("La información del empleado es: ");
                    System.out.println("Novedades :"+ jornada.getObservacion());
                    System.out.println("turnos:"+jornada.getTurno());
                    System.out.println("perfil del empleado"+ jornada.getEmpleado().getTipo());
                    return true;
                }
            }
        }
        return false ;
    }
}
