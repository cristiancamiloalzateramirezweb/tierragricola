package modelo.DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.DTO.DTOCategoria;
import modelo.Interfaz.InterfazCategoria;

public class DAOCategoria implements InterfazCategoria {

    @Override
    public List<DTOCategoria> obtenerCategoriasSeccion(int id_seccion) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_secciones.*,tbl_categorias.* FROM tbl_secciones INNER JOIN tbl_categorias ON tbl_categorias.id_seccion = tbl_secciones.id_seccion WHERE tbl_secciones.id_seccion = '" + id_seccion + "' ORDER BY tbl_categorias.nombre_categoria ASC;";
        List<DTOCategoria> obtenerCategoriasSeccion = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOCategoria dtoCategoria = new DTOCategoria();
                dtoCategoria.setId_categoria(rs.getInt("id_categoria"));
                dtoCategoria.setId_seccion(rs.getInt("id_seccion"));
                dtoCategoria.setNombre_categoria(rs.getString("nombre_categoria"));
                obtenerCategoriasSeccion.add(dtoCategoria);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOCategoria, método obtener categorias seccion." + e);
        }
        return obtenerCategoriasSeccion;
    }

    @Override
    public List<DTOCategoria> listarCategoriaProductosGanaderia() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Ganadería' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOCategoria> listarCategoriaClientesGanaderia = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOCategoria dtoCategoria = new DTOCategoria();
                dtoCategoria.setId_categoria(rs.getInt("id_categoria"));
                dtoCategoria.setId_seccion(rs.getInt("id_seccion"));
                dtoCategoria.setNombre_categoria(rs.getString("nombre_categoria"));
                listarCategoriaClientesGanaderia.add(dtoCategoria);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOCategoria, método listar categoria productos ganaderia." + e);
        }
        return listarCategoriaClientesGanaderia;
    }

    @Override
    public List<DTOCategoria> listarCategoriaProductosMascotas() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Mascotas' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOCategoria> listarCategoriaProductosMascotas = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOCategoria dtoCategoria = new DTOCategoria();
                dtoCategoria.setId_categoria(rs.getInt("id_categoria"));
                dtoCategoria.setId_seccion(rs.getInt("id_seccion"));
                dtoCategoria.setNombre_categoria(rs.getString("nombre_categoria"));
                listarCategoriaProductosMascotas.add(dtoCategoria);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOCategoria, método listar categoria productos mascotas." + e);
        }
        return listarCategoriaProductosMascotas;
    }

    @Override
    public List<DTOCategoria> listarCategoriaProductosAlimentos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Alimentos' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOCategoria> listarCategoriaProductosAlimentos = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOCategoria dtoCategoria = new DTOCategoria();
                dtoCategoria.setId_categoria(rs.getInt("id_categoria"));
                dtoCategoria.setId_seccion(rs.getInt("id_seccion"));
                dtoCategoria.setNombre_categoria(rs.getString("nombre_categoria"));
                listarCategoriaProductosAlimentos.add(dtoCategoria);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOCategoria, método listar categoria productos alimentos." + e);
        }
        return listarCategoriaProductosAlimentos;
    }

    @Override
    public List<DTOCategoria> listarCategoriaProductosInsumos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Insumos' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOCategoria> listarCategoriaProductosInsumos = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOCategoria dtoCategoria = new DTOCategoria();
                dtoCategoria.setId_categoria(rs.getInt("id_categoria"));
                dtoCategoria.setId_seccion(rs.getInt("id_seccion"));
                dtoCategoria.setNombre_categoria(rs.getString("nombre_categoria"));
                listarCategoriaProductosInsumos.add(dtoCategoria);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOCategoria, método listar categoria productos insumos." + e);
        }
        return listarCategoriaProductosInsumos;
    }

    @Override
    public List<DTOCategoria> listarCategoriaProductosBusqueda(String busqueda) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_productos.titulo_producto LIKE '%" + busqueda + "%' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOCategoria> listarCategoriaProductosBusqueda = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOCategoria dtoCategoria = new DTOCategoria();
                dtoCategoria.setId_categoria(rs.getInt("id_categoria"));
                dtoCategoria.setId_seccion(rs.getInt("id_seccion"));
                dtoCategoria.setNombre_categoria(rs.getString("nombre_categoria"));
                listarCategoriaProductosBusqueda.add(dtoCategoria);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOCategoria, método listar categoria busqueda productos ganaderia." + e);
        }
        return listarCategoriaProductosBusqueda;
    }

    @Override
    public DTOCategoria obtenerCategoriaItemProducto(int id_producto) {
        DTOCategoria categoria = null;
        Connection con = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_productos.id_producto = '" + id_producto + "';";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                categoria = new DTOCategoria();
                categoria.setId_categoria(rs.getInt("id_categoria"));
                categoria.setId_seccion(rs.getInt("id_seccion"));
                categoria.setNombre_categoria(rs.getString("nombre_categoria"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método obtener categoria producto." + e);
        }
        return categoria;
    }
    
    @Override
    public DTOCategoria obtenerCategoriaProducto(int id_producto) {
        DTOCategoria categoria = null;
        Connection con = null;
        String sql = "SELECT tbl_productos.*,tbl_categorias.* FROM tbl_productos INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_productos.id_producto = '" + id_producto + "';";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                categoria = new DTOCategoria();
                categoria.setId_categoria(rs.getInt("id_categoria"));
                categoria.setId_seccion(rs.getInt("id_seccion"));
                categoria.setNombre_categoria(rs.getString("nombre_categoria"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método obtener categoria producto." + e);
        }
        return categoria;
    }

}
