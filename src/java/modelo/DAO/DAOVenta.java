package modelo.DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.DTO.DTOVenta;
import modelo.Interfaz.InterfazVenta;

public class DAOVenta implements InterfazVenta {

    @Override
    public boolean crearVenta(DTOVenta venta) {
        boolean crearVenta = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO tbl_ventas(id_venta,documento_identidad,numero_folio,precio_venta,cantidad_venta,mensaje,id_estado_negociacion,id_estado_compra,id_estado_venta) VALUES (NULL,'" + venta.getDocumento_identidad() + "','" + venta.getNumero_folio() + "','" + venta.getPrecio_venta() + "','" + venta.getCantidad_venta() + "','" + venta.getMensaje() + "','" + venta.getId_estado_negociacion() + "','" + venta.getId_estado_compra() + "','" + venta.getId_estado_venta() + "')";
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            crearVenta = true;
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOVenta, método crear venta." + e);
        }
        return crearVenta;
    }

    @Override
    public boolean editarCompra(DTOVenta venta) {
        boolean editarCompra = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE tbl_ventas SET id_estado_compra='" + venta.getId_estado_compra() + "' WHERE id_venta = '" + venta.getId_venta() + "'";
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            editarCompra = true;
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método editar compra." + e);
        }
        return editarCompra;
    }

    @Override
    public boolean editarNegocio(DTOVenta venta) {
        boolean editarNegocio = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE tbl_ventas SET id_estado_negociacion='" + venta.getId_estado_negociacion() + "' WHERE id_venta = '" + venta.getId_venta() + "'";
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            editarNegocio = true;
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOVenta, método editar negocio." + e);
        }
        return editarNegocio;
    }

    public boolean editarVenta(DTOVenta venta) {
        boolean editarVenta = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE tbl_ventas SET id_estado_venta='" + venta.getId_estado_venta() + "' WHERE id_venta = '" + venta.getId_venta() + "'";
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            editarVenta = true;
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOVenta, método editar venta." + e);
        }
        return editarVenta;
    }

    @Override
    public List<DTOVenta> listarVentasProductoCliente(int numero_folio) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_cliente_producto.*,tbl_ventas.*,tbl_estado_ventas.* FROM tbl_cliente_producto INNER JOIN tbl_productos ON tbl_productos.id_producto = tbl_cliente_producto.id_producto INNER JOIN tbl_ventas ON tbl_ventas.numero_folio = tbl_cliente_producto.numero_folio INNER JOIN tbl_estado_ventas ON tbl_estado_ventas.id_estado_venta = tbl_ventas.id_estado_negociacion WHERE tbl_cliente_producto.numero_folio = " + numero_folio + " ORDER BY tbl_ventas.id_venta ASC;";
        List<DTOVenta> listarNegociosCliente = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOVenta dtoVenta = new DTOVenta();
                dtoVenta.setId_venta(rs.getInt("id_venta"));
                dtoVenta.setNumero_folio(rs.getInt("numero_folio"));
                dtoVenta.setDocumento_identidad(rs.getString("documento_identidad"));
                dtoVenta.setPrecio_venta(rs.getInt("precio_venta"));
                dtoVenta.setCantidad_venta(rs.getInt("cantidad_venta"));
                dtoVenta.setMensaje(rs.getString("mensaje"));
                dtoVenta.setId_estado_negociacion(rs.getInt("id_estado_negociacion"));
                dtoVenta.setId_estado_compra(rs.getInt("id_estado_compra"));
                dtoVenta.setId_estado_venta(rs.getInt("id_estado_venta"));
                listarNegociosCliente.add(dtoVenta);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar negocios cliente." + e);
        }
        return listarNegociosCliente;
    }

    @Override
    public DTOVenta obtenerVenta(int id_venta) {
        DTOVenta ventaNegocio = null;
        Connection con = null;
        String sql = "SELECT tbl_usuarios.*,tbl_productos.*,tbl_cliente_producto.*,tbl_ventas.* FROM tbl_ventas INNER JOIN tbl_cliente_producto ON tbl_cliente_producto.numero_folio = tbl_ventas.numero_folio INNER JOIN tbl_productos ON tbl_productos.id_producto = tbl_cliente_producto.id_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_ventas.documento_identidad WHERE tbl_ventas.id_venta = " + id_venta + "";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                ventaNegocio = new DTOVenta();
                ventaNegocio.setId_venta(rs.getInt("id_venta"));
                ventaNegocio.setNumero_folio(rs.getInt("numero_folio"));
                ventaNegocio.setDocumento_identidad(rs.getString("documento_identidad"));
                ventaNegocio.setPrecio_venta(rs.getInt("precio_venta"));
                ventaNegocio.setCantidad_venta(rs.getInt("cantidad_venta"));
                ventaNegocio.setMensaje(rs.getString("mensaje"));
                ventaNegocio.setId_estado_negociacion(rs.getInt("id_estado_negociacion"));
                ventaNegocio.setId_estado_compra(rs.getInt("id_estado_compra"));
                ventaNegocio.setId_estado_venta(rs.getInt("id_estado_venta"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método obtener producto venta." + e);
        }
        return ventaNegocio;
    }

    @Override
    public List<DTOVenta> listarComprasProductoCliente(String documento_identidad) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_usuarios.*,tbl_productos.*,tbl_cliente_producto.*,tbl_ventas.*,tbl_estado_ventas.* FROM tbl_ventas INNER JOIN tbl_cliente_producto ON tbl_cliente_producto.numero_folio = tbl_ventas.numero_folio INNER JOIN tbl_productos ON tbl_productos.id_producto = tbl_cliente_producto.id_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_ventas.documento_identidad INNER JOIN tbl_estado_ventas ON tbl_estado_ventas.id_estado_venta = tbl_ventas.id_estado_compra WHERE tbl_ventas.documento_identidad = " + documento_identidad + " ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOVenta> listarNegociosCliente = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOVenta dtoVenta = new DTOVenta();
                dtoVenta.setId_venta(rs.getInt("id_venta"));
                dtoVenta.setNumero_folio(rs.getInt("numero_folio"));
                dtoVenta.setDocumento_identidad(rs.getString("documento_identidad"));
                dtoVenta.setPrecio_venta(rs.getInt("precio_venta"));
                dtoVenta.setCantidad_venta(rs.getInt("cantidad_venta"));
                dtoVenta.setMensaje(rs.getString("mensaje"));
                dtoVenta.setId_estado_negociacion(rs.getInt("id_estado_negociacion"));
                dtoVenta.setId_estado_compra(rs.getInt("id_estado_compra"));
                dtoVenta.setId_estado_venta(rs.getInt("id_estado_venta"));
                listarNegociosCliente.add(dtoVenta);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar negocios cliente." + e);
        }
        return listarNegociosCliente;
    }

}
