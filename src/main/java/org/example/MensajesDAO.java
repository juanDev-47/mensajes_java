package org.example;

import org.example.utils.Conexion;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Date;

public class MensajesDAO {

    public static void CrearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt.toString());

        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje, fecha_mensaje) VALUES (?, ?, ?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.mensaje);
                ps.setString(2, mensaje.autor_mensaje);
                ps.setString(3, ldt.toString());
                ps.executeUpdate();
                System.out.println("Mensaje creado correctamente");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void leerMensajeDB(){
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "SELECT * FROM mensajes";
                ps = conexion.prepareStatement(query);
                rs = ps.executeQuery();

                while(rs.next()){
                    System.out.println("ID: " + rs.getInt("id_mensaje"));
                    System.out.println("Mensaje: " + rs.getString("mensaje"));
                    System.out.println("Autor: " + rs.getString("autor_mensaje"));
                    System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                    System.out.println("");
                }
            } catch (SQLException ex){
                System.out.println(ex);
            }

        } catch (SQLException e){
            System.out.println(e);
        }

    }

    public static void borrarMensajeDB(int id_mensaje) {
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);

                ps.executeUpdate();
            } catch (SQLException ex){
                System.out.println(ex);
            }

        } catch (SQLException e){
            System.out.println(e);
        }

    }

    public static void actualizarMensajeDB(int id_mensaje, String mensaje){
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje);
                ps.setInt(2, id_mensaje);

                ps.executeUpdate();
            } catch (SQLException ex){
                System.out.println(ex);
            }

        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
