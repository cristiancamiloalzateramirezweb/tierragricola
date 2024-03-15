package modelo.DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.DTO.DTOCalificacion;
import modelo.Interfaz.InterfazCalificacion;

public class DAOCalificacion implements InterfazCalificacion {

    @Override
    public boolean crearCalificacion(DTOCalificacion calificacion) {
        boolean crearCalificacion = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO tbl_calificaciones(id_calificacion,calificacion,observaciones,fecha) VALUES (NULL,'" + calificacion.getCalificacion() + "', '" + calificacion.getObservaciones() + "',CURDATE())";
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            crearCalificacion = true;
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOVenta, método crear venta." + e);
        }
        return crearCalificacion;
    }

}
