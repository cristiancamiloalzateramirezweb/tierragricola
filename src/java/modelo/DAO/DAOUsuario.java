package modelo.DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.DTO.DTOUsuario;
import modelo.Interfaz.InterfazUsuario;

public class DAOUsuario implements InterfazUsuario {

    @Override
    public boolean crearUsuario(DTOUsuario usuario) {
        boolean crearUsuario = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO tbl_usuarios(documento_identidad,tipo_documento,nombres,apellidos,correo,clave,celular,id_departamento,id_municipio,direccion,fecha_miembro) VALUES ('" + usuario.getDocumento_identidad() + "','" + usuario.getTipo_documento() + "','" + usuario.getNombre() + "','" + usuario.getApellido() + "','" + usuario.getCorreo() + "','" + usuario.getClave() + "','" + usuario.getCelular() + "','" + usuario.getId_departamento() + "','" + usuario.getId_municipio() + "','" + usuario.getDireccion() + "',CURDATE())";
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            crearUsuario = true;
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método crear usuario." + e);
        }
        return crearUsuario;
    }

    @Override
    public boolean editarUsuario(DTOUsuario usuario) {
        boolean editarUsuario = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE tbl_usuarios SET tipo_documento='" + usuario.getTipo_documento() + "',nombres='" + usuario.getNombre() + "',apellidos='" + usuario.getApellido() + "',correo='" + usuario.getCorreo() + "',celular='" + usuario.getCelular() + "',id_departamento='" + usuario.getId_departamento() + "',id_municipio='" + usuario.getId_municipio() + "',direccion='" + usuario.getDireccion() + "' WHERE documento_identidad = '" + usuario.getDocumento_identidad() + "'";
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            editarUsuario = true;
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método editar usuario." + e);
        }
        return editarUsuario;
    }

    @Override
    public boolean eliminarUsuario(DTOUsuario usuario) {
        boolean eliminarUsuario = false;
        Statement stm = null;
        Connection con = null;
        String sql = "DELETE * FROM tbl_usuarios WHERE documento_identidad = '" + usuario.getDocumento_identidad() + "'";
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            eliminarUsuario = true;
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método eliminar usuario." + e);
        }
        return eliminarUsuario;
    }

    @Override
    public boolean editarClave(DTOUsuario usuario) {
        boolean editarClave = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE tbl_usuarios SET clave='" + usuario.getClave() + "' WHERE documento_identidad = '" + usuario.getDocumento_identidad() + "'";
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            editarClave = true;
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método editar clave." + e);
        }
        return editarClave;
    }

    @Override
    public boolean editarPortada(DTOUsuario usuario) {
        boolean editarPortada = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE tbl_usuarios SET portada='" + usuario.getPortada() + "' WHERE documento_identidad = '" + usuario.getDocumento_identidad() + "'";
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            editarPortada = true;
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método editar portada." + e);
        }
        return editarPortada;
    }

    @Override
    public boolean editarFoto(DTOUsuario usuario) {
        boolean editarFoto = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE tbl_usuarios SET foto='" + usuario.getFoto() + "' WHERE documento_identidad = '" + usuario.getDocumento_identidad() + "'";
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            editarFoto = true;
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método editar foto." + e);
        }
        return editarFoto;
    }

    @Override
    public boolean validarUsuario(DTOUsuario usuario) {
        boolean ok = false;
        int respuesta = 0;
        Connection con = null;
        String sql = "SELECT * FROM tbl_usuarios WHERE documento_identidad = '" + usuario.getDocumento_identidad() + "' AND clave = '" + usuario.getClave() + "'";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                respuesta = 1;
                if (respuesta == 1) {
                    ok = true;
                }
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método validar usuario." + e);
        }
        return ok;
    }

    @Override
    public DTOUsuario obtenerUsuario(String documento_identidad) {
        DTOUsuario usuario = null;
        Connection con = null;
        String sql = "SELECT * FROM tbl_usuarios WHERE documento_identidad = '" + documento_identidad + "'";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                usuario = new DTOUsuario();
                usuario.setDocumento_identidad(rs.getString("documento_identidad"));
                usuario.setTipo_documento(rs.getString("tipo_documento"));
                usuario.setNombre(rs.getString("nombres"));
                usuario.setApellido(rs.getString("apellidos"));
                usuario.setPortada(rs.getString("portada"));
                usuario.setFoto(rs.getString("foto"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setClave(rs.getString("clave"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setId_departamento(rs.getInt("id_departamento"));
                usuario.setId_municipio(rs.getInt("id_municipio"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setFecha_miembro(rs.getString("fecha_miembro"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método obtener usuario." + e);
        }
        return usuario;
    }

    @Override
    public boolean validarCorreoUsuario(String destinatario) {
        int respuesta = 0;
        Connection con = null;
        String sql = "SELECT correo FROM tbl_usuarios WHERE correo = '" + destinatario + "';";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                respuesta = 1;
                if (respuesta == 1) {
                    return true;
                }
                con.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método validar correo." + e);
        }
        return false;
    }

    @Override
    public DTOUsuario obtenerUsuarioCorreo(String destinatario) {
        DTOUsuario usuario = null;
        Connection con = null;
        String sql = "SELECT * FROM tbl_usuarios WHERE correo = '" + destinatario + "';";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                usuario = new DTOUsuario();
                usuario.setDocumento_identidad(rs.getString("documento_identidad"));
                usuario.setTipo_documento(rs.getString("tipo_documento"));
                usuario.setNombre(rs.getString("nombres"));
                usuario.setApellido(rs.getString("apellidos"));
                usuario.setPortada(rs.getString("portada"));
                usuario.setFoto(rs.getString("foto"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setClave(rs.getString("clave"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setId_departamento(rs.getInt("id_departamento"));
                usuario.setId_municipio(rs.getInt("id_municipio"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setFecha_miembro(rs.getString("fecha_miembro"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método obtener usuario." + e);
        }
        return usuario;
    }

    @Override
    public List<DTOUsuario> listarClientesGanaderia() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Ganadería' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOUsuario> listarClientesGanaderia = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOUsuario dtoUsuario = new DTOUsuario();
                dtoUsuario.setDocumento_identidad(rs.getString("documento_identidad"));
                dtoUsuario.setTipo_documento(rs.getString("tipo_documento"));
                dtoUsuario.setNombre(rs.getString("nombre"));
                dtoUsuario.setApellido(rs.getString("apellido"));
                dtoUsuario.setPortada(rs.getString("portada"));
                dtoUsuario.setFoto(rs.getString("foto"));
                dtoUsuario.setCorreo(rs.getString("correo"));
                dtoUsuario.setClave(rs.getString("clave"));
                dtoUsuario.setCelular(rs.getString("celular"));
                dtoUsuario.setId_departamento(rs.getInt("id_departamento"));
                dtoUsuario.setId_municipio(rs.getInt("id_municipio"));
                dtoUsuario.setDireccion(rs.getString("direccion"));
                dtoUsuario.setFecha_miembro(rs.getString("fecha_miembro"));
                listarClientesGanaderia.add(dtoUsuario);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método listar clientes ganaderia." + e);
        }
        return listarClientesGanaderia;
    }

    @Override
    public List<DTOUsuario> listarClientesMascotas() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Mascotas' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOUsuario> listarClientesMascotas = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOUsuario dtoUsuario = new DTOUsuario();
                dtoUsuario.setDocumento_identidad(rs.getString("documento_identidad"));
                dtoUsuario.setTipo_documento(rs.getString("tipo_documento"));
                dtoUsuario.setNombre(rs.getString("nombre"));
                dtoUsuario.setApellido(rs.getString("apellido"));
                dtoUsuario.setPortada(rs.getString("portada"));
                dtoUsuario.setFoto(rs.getString("foto"));
                dtoUsuario.setCorreo(rs.getString("correo"));
                dtoUsuario.setClave(rs.getString("clave"));
                dtoUsuario.setCelular(rs.getString("celular"));
                dtoUsuario.setId_departamento(rs.getInt("id_departamento"));
                dtoUsuario.setId_municipio(rs.getInt("id_municipio"));
                dtoUsuario.setDireccion(rs.getString("direccion"));
                dtoUsuario.setFecha_miembro(rs.getString("fecha_miembro"));
                listarClientesMascotas.add(dtoUsuario);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método listar clientes mascotas." + e);
        }
        return listarClientesMascotas;
    }

    @Override
    public List<DTOUsuario> listarClientesAlimentos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Alimentos' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOUsuario> listarClientesAlimentos = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOUsuario dtoUsuario = new DTOUsuario();
                dtoUsuario.setDocumento_identidad(rs.getString("documento_identidad"));
                dtoUsuario.setTipo_documento(rs.getString("tipo_documento"));
                dtoUsuario.setNombre(rs.getString("nombre"));
                dtoUsuario.setApellido(rs.getString("apellido"));
                dtoUsuario.setPortada(rs.getString("portada"));
                dtoUsuario.setFoto(rs.getString("foto"));
                dtoUsuario.setCorreo(rs.getString("correo"));
                dtoUsuario.setClave(rs.getString("clave"));
                dtoUsuario.setCelular(rs.getString("celular"));
                dtoUsuario.setId_departamento(rs.getInt("id_departamento"));
                dtoUsuario.setId_municipio(rs.getInt("id_municipio"));
                dtoUsuario.setDireccion(rs.getString("direccion"));
                dtoUsuario.setFecha_miembro(rs.getString("fecha_miembro"));
                listarClientesAlimentos.add(dtoUsuario);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método listar clientes alimentos." + e);
        }
        return listarClientesAlimentos;
    }

    @Override
    public List<DTOUsuario> listarClientesInsumos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Insumos' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOUsuario> listarClientesInsumos = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOUsuario dtoUsuario = new DTOUsuario();
                dtoUsuario.setDocumento_identidad(rs.getString("documento_identidad"));
                dtoUsuario.setTipo_documento(rs.getString("tipo_documento"));
                dtoUsuario.setNombre(rs.getString("nombre"));
                dtoUsuario.setApellido(rs.getString("apellido"));
                dtoUsuario.setPortada(rs.getString("portada"));
                dtoUsuario.setFoto(rs.getString("foto"));
                dtoUsuario.setCorreo(rs.getString("correo"));
                dtoUsuario.setClave(rs.getString("clave"));
                dtoUsuario.setCelular(rs.getString("celular"));
                dtoUsuario.setId_departamento(rs.getInt("id_departamento"));
                dtoUsuario.setId_municipio(rs.getInt("id_municipio"));
                dtoUsuario.setDireccion(rs.getString("direccion"));
                dtoUsuario.setFecha_miembro(rs.getString("fecha_miembro"));
                listarClientesInsumos.add(dtoUsuario);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método listar clientes insumos." + e);
        }
        return listarClientesInsumos;
    }

    @Override
    public List<DTOUsuario> listarClientesBusqueda(String busqueda) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_productos.titulo_producto LIKE '%" + busqueda + "%' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOUsuario> listarClientesBusqueda = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOUsuario dtoUsuario = new DTOUsuario();
                dtoUsuario.setDocumento_identidad(rs.getString("documento_identidad"));
                dtoUsuario.setTipo_documento(rs.getString("tipo_documento"));
                dtoUsuario.setNombre(rs.getString("nombre"));
                dtoUsuario.setApellido(rs.getString("apellido"));
                dtoUsuario.setPortada(rs.getString("portada"));
                dtoUsuario.setFoto(rs.getString("foto"));
                dtoUsuario.setCorreo(rs.getString("correo"));
                dtoUsuario.setClave(rs.getString("clave"));
                dtoUsuario.setCelular(rs.getString("celular"));
                dtoUsuario.setId_departamento(rs.getInt("id_departamento"));
                dtoUsuario.setId_municipio(rs.getInt("id_municipio"));
                dtoUsuario.setDireccion(rs.getString("direccion"));
                dtoUsuario.setFecha_miembro(rs.getString("fecha_miembro"));
                listarClientesBusqueda.add(dtoUsuario);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método listar busqueda clientes." + e);
        }
        return listarClientesBusqueda;
    }

    @Override
    public DTOUsuario obtenerClienteProducto(int id_producto) {
        DTOUsuario usuarioProducto = null;
        Connection con = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_productos.id_producto = '" + id_producto + "';";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                usuarioProducto = new DTOUsuario();
                usuarioProducto.setDocumento_identidad(rs.getString("documento_identidad"));
                usuarioProducto.setTipo_documento(rs.getString("tipo_documento"));
                usuarioProducto.setNombre(rs.getString("nombres"));
                usuarioProducto.setApellido(rs.getString("apellidos"));
                usuarioProducto.setPortada(rs.getString("portada"));
                usuarioProducto.setFoto(rs.getString("foto"));
                usuarioProducto.setCorreo(rs.getString("correo"));
                usuarioProducto.setClave(rs.getString("clave"));
                usuarioProducto.setCelular(rs.getString("celular"));
                usuarioProducto.setId_departamento(rs.getInt("id_departamento"));
                usuarioProducto.setId_municipio(rs.getInt("id_municipio"));
                usuarioProducto.setDireccion(rs.getString("direccion"));
                usuarioProducto.setFecha_miembro(rs.getString("fecha_miembro"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método obtener usuario." + e);
        }
        return usuarioProducto;
    }

    @Override
    public DTOUsuario obtenerClienteVenta(int id_venta) {
        DTOUsuario usuarioProducto = null;
        Connection con = null;
        String sql = "SELECT tbl_usuarios.*,tbl_productos.*,tbl_cliente_producto.*,tbl_ventas.* FROM tbl_ventas INNER JOIN tbl_cliente_producto ON tbl_cliente_producto.numero_folio = tbl_ventas.numero_folio INNER JOIN tbl_productos ON tbl_productos.id_producto = tbl_cliente_producto.id_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_ventas.documento_identidad WHERE tbl_ventas.id_venta = " + id_venta + "";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                usuarioProducto = new DTOUsuario();
                usuarioProducto.setDocumento_identidad(rs.getString("documento_identidad"));
                usuarioProducto.setTipo_documento(rs.getString("tipo_documento"));
                usuarioProducto.setNombre(rs.getString("nombres"));
                usuarioProducto.setApellido(rs.getString("apellidos"));
                usuarioProducto.setPortada(rs.getString("portada"));
                usuarioProducto.setFoto(rs.getString("foto"));
                usuarioProducto.setCorreo(rs.getString("correo"));
                usuarioProducto.setClave(rs.getString("clave"));
                usuarioProducto.setCelular(rs.getString("celular"));
                usuarioProducto.setId_departamento(rs.getInt("id_departamento"));
                usuarioProducto.setId_municipio(rs.getInt("id_municipio"));
                usuarioProducto.setDireccion(rs.getString("direccion"));
                usuarioProducto.setFecha_miembro(rs.getString("fecha_miembro"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOUsuario, método obtener usuario." + e);
        }
        return usuarioProducto;
    }

}
