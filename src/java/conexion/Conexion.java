/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author camil
 */
public class Conexion {

    public static Connection conectar() throws ClassNotFoundException {
        Connection con = null;

        String password = "";
        String usuario = "root";
        String url = "jdbc:mysql://localhost:3306/tierragricola?user=" + usuario + "&&password=" + password + "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url);
            if (con != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos" + e);
            e.printStackTrace();
        }
        return con;
    }
}

//tierragricola
//]f$x7RK]ztxHuof?