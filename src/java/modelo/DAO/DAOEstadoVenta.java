/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.DTO.DTOEstadoVenta;
import modelo.Interfaz.InterfazEstadoVenta;

/**
 *
 * @author camil
 */
public class DAOEstadoVenta implements InterfazEstadoVenta {

    @Override
    public List<DTOEstadoVenta> listarEstadoComprasCliente(String documento_identidad) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_usuarios.*,tbl_productos.*,tbl_cliente_producto.*,tbl_ventas.*,tbl_estado_ventas.* FROM tbl_ventas INNER JOIN tbl_cliente_producto ON tbl_cliente_producto.numero_folio = tbl_ventas.numero_folio INNER JOIN tbl_productos ON tbl_productos.id_producto = tbl_cliente_producto.id_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_ventas.documento_identidad INNER JOIN tbl_estado_ventas ON tbl_estado_ventas.id_estado_venta = tbl_ventas.id_estado_compra WHERE tbl_ventas.documento_identidad = " + documento_identidad + " ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOEstadoVenta> listarEstadoComprasCliente = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOEstadoVenta dtoEstadoVenta = new DTOEstadoVenta();
                dtoEstadoVenta.setId_estado_venta(rs.getInt("id_estado_venta"));
                dtoEstadoVenta.setEstado_venta(rs.getString("estado_venta"));
                listarEstadoComprasCliente.add(dtoEstadoVenta);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar compras cliente." + e);
        }
        return listarEstadoComprasCliente;
    }
    
    @Override
    public List<DTOEstadoVenta> listarEstadoNegociosCliente(int numero_folio) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_cliente_producto.*,tbl_ventas.*,tbl_estado_ventas.* FROM tbl_cliente_producto INNER JOIN tbl_productos ON tbl_productos.id_producto = tbl_cliente_producto.id_producto INNER JOIN tbl_ventas ON tbl_ventas.numero_folio = tbl_cliente_producto.numero_folio INNER JOIN tbl_estado_ventas ON tbl_estado_ventas.id_estado_venta = tbl_ventas.id_estado_negociacion WHERE tbl_cliente_producto.numero_folio = " + numero_folio + " ORDER BY tbl_ventas.id_venta ASC;";
        List<DTOEstadoVenta> listarEstadoNegociosCliente = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOEstadoVenta dtoEstadoVenta = new DTOEstadoVenta();
                dtoEstadoVenta.setId_estado_venta(rs.getInt("id_estado_venta"));
                dtoEstadoVenta.setEstado_venta(rs.getString("estado_venta"));
                listarEstadoNegociosCliente.add(dtoEstadoVenta);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar compras cliente." + e);
        }
        return listarEstadoNegociosCliente;
    }

}
