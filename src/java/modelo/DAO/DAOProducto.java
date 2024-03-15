package modelo.DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.DTO.DTOProducto;
import modelo.Interfaz.InterfazProducto;

public class DAOProducto implements InterfazProducto {

    @Override
    public int obtenerIdProducto() {
        int idProducto = 0;
        Connection con = null;
        String sql = "SELECT MAX(id_producto + 1) FROM tbl_productos";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                idProducto = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error: clase DAOProducto, método obtenerIdProducto." + e);
        }
        return idProducto;
    }

    @Override
    public boolean crearProducto(DTOProducto producto) {
        boolean crearProducto = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO tbl_productos(id_producto,id_seccion,id_categoria,titulo_producto,catalogo,precio,cantidad,descripcion_producto,fecha_publicacion) VALUES (NULL,'" + producto.getId_seccion() + "','" + producto.getId_categoria() + "','" + producto.getTitulo_anuncio() + "','" + producto.getCatalogo() + "','" + producto.getPrecio() + "','" + producto.getCantidad() + "','" + producto.getDescripcion_producto() + "',CURDATE())";
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            crearProducto = true;
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método crear producto." + e);
        }
        return crearProducto;
    }

    @Override
    public boolean editarProducto(DTOProducto producto) {
        boolean editarProducto = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE tbl_productos SET titulo_producto = '" + producto.getTitulo_anuncio() + "',catalogo='" + producto.getCatalogo() + "',precio='" + producto.getPrecio() + "',cantidad='" + producto.getCantidad() + "',descripcion_producto='" + producto.getDescripcion_producto() + "' WHERE id_producto = '" + producto.getId_producto() + "'";
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            editarProducto = true;
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método editar producto." + e);
        }
        return editarProducto;
    }

    @Override
    public boolean editarCantidadProducto(int numero_folio) {
        boolean editarCantidadProducto = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE tbl_productos INNER JOIN tbl_cliente_producto ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_ventas ON tbl_ventas.numero_folio = tbl_cliente_producto.numero_folio SET tbl_productos.cantidad = tbl_productos.cantidad - tbl_ventas.cantidad_venta WHERE tbl_cliente_producto.numero_folio = " + numero_folio + "";
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            editarCantidadProducto = true;
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método editar cantidad producto." + e);
        }
        return editarCantidadProducto;
    }

    @Override
    public boolean eliminarProducto(DTOProducto producto) {
        boolean eliminarProducto = false;
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE tbl_productos SET estado_producto='" + producto.getEstado_producto() + "' WHERE id_producto = '" + producto.getId_producto() + "'";
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            eliminarProducto = true;
            stm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método eliminar producto." + e);
        }
        return eliminarProducto;
    }

    @Override
    public DTOProducto obtenerProducto(int id_producto) {
        DTOProducto producto = null;
        Connection con = null;
        String sql = "SELECT * FROM tbl_productos WHERE id_producto = '" + id_producto + "';";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                producto = new DTOProducto();
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setId_seccion(rs.getInt("id_seccion"));
                producto.setId_categoria(rs.getInt("id_categoria"));
                producto.setTitulo_anuncio(rs.getString("titulo_producto"));
                producto.setCatalogo(rs.getString("catalogo"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setDescripcion_producto(rs.getString("descripcion_producto"));
                producto.setFecha_publicacion(rs.getString("fecha_publicacion"));
                producto.setEstado_producto(rs.getString("estado_producto"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método obtener producto." + e);
        }
        return producto;
    }

    public List<DTOProducto> listarProductosDestacados() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.*,tbl_ventas.*, COUNT(tbl_ventas.numero_folio) FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_ventas ON tbl_ventas.numero_folio = tbl_cliente_producto.numero_folio WHERE tbl_productos.cantidad >=1 GROUP BY tbl_ventas.numero_folio ORDER BY COUNT(tbl_ventas.numero_folio) AND tbl_productos.fecha_publicacion DESC LIMIT 0,30;";
        List<DTOProducto> listarProductosDestacados = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOProducto dtoProducto = new DTOProducto();
                dtoProducto.setId_producto(rs.getInt("id_producto"));
                dtoProducto.setId_seccion(rs.getInt("id_seccion"));
                dtoProducto.setId_categoria(rs.getInt("id_categoria"));
                dtoProducto.setTitulo_anuncio(rs.getString("titulo_producto"));
                dtoProducto.setCatalogo(rs.getString("catalogo"));
                dtoProducto.setPrecio(rs.getInt("precio"));
                dtoProducto.setCantidad(rs.getInt("cantidad"));
                dtoProducto.setDescripcion_producto(rs.getString("descripcion_producto"));
                dtoProducto.setFecha_publicacion(rs.getString("fecha_publicacion"));
                dtoProducto.setEstado_producto(rs.getString("estado_producto"));
                listarProductosDestacados.add(dtoProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar productos ganaderia." + e);
        }
        return listarProductosDestacados;
    }

    @Override
    public List<DTOProducto> listarProductosGanaderia() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Ganadería' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOProducto> listarProductosGanaderia = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOProducto dtoProducto = new DTOProducto();
                dtoProducto.setId_producto(rs.getInt("id_producto"));
                dtoProducto.setId_seccion(rs.getInt("id_seccion"));
                dtoProducto.setId_categoria(rs.getInt("id_categoria"));
                dtoProducto.setTitulo_anuncio(rs.getString("titulo_producto"));
                dtoProducto.setCatalogo(rs.getString("catalogo"));
                dtoProducto.setPrecio(rs.getInt("precio"));
                dtoProducto.setCantidad(rs.getInt("cantidad"));
                dtoProducto.setDescripcion_producto(rs.getString("descripcion_producto"));
                dtoProducto.setFecha_publicacion(rs.getString("fecha_publicacion"));
                dtoProducto.setEstado_producto(rs.getString("estado_producto"));
                listarProductosGanaderia.add(dtoProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar productos ganaderia." + e);
        }
        return listarProductosGanaderia;
    }

    @Override
    public List<DTOProducto> listarProductosMascotas() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Mascotas' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOProducto> listarProductosMascotas = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOProducto dtoProducto = new DTOProducto();
                dtoProducto.setId_producto(rs.getInt("id_producto"));
                dtoProducto.setId_seccion(rs.getInt("id_seccion"));
                dtoProducto.setId_categoria(rs.getInt("id_categoria"));
                dtoProducto.setTitulo_anuncio(rs.getString("titulo_producto"));
                dtoProducto.setCatalogo(rs.getString("catalogo"));
                dtoProducto.setPrecio(rs.getInt("precio"));
                dtoProducto.setCantidad(rs.getInt("cantidad"));
                dtoProducto.setDescripcion_producto(rs.getString("descripcion_producto"));
                dtoProducto.setFecha_publicacion(rs.getString("fecha_publicacion"));
                dtoProducto.setEstado_producto(rs.getString("estado_producto"));
                listarProductosMascotas.add(dtoProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar productos mascotas." + e);
        }
        return listarProductosMascotas;
    }

    @Override
    public List<DTOProducto> listarProductosAlimentos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Alimentos' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOProducto> listarProductosAlimentos = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOProducto dtoProducto = new DTOProducto();
                dtoProducto.setId_producto(rs.getInt("id_producto"));
                dtoProducto.setId_seccion(rs.getInt("id_seccion"));
                dtoProducto.setId_categoria(rs.getInt("id_categoria"));
                dtoProducto.setTitulo_anuncio(rs.getString("titulo_producto"));
                dtoProducto.setCatalogo(rs.getString("catalogo"));
                dtoProducto.setPrecio(rs.getInt("precio"));
                dtoProducto.setCantidad(rs.getInt("cantidad"));
                dtoProducto.setDescripcion_producto(rs.getString("descripcion_producto"));
                dtoProducto.setFecha_publicacion(rs.getString("fecha_publicacion"));
                dtoProducto.setEstado_producto(rs.getString("estado_producto"));
                listarProductosAlimentos.add(dtoProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar productos alimentos." + e);
        }
        return listarProductosAlimentos;
    }

    @Override
    public List<DTOProducto> listarProductosInsumos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_secciones.nombre_seccion = 'Insumos' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOProducto> listarProductosInsumos = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOProducto dtoProducto = new DTOProducto();
                dtoProducto.setId_producto(rs.getInt("id_producto"));
                dtoProducto.setId_seccion(rs.getInt("id_seccion"));
                dtoProducto.setId_categoria(rs.getInt("id_categoria"));
                dtoProducto.setTitulo_anuncio(rs.getString("titulo_producto"));
                dtoProducto.setCatalogo(rs.getString("catalogo"));
                dtoProducto.setPrecio(rs.getInt("precio"));
                dtoProducto.setCantidad(rs.getInt("cantidad"));
                dtoProducto.setDescripcion_producto(rs.getString("descripcion_producto"));
                dtoProducto.setFecha_publicacion(rs.getString("fecha_publicacion"));
                dtoProducto.setEstado_producto(rs.getString("estado_producto"));
                listarProductosInsumos.add(dtoProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar productos insumos." + e);
        }
        return listarProductosInsumos;
    }

    @Override
    public List<DTOProducto> listarProductosBusqueda(String busqueda) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_productos.titulo_producto LIKE '%" + busqueda + "%' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOProducto> listarProductosBusqueda = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOProducto dtoProducto = new DTOProducto();
                dtoProducto.setId_producto(rs.getInt("id_producto"));
                dtoProducto.setId_seccion(rs.getInt("id_seccion"));
                dtoProducto.setId_categoria(rs.getInt("id_categoria"));
                dtoProducto.setTitulo_anuncio(rs.getString("titulo_producto"));
                dtoProducto.setCatalogo(rs.getString("catalogo"));
                dtoProducto.setPrecio(rs.getInt("precio"));
                dtoProducto.setCantidad(rs.getInt("cantidad"));
                dtoProducto.setDescripcion_producto(rs.getString("descripcion_producto"));
                dtoProducto.setFecha_publicacion(rs.getString("fecha_publicacion"));
                dtoProducto.setEstado_producto(rs.getString("estado_producto"));
                listarProductosBusqueda.add(dtoProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar busqueda productos." + e);
        }
        return listarProductosBusqueda;
    }

    @Override
    public DTOProducto obtenerItemProducto(int id_producto) {
        DTOProducto itemProducto = null;
        Connection con = null;
        String sql = "SELECT tbl_productos.*,tbl_secciones.*,tbl_categorias.*,tbl_cliente_producto.*,tbl_usuarios.*,tbl_departamentos.*,tbl_municipios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_departamentos ON tbl_departamentos.id_departamento = tbl_usuarios.id_departamento INNER JOIN tbl_municipios ON tbl_municipios.id_municipio = tbl_usuarios.id_municipio INNER JOIN tbl_productos ON tbl_cliente_producto.id_producto = tbl_productos.id_producto INNER JOIN tbl_secciones ON tbl_secciones.id_seccion = tbl_productos.id_seccion INNER JOIN tbl_categorias ON tbl_categorias.id_categoria = tbl_productos.id_categoria WHERE tbl_productos.id_producto = '" + id_producto + "';";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                itemProducto = new DTOProducto();
                itemProducto.setId_producto(rs.getInt("id_producto"));
                itemProducto.setId_seccion(rs.getInt("id_seccion"));
                itemProducto.setId_categoria(rs.getInt("id_categoria"));
                itemProducto.setTitulo_anuncio(rs.getString("titulo_producto"));
                itemProducto.setCatalogo(rs.getString("catalogo"));
                itemProducto.setPrecio(rs.getInt("precio"));
                itemProducto.setCantidad(rs.getInt("cantidad"));
                itemProducto.setDescripcion_producto(rs.getString("descripcion_producto"));
                itemProducto.setFecha_publicacion(rs.getString("fecha_publicacion"));
                itemProducto.setEstado_producto(rs.getString("estado_producto"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método obtener item producto." + e);
        }
        return itemProducto;
    }

    @Override
    public List<DTOProducto> listarProductosCliente(String documento_identidad) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_cliente_producto.*,tbl_usuarios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_productos ON tbl_productos.id_producto = tbl_cliente_producto.id_producto WHERE tbl_cliente_producto.documento_identidad = '" + documento_identidad + "' AND tbl_productos.estado_producto = 'Activo' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOProducto> listarProductosCliente = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOProducto dtoProducto = new DTOProducto();
                dtoProducto.setId_producto(rs.getInt("id_producto"));
                dtoProducto.setId_seccion(rs.getInt("id_seccion"));
                dtoProducto.setId_categoria(rs.getInt("id_categoria"));
                dtoProducto.setTitulo_anuncio(rs.getString("titulo_producto"));
                dtoProducto.setCatalogo(rs.getString("catalogo"));
                dtoProducto.setPrecio(rs.getInt("precio"));
                dtoProducto.setCantidad(rs.getInt("cantidad"));
                dtoProducto.setDescripcion_producto(rs.getString("descripcion_producto"));
                dtoProducto.setFecha_publicacion(rs.getString("fecha_publicacion"));
                dtoProducto.setEstado_producto(rs.getString("estado_producto"));
                listarProductosCliente.add(dtoProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar productos cliente." + e);
        }
        return listarProductosCliente;
    }

    @Override
    public List<DTOProducto> listarBusquedaProductosCliente(String documento_identidad, String busqueda) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_cliente_producto.*,tbl_usuarios.* FROM tbl_cliente_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_cliente_producto.documento_identidad INNER JOIN tbl_productos ON tbl_productos.id_producto = tbl_cliente_producto.id_producto WHERE tbl_usuarios.documento_identidad = '" + documento_identidad + "' AND tbl_productos.titulo_producto LIKE '%" + busqueda + "%' ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOProducto> listarBusquedaProductosCliente = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOProducto dtoProducto = new DTOProducto();
                dtoProducto.setId_producto(rs.getInt("id_producto"));
                dtoProducto.setId_seccion(rs.getInt("id_seccion"));
                dtoProducto.setId_categoria(rs.getInt("id_categoria"));
                dtoProducto.setTitulo_anuncio(rs.getString("titulo_producto"));
                dtoProducto.setCatalogo(rs.getString("catalogo"));
                dtoProducto.setPrecio(rs.getInt("precio"));
                dtoProducto.setCantidad(rs.getInt("cantidad"));
                dtoProducto.setDescripcion_producto(rs.getString("descripcion_producto"));
                dtoProducto.setFecha_publicacion(rs.getString("fecha_publicacion"));
                dtoProducto.setEstado_producto(rs.getString("estado_producto"));
                listarBusquedaProductosCliente.add(dtoProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar busqueda productos cliente." + e);
        }
        return listarBusquedaProductosCliente;
    }

    @Override
    public List<DTOProducto> listarProductosComprasCliente(String documento_identidad) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_usuarios.*,tbl_productos.*,tbl_cliente_producto.*,tbl_ventas.*,tbl_estado_ventas.* FROM tbl_ventas INNER JOIN tbl_cliente_producto ON tbl_cliente_producto.numero_folio = tbl_ventas.numero_folio INNER JOIN tbl_productos ON tbl_productos.id_producto = tbl_cliente_producto.id_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_ventas.documento_identidad INNER JOIN tbl_estado_ventas ON tbl_estado_ventas.id_estado_venta = tbl_ventas.id_estado_compra WHERE tbl_ventas.documento_identidad = " + documento_identidad + " ORDER BY tbl_productos.fecha_publicacion DESC;";
        List<DTOProducto> listarProductosComprasCliente = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOProducto dtoProducto = new DTOProducto();
                dtoProducto.setId_producto(rs.getInt("id_producto"));
                dtoProducto.setId_seccion(rs.getInt("id_seccion"));
                dtoProducto.setId_categoria(rs.getInt("id_categoria"));
                dtoProducto.setTitulo_anuncio(rs.getString("titulo_producto"));
                dtoProducto.setCatalogo(rs.getString("catalogo"));
                dtoProducto.setPrecio(rs.getInt("precio"));
                dtoProducto.setCantidad(rs.getInt("cantidad"));
                dtoProducto.setDescripcion_producto(rs.getString("descripcion_producto"));
                dtoProducto.setFecha_publicacion(rs.getString("fecha_publicacion"));
                dtoProducto.setEstado_producto(rs.getString("estado_producto"));
                listarProductosComprasCliente.add(dtoProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar productos compras cliente." + e);
        }
        return listarProductosComprasCliente;
    }

    @Override
    public List<DTOProducto> listarProductoVentasCliente(int numero_folio) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT tbl_productos.*,tbl_cliente_producto.*,tbl_ventas.*,tbl_estado_ventas.* FROM tbl_cliente_producto INNER JOIN tbl_productos ON tbl_productos.id_producto = tbl_cliente_producto.id_producto INNER JOIN tbl_ventas ON tbl_ventas.numero_folio = tbl_cliente_producto.numero_folio INNER JOIN tbl_estado_ventas ON tbl_estado_ventas.id_estado_venta = tbl_ventas.id_estado_negociacion WHERE tbl_cliente_producto.numero_folio = " + numero_folio + " ORDER BY tbl_ventas.id_venta ASC;";
        List<DTOProducto> listarProductosComprasCliente = new ArrayList<>();
        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DTOProducto dtoProducto = new DTOProducto();
                dtoProducto.setId_producto(rs.getInt("id_producto"));
                dtoProducto.setId_seccion(rs.getInt("id_seccion"));
                dtoProducto.setId_categoria(rs.getInt("id_categoria"));
                dtoProducto.setTitulo_anuncio(rs.getString("titulo_producto"));
                dtoProducto.setCatalogo(rs.getString("catalogo"));
                dtoProducto.setPrecio(rs.getInt("precio"));
                dtoProducto.setCantidad(rs.getInt("cantidad"));
                dtoProducto.setDescripcion_producto(rs.getString("descripcion_producto"));
                dtoProducto.setFecha_publicacion(rs.getString("fecha_publicacion"));
                dtoProducto.setEstado_producto(rs.getString("estado_producto"));
                listarProductosComprasCliente.add(dtoProducto);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método listar productos compras cliente." + e);
        }
        return listarProductosComprasCliente;
    }

    @Override
    public DTOProducto obtenerProductoVentaFolio(int numero_folio) {
        DTOProducto itemProducto = null;
        Connection con = null;
        String sql = "SELECT tbl_cliente_producto.*,tbl_productos.* FROM tbl_cliente_producto INNER JOIN tbl_productos ON tbl_productos.id_producto = tbl_cliente_producto.id_producto WHERE tbl_cliente_producto.numero_folio = " + numero_folio + "";

        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                itemProducto = new DTOProducto();
                itemProducto.setId_producto(rs.getInt("id_producto"));
                itemProducto.setId_seccion(rs.getInt("id_seccion"));
                itemProducto.setId_categoria(rs.getInt("id_categoria"));
                itemProducto.setTitulo_anuncio(rs.getString("titulo_producto"));
                itemProducto.setCatalogo(rs.getString("catalogo"));
                itemProducto.setPrecio(rs.getInt("precio"));
                itemProducto.setCantidad(rs.getInt("cantidad"));
                itemProducto.setDescripcion_producto(rs.getString("descripcion_producto"));
                itemProducto.setFecha_publicacion(rs.getString("fecha_publicacion"));
                itemProducto.setEstado_producto(rs.getString("estado_producto"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método obtener item producto." + e);
        }
        return itemProducto;
    }

    @Override
    public DTOProducto obtenerProductoVenta(int id_venta) {
        DTOProducto itemProducto = null;
        Connection con = null;
        String sql = "SELECT tbl_usuarios.*,tbl_productos.*,tbl_cliente_producto.*,tbl_ventas.* FROM tbl_ventas INNER JOIN tbl_cliente_producto ON tbl_cliente_producto.numero_folio = tbl_ventas.numero_folio INNER JOIN tbl_productos ON tbl_productos.id_producto = tbl_cliente_producto.id_producto INNER JOIN tbl_usuarios ON tbl_usuarios.documento_identidad = tbl_ventas.documento_identidad WHERE tbl_ventas.id_venta = " + id_venta + "";
        try {
            con = Conexion.conectar();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                itemProducto = new DTOProducto();
                itemProducto.setId_producto(rs.getInt("id_producto"));
                itemProducto.setId_seccion(rs.getInt("id_seccion"));
                itemProducto.setId_categoria(rs.getInt("id_categoria"));
                itemProducto.setTitulo_anuncio(rs.getString("titulo_producto"));
                itemProducto.setCatalogo(rs.getString("catalogo"));
                itemProducto.setPrecio(rs.getInt("precio"));
                itemProducto.setCantidad(rs.getInt("cantidad"));
                itemProducto.setDescripcion_producto(rs.getString("descripcion_producto"));
                itemProducto.setFecha_publicacion(rs.getString("fecha_publicacion"));
                itemProducto.setEstado_producto(rs.getString("estado_producto"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: clase DAOProducto, método obtener item producto." + e);
        }
        return itemProducto;
    }

}
