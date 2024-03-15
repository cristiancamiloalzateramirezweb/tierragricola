package modelo.DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.DTO.DTOSeccion;
import modelo.Interfaz.InterfazSeccion;

public class DAOSeccion implements InterfazSeccion {

    @Override
    public DTOSeccion obtenerSeccionItemProducto(int id_producto) {
        DTOSeccion seccionProducto = null;
        Connection con = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_productos.id_producto = '" + id_producto + "';";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                seccionProducto = new DTOSeccion();
                seccionProducto.setId_seccion(rs.getInt("id_seccion"));
                seccionProducto.setNombre_seccion(rs.getString("nombre_seccion"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOSeccion, método obtener seccion producto." + e);
        }
        return seccionProducto;
    }
    
    @Override
    public DTOSeccion obtenerSeccionProducto(int id_producto) {
        DTOSeccion seccionProducto = null;
        Connection con = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.* FROM tbl_productos INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion WHERE tbl_productos.id_producto = '" + id_producto + "';";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                seccionProducto = new DTOSeccion();
                seccionProducto.setId_seccion(rs.getInt("id_seccion"));
                seccionProducto.setNombre_seccion(rs.getString("nombre_seccion"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOSeccion, método obtener seccion producto." + e);
        }
        return seccionProducto;
    }

}
