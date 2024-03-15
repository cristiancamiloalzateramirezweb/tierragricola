package modelo.DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.DTO.DTOMunicipio;
import modelo.Interfaz.InterfazMunicipio;

public class DAOMunicipio implements InterfazMunicipio {

    @Override
    public List<DTOMunicipio> obtenerMunicipiosDepartamento(int id_departamento) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_departamentos.*,tbl_municipios.* FROM tbl_departamentos INNER JOIN tbl_municipios ON tbl_municipios.id_departamento = tbl_departamentos.id_departamento WHERE tbl_departamentos.id_departamento = '" + id_departamento + "' ORDER BY tbl_municipios.municipio ASC;";
        List<DTOMunicipio> obtenerMunicipiosDepartamento = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOMunicipio dtoMunicipio = new DTOMunicipio();
                dtoMunicipio.setId_municipio(rs.getInt("id_municipio"));
                dtoMunicipio.setId_departamento(rs.getInt("id_departamento"));
                dtoMunicipio.setMunicipio(rs.getString("municipio"));
                obtenerMunicipiosDepartamento.add(dtoMunicipio);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOMunicipio, método obtener municipios departamento." + e);
        }
        return obtenerMunicipiosDepartamento;
    }

    @Override
    public List<DTOMunicipio> listarMunicipioClientesDestacados() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.*,tbl_ventas.*, COUNT(tbl_ventas.numero_folio) FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_ventas ON tbl_ventas.numero_folio = tbl_cliente_producto.numero_folio WHERE tbl_productos.cantidad >=1 GROUP BY tbl_ventas.numero_folio ORDER BY COUNT(tbl_ventas.numero_folio) AND tbl_productos.fecha_publicacion DESC LIMIT 0,30;";
        List<DTOMunicipio> listarMunicipioClientesDestacados = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOMunicipio dtoMunicipio = new DTOMunicipio();
                dtoMunicipio.setId_municipio(rs.getInt("id_municipio"));
                dtoMunicipio.setId_departamento(rs.getInt("id_departamento"));
                dtoMunicipio.setMunicipio(rs.getString("municipio"));
                listarMunicipioClientesDestacados.add(dtoMunicipio);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOMunicipio, método listar municipio clientes ganaderia." + e);
        }
        return listarMunicipioClientesDestacados;
    }
    
    @Override
    public List<DTOMunicipio> listarMunicipioClientesGanaderia() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Ganadería' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOMunicipio> listarMunicipioClientesGanaderia = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOMunicipio dtoMunicipio = new DTOMunicipio();
                dtoMunicipio.setId_municipio(rs.getInt("id_municipio"));
                dtoMunicipio.setId_departamento(rs.getInt("id_departamento"));
                dtoMunicipio.setMunicipio(rs.getString("municipio"));
                listarMunicipioClientesGanaderia.add(dtoMunicipio);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOMunicipio, método listar municipio clientes ganaderia." + e);
        }
        return listarMunicipioClientesGanaderia;
    }

    @Override
    public List<DTOMunicipio> listarMunicipioClientesMascotas() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Mascotas' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOMunicipio> listarMunicipioClientesMascotas = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOMunicipio dtoMunicipio = new DTOMunicipio();
                dtoMunicipio.setId_municipio(rs.getInt("id_municipio"));
                dtoMunicipio.setId_departamento(rs.getInt("id_departamento"));
                dtoMunicipio.setMunicipio(rs.getString("municipio"));
                listarMunicipioClientesMascotas.add(dtoMunicipio);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOMunicipio, método listar municipio clientes mascotas." + e);
        }
        return listarMunicipioClientesMascotas;
    }

    @Override
    public List<DTOMunicipio> listarMunicipioClientesAlimentos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Alimentos' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOMunicipio> listarMunicipioClientesAlimentos = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOMunicipio dtoMunicipio = new DTOMunicipio();
                dtoMunicipio.setId_municipio(rs.getInt("id_municipio"));
                dtoMunicipio.setId_departamento(rs.getInt("id_departamento"));
                dtoMunicipio.setMunicipio(rs.getString("municipio"));
                listarMunicipioClientesAlimentos.add(dtoMunicipio);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOMunicipio, método listar municipio clientes alimentos." + e);
        }
        return listarMunicipioClientesAlimentos;
    }

    @Override
    public List<DTOMunicipio> listarMunicipioClientesInsumos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Insumos' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOMunicipio> listarMunicipioClientesInsumos = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOMunicipio dtoMunicipio = new DTOMunicipio();
                dtoMunicipio.setId_municipio(rs.getInt("id_municipio"));
                dtoMunicipio.setId_departamento(rs.getInt("id_departamento"));
                dtoMunicipio.setMunicipio(rs.getString("municipio"));
                listarMunicipioClientesInsumos.add(dtoMunicipio);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOMunicipio, método listar municipio clientes insumos." + e);
        }
        return listarMunicipioClientesInsumos;
    }

    @Override
    public List<DTOMunicipio> listarMunicipioClientesBusqueda(String busqueda) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_productos.titulo_producto LIKE '%" + busqueda + "%' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOMunicipio> listarMunicipioClientesBusqueda = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOMunicipio dtoMunicipio = new DTOMunicipio();
                dtoMunicipio.setId_municipio(rs.getInt("id_municipio"));
                dtoMunicipio.setId_departamento(rs.getInt("id_departamento"));
                dtoMunicipio.setMunicipio(rs.getString("municipio"));
                listarMunicipioClientesBusqueda.add(dtoMunicipio);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOMunicipio, método listar municipio clientes busqueda ganaderia." + e);
        }
        return listarMunicipioClientesBusqueda;
    }

    @Override
    public DTOMunicipio obtenerMunicipioClienteProducto(int id_producto) {
        DTOMunicipio municipioClienteProducto = null;
        Connection con = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_productos.id_producto = '" + id_producto + "';";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                municipioClienteProducto = new DTOMunicipio();
                municipioClienteProducto.setId_municipio(rs.getInt("id_municipio"));
                municipioClienteProducto.setId_departamento(rs.getInt("id_departamento"));
                municipioClienteProducto.setMunicipio(rs.getString("municipio"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método obtener municipio cliente producto." + e);
        }
        return municipioClienteProducto;
    }

    @Override
    public DTOMunicipio obtenerMunicipioUsuario(String documento_identidad) {
        DTOMunicipio municipioUsuario = null;
        Connection con = null;
        String sql = "SELECT tbl_usuarios.*,tbl_municipios.* FROM tbl_usuarios INNER JOIN tbl_municipios ON tbl_usuarios.id_municipio = tbl_municipios.id_municipio WHERE tbl_usuarios.documento_identidad = '" + documento_identidad + "';";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                municipioUsuario = new DTOMunicipio();
                municipioUsuario.setId_municipio(rs.getInt("id_municipio"));
                municipioUsuario.setId_departamento(rs.getInt("id_departamento"));
                municipioUsuario.setMunicipio(rs.getString("municipio"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método obtener municipio usuario." + e);
        }
        return municipioUsuario;
    }
}
