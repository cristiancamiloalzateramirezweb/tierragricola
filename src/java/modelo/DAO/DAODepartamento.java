package modelo.DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.DTO.DTODepartamento;
import modelo.Interfaz.InterfazDepartamento;

public class DAODepartamento implements InterfazDepartamento {

    @Override
    public List<DTODepartamento> listarDepartamentos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM tbl_departamentos ORDER BY tbl_departamentos.departamento ASC;";
        List<DTODepartamento> listarDepartamentoClientesGanaderia = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTODepartamento dtoDepartamento = new DTODepartamento();
                dtoDepartamento.setId_departamento(rs.getInt("id_departamento"));
                dtoDepartamento.setDepartamento(rs.getString("departamento"));
                listarDepartamentoClientesGanaderia.add(dtoDepartamento);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAODepartamento, método listar departamento clientes ganaderia." + e);
        }
        return listarDepartamentoClientesGanaderia;
    }
    
    @Override
    public List<DTODepartamento> listarDepartamentoClientesDestacados() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.*,tbl_ventas.*, COUNT(tbl_ventas.numero_folio) FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_ventas ON tbl_ventas.numero_folio = tbl_cliente_producto.numero_folio WHERE tbl_productos.cantidad >=1 GROUP BY tbl_ventas.numero_folio ORDER BY COUNT(tbl_ventas.numero_folio) AND tbl_productos.fecha_publicacion DESC LIMIT 0,30;";
        List<DTODepartamento> listarDepartamentoClientesDestacados = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTODepartamento dtoDepartamento = new DTODepartamento();
                dtoDepartamento.setId_departamento(rs.getInt("id_departamento"));
                dtoDepartamento.setDepartamento(rs.getString("departamento"));
                listarDepartamentoClientesDestacados.add(dtoDepartamento);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAODepartamento, método listar departamento clientes ganaderia." + e);
        }
        return listarDepartamentoClientesDestacados;
    }
    
    @Override
    public List<DTODepartamento> listarDepartamentoClientesGanaderia() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Ganadería' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTODepartamento> listarDepartamentoClientesGanaderia = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTODepartamento dtoDepartamento = new DTODepartamento();
                dtoDepartamento.setId_departamento(rs.getInt("id_departamento"));
                dtoDepartamento.setDepartamento(rs.getString("departamento"));
                listarDepartamentoClientesGanaderia.add(dtoDepartamento);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAODepartamento, método listar departamento clientes ganaderia." + e);
        }
        return listarDepartamentoClientesGanaderia;
    }

    @Override
    public List<DTODepartamento> listarDepartamentoClientesMascotas() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Mascotas' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTODepartamento> listarDepartamentoClientesMascotas = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTODepartamento dtoDepartamento = new DTODepartamento();
                dtoDepartamento.setId_departamento(rs.getInt("id_departamento"));
                dtoDepartamento.setDepartamento(rs.getString("departamento"));
                listarDepartamentoClientesMascotas.add(dtoDepartamento);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAODepartamento, método listar departamento clientes mascotas." + e);
        }
        return listarDepartamentoClientesMascotas;
    }

    @Override
    public List<DTODepartamento> listarDepartamentoClientesAlimentos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Alimentos' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTODepartamento> listarDepartamentoClientesAlimentos = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTODepartamento dtoDepartamento = new DTODepartamento();
                dtoDepartamento.setId_departamento(rs.getInt("id_departamento"));
                dtoDepartamento.setDepartamento(rs.getString("departamento"));
                listarDepartamentoClientesAlimentos.add(dtoDepartamento);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAODepartamento, método listar departamento clientes alimentos." + e);
        }
        return listarDepartamentoClientesAlimentos;
    }

    @Override
    public List<DTODepartamento> listarDepartamentoClientesInsumos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Insumos' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTODepartamento> listarDepartamentoClientesInsumos = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTODepartamento dtoDepartamento = new DTODepartamento();
                dtoDepartamento.setId_departamento(rs.getInt("id_departamento"));
                dtoDepartamento.setDepartamento(rs.getString("departamento"));
                listarDepartamentoClientesInsumos.add(dtoDepartamento);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAODepartamento, método listar departamento clientes insumos." + e);
        }
        return listarDepartamentoClientesInsumos;
    }

    @Override
    public List<DTODepartamento> listarDepartamentoClientesBusqueda(String busqueda) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_productos.titulo_producto LIKE '%" + busqueda + "%' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTODepartamento> listarDepartamentoClientesBusqueda = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTODepartamento dtoDepartamento = new DTODepartamento();
                dtoDepartamento.setId_departamento(rs.getInt("id_departamento"));
                dtoDepartamento.setDepartamento(rs.getString("departamento"));
                listarDepartamentoClientesBusqueda.add(dtoDepartamento);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAODepartamento, método listar departamento clientes." + e);
        }
        return listarDepartamentoClientesBusqueda;
    }

    @Override
    public DTODepartamento obtenerDepartamentoClienteProducto(int id_producto) {
        DTODepartamento departamentoClienteProducto = null;
        Connection con = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_productos.id_producto = '" + id_producto + "';";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                departamentoClienteProducto = new DTODepartamento();
                departamentoClienteProducto.setId_departamento(rs.getInt("id_departamento"));
                departamentoClienteProducto.setDepartamento(rs.getString("departamento"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método obtener municipio cliente producto." + e);
        }
        return departamentoClienteProducto;
    }
    
    @Override
    public DTODepartamento obtenerDepartamentoUsuario(String documento_identidad) {
        DTODepartamento departamentoUsuario = null;
        Connection con = null;
        String sql = "SELECT tbl_usuarios.*,tbl_departamentos.* FROM tbl_usuarios INNER JOIN tbl_departamentos ON tbl_usuarios.id_departamento = tbl_departamentos.id_departamento WHERE tbl_usuarios.documento_identidad = '"+ documento_identidad +"';";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                departamentoUsuario = new DTODepartamento();
                departamentoUsuario.setId_departamento(rs.getInt("id_departamento"));
                departamentoUsuario.setDepartamento(rs.getString("departamento"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método obtener municipio usuario." + e);
        }
        return departamentoUsuario;
    }

}
