package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    private static ArrayList<Empleado> empleados = new ArrayList<>();
    private static String[] tipos = {"Mecanico", "Conductor", "Coordinador", "Limpieza", "Supervisor"};

    private static ArrayList<Jornada> jornadas = new ArrayList<>();

    public static void main(String[] args) {
        mostrarInfoEmpleado(123456);
        empleados.add(new Empleado(tipos[0], "Alberto", "Álvarez", 123456));
        jornadas.add(new Jornada((new Empleado(tipos[0], "Alberto", "Álvarez", 123456)),1,10,"Excelente Desempeño",null,"7:00 ","14:00"));
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
     *Resultado Esperado: Mostrar Novedades del  mes , los turnos  y el  perfil del empleado
     **/
    public static void mostrarNovedades(int cedula ,String horaInicio, String horaFin ){
        for(Jornada jornada:jornadas){
            if(jornada.getEmpleado().getCedula()==cedula){
                if(jornada.getHoraInicio().equals(horaInicio) && jornada.getHoraFin().equals(horaFin)){
                    System.out.println("La información del empleado es: ");
                    System.out.println("Novedades :"+ jornada.getObservacion());
                    System.out.println("turnos:"+jornada.getTurno());
                    System.out.println("perfil del empleado"+ jornada.getEmpleado().getTipo());
                }
            }
        }

    }

    /**
     * Resultado: Mostrar hora de entrada  y hora de salida del dia ingresado
     */
    public static void mostrarHoraDeTurnoPorDia(int cedula , Date fecha){
        for (Jornada jornada:jornadas){
            if(jornada.getEmpleado().getCedula()==cedula){
                if(jornada.getFecha()==fecha){
                    System.out.println("Horas inicio y salida es: ");
                    System.out.println("Hora Inicio :"+ jornada.getHoraInicio());
                    System.out.println("Hora Fin:"+jornada.getHoraFin());
                }
            }
        }
    }

    /**
     *
     *Resultado mostrar como minimo tres empleados diferentes
     */
    public static void validarEmpleados(){
        for (Empleado empleado:empleados){
            System.out.println("La información del empleado es: ");
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Apellido: " + empleado.getApellido());
            System.out.println("Perfil: " + empleado.getTipo());
        }

    }

    /**
     *
     *Resultado: Mostrar las 6 jornadas minimas que debe tener un empleado
     */
    public static void validarJornadas(int cedula){
        int contador=0;
        for(Jornada jornada:jornadas){
            if(jornada.getEmpleado().getCedula()== cedula){
                contador++;
            }else
                if(contador >= 6) {
                    System.out.println("las jordanas");
                    System.out.println("Empleado" + jornada.getEmpleado().getCedula());
                    System.out.println("turno" + jornada.getTurno());
                    System.out.println("Observacion" + jornada.getObservacion());
                    System.out.println("fecha" + jornada.getFecha());
                    System.out.println("hora Inicio" + jornada.getHoraInicio());
                    System.out.println("hora Fin" + jornada.getHoraFin());

                }
            }
        }
    }

