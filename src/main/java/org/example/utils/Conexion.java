package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection get_connection(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "qwerty");

        } catch (SQLException e){
            System.out.println("se obtuvo el siguiente error de codigo:");
            System.out.println(e);
        }

        return connection;

    }
}
