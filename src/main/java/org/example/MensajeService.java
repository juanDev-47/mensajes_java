package org.example;

import java.util.Scanner;

public class MensajeService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Tu nombre:");
        String nombre = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);

        MensajesDAO.CrearMensajeDB(registro);
    }

    public static void listarMensajes(){
        MensajesDAO.leerMensajeDB();
    }

    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        String id;
        System.out.println("----------------");
        System.out.println("Ingrese el identificador a ser eliminado");
        id = sc.nextLine();

        int id_mensaje = Integer.parseInt(id);

        MensajesDAO.borrarMensajeDB(id_mensaje);
    }

    public static void actualizarMensaje(){

    }
}
