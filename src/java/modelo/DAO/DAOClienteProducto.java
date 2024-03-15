package modelo.DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.DTO.DTOClienteProducto;
import modelo.Interfaz.InterfazClienteProducto;

public class DAOClienteProducto implements InterfazClienteProducto {

    @Override
    public boolean crearClienteProducto(DTOClienteProducto clienteProducto) {
        boolean crearClienteProducto = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO tbl_cliente_producto(numero_folio,documento_identidad,id_producto) VALUES (NULL,'" + clienteProducto.getDocumento_identidad() + "','" + clienteProducto.getId_producto() + "')";
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            crearClienteProducto = true;
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOClienteProducto, método crear cliente producto." + e);
        }
        return crearClienteProducto;
    }

    @Override
    public List<DTOClienteProducto> listarClientesProductosDestacados() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.*,tbl_ventas.*, COUNT(tbl_ventas.numero_folio) FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_ventas ON tbl_ventas.numero_folio = tbl_cliente_producto.numero_folio WHERE tbl_productos.cantidad >=1 GROUP BY tbl_ventas.numero_folio ORDER BY COUNT(tbl_ventas.numero_folio) AND tbl_productos.fecha_publicacion DESC LIMIT 0,30;";
        List<DTOClienteProducto> listarClientesProductosDestacados = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOClienteProducto dtoClienteProducto = new DTOClienteProducto();
                dtoClienteProducto.setNumero_folio(rs.getInt("numero_folio"));
                dtoClienteProducto.setDocumento_identidad(rs.getString("documento_identidad"));
                dtoClienteProducto.setId_producto(rs.getInt("id_producto"));
                listarClientesProductosDestacados.add(dtoClienteProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar productos ganaderia." + e);
        }
        return listarClientesProductosDestacados;
    }
    
    @Override
    public List<DTOClienteProducto> listarClientesProductosGanaderia() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Ganadería' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOClienteProducto> listarClientesProductosGanaderia = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOClienteProducto dtoClienteProducto = new DTOClienteProducto();
                dtoClienteProducto.setNumero_folio(rs.getInt("numero_folio"));
                dtoClienteProducto.setDocumento_identidad(rs.getString("documento_identidad"));
                dtoClienteProducto.setId_producto(rs.getInt("id_producto"));
                listarClientesProductosGanaderia.add(dtoClienteProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar productos ganaderia." + e);
        }
        return listarClientesProductosGanaderia;
    }

    @Override
    public List<DTOClienteProducto> listarClientesProductosMascotas() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Mascotas' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOClienteProducto> listarClientesProductosMascotas = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOClienteProducto dtoClienteProducto = new DTOClienteProducto();
                dtoClienteProducto.setNumero_folio(rs.getInt("numero_folio"));
                dtoClienteProducto.setDocumento_identidad(rs.getString("documento_identidad"));
                dtoClienteProducto.setId_producto(rs.getInt("id_producto"));
                listarClientesProductosMascotas.add(dtoClienteProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar productos mascotas." + e);
        }
        return listarClientesProductosMascotas;
    }

    @Override
    public List<DTOClienteProducto> listarClientesProductosAlimentos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Alimentos' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOClienteProducto> listarClientesProductosAlimentos = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOClienteProducto dtoClienteProducto = new DTOClienteProducto();
                dtoClienteProducto.setNumero_folio(rs.getInt("numero_folio"));
                dtoClienteProducto.setDocumento_identidad(rs.getString("documento_identidad"));
                dtoClienteProducto.setId_producto(rs.getInt("id_producto"));
                listarClientesProductosAlimentos.add(dtoClienteProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar productos alimentos." + e);
        }
        return listarClientesProductosAlimentos;
    }

    @Override
    public List<DTOClienteProducto> listarClientesProductosInsumos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Insumos' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOClienteProducto> listarClientesProductosInsumos = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOClienteProducto dtoClienteProducto = new DTOClienteProducto();
                dtoClienteProducto.setNumero_folio(rs.getInt("numero_folio"));
                dtoClienteProducto.setDocumento_identidad(rs.getString("documento_identidad"));
                dtoClienteProducto.setId_producto(rs.getInt("id_producto"));
                listarClientesProductosInsumos.add(dtoClienteProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar productos insumos." + e);
        }
        return listarClientesProductosInsumos;
    }

    @Override
    public List<DTOClienteProducto> listarClientesProductosBusqueda(String busqueda) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_productos.titulo_producto LIKE '%" + busqueda + "%' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOClienteProducto> listarClientesProductosBusqueda = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOClienteProducto dtoClienteProducto = new DTOClienteProducto();
                dtoClienteProducto.setNumero_folio(rs.getInt("numero_folio"));
                dtoClienteProducto.setDocumento_identidad(rs.getString("documento_identidad"));
                dtoClienteProducto.setId_producto(rs.getInt("id_producto"));
                listarClientesProductosBusqueda.add(dtoClienteProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar busqueda clientes productos." + e);
        }
        return listarClientesProductosBusqueda;
    }

    @Override
    public List<DTOClienteProducto> listarClienteProductoUsuario(String documento_identidad){
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_cliente_producto.*,tbl_usuarios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_productos ON tbl_productos.id_producto = tbl_cliente_producto.id_producto WHERE tbl_cliente_producto.documento_identidad = '" + documento_identidad + "' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOClienteProducto> listarClienteProductoUsuario = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOClienteProducto dtoClienteProducto = new DTOClienteProducto();
                dtoClienteProducto.setNumero_folio(rs.getInt("numero_folio"));
                dtoClienteProducto.setDocumento_identidad(rs.getString("documento_identidad"));
                dtoClienteProducto.setId_producto(rs.getInt("id_producto"));
                listarClienteProductoUsuario.add(dtoClienteProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOClienteProducto, método listar busqueda clientes productos usuario." + e);
        }
        return listarClienteProductoUsuario;
    }
    
    @Override
    public List<DTOClienteProducto> listarBusquedaClienteProductoUsuario(String documento_identidad, String busqueda){
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_cliente_producto.*,tbl_usuarios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_productos ON tbl_productos.id_producto = tbl_cliente_producto.id_producto WHERE tbl_usuarios.documento_identidad = '" + documento_identidad + "' AND tbl_productos.titulo_producto LIKE '%" + busqueda + "%' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOClienteProducto> listarBusquedaClienteProductoUsuario = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOClienteProducto dtoClienteProducto = new DTOClienteProducto();
                dtoClienteProducto.setNumero_folio(rs.getInt("numero_folio"));
                dtoClienteProducto.setDocumento_identidad(rs.getString("documento_identidad"));
                dtoClienteProducto.setId_producto(rs.getInt("id_producto"));
                listarBusquedaClienteProductoUsuario.add(dtoClienteProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOClienteProducto, método listar busqueda clientes productos usuario." + e);
        }
        return listarBusquedaClienteProductoUsuario;
    }
    
    @Override
    public DTOClienteProducto obtenerClienteProducto(int id_producto) {
        DTOClienteProducto clienteProducto = null;
        Connection con = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_productos.id_producto = '" + id_producto + "';";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                clienteProducto = new DTOClienteProducto();
                clienteProducto.setNumero_folio(rs.getInt("numero_folio"));
                clienteProducto.setDocumento_identidad(rs.getString("documento_identidad"));
                clienteProducto.setId_producto(rs.getInt("id_producto"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método obtener item producto." + e);
        }
        return clienteProducto;
    }
    
    @Override
    public List<DTOClienteProducto> listarClienteProductoVentas(int numero_folio){
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_cliente_producto.*,tbl_ventas.*,tbl_estado_ventas.* FROM tbl_cliente_producto INNER JOIN tbl_productos ON tbl_productos.id_producto = tbl_cliente_producto.id_producto INNER JOIN tbl_ventas ON tbl_ventas.numero_folio = tbl_cliente_producto.numero_folio INNER JOIN tbl_estado_ventas ON tbl_estado_ventas.id_estado_venta = tbl_ventas.id_estado_negociacion WHERE tbl_cliente_producto.numero_folio = " + numero_folio + " ORDER BY tbl_ventas.id_venta ASC;";
        List<DTOClienteProducto> listarBusquedaClienteProductoUsuario = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOClienteProducto dtoClienteProducto = new DTOClienteProducto();
                dtoClienteProducto.setNumero_folio(rs.getInt("numero_folio"));
                dtoClienteProducto.setDocumento_identidad(rs.getString("documento_identidad"));
                dtoClienteProducto.setId_producto(rs.getInt("id_producto"));
                listarBusquedaClienteProductoUsuario.add(dtoClienteProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOClienteProducto, método listar busqueda clientes productos usuario." + e);
        }
        return listarBusquedaClienteProductoUsuario;
    }
    
}
