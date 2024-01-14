package org.example;

import org.example.utils.Conexion;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do{
            System.out.println("-----------");
            System.out.println("aplicacion de mensajes");
            System.out.println("1. crear un mensaje");
            System.out.println("2. Listar los mensajes");
            System.out.println("3. editar los mensajes");
            System.out.println("4. eliminar un mensaje");
            System.out.println("5. Salir");

            opcion = sc.nextInt();

            switch(opcion){
                case 1:
                    MensajeService.crearMensaje();
                    break;

                case 2:
                    MensajeService.listarMensajes();
                    break;

                case 3:
                    MensajeService.borrarMensaje();
                    break;

                case 4:
                    MensajeService.actualizarMensaje();
                    break;

                default:
                    break;
            }

        } while(opcion != 5);


    }
}