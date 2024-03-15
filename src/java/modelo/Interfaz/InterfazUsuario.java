package modelo.Interfaz;

import java.util.List;
import modelo.DTO.DTOUsuario;

public interface InterfazUsuario {
    
    public boolean crearUsuario(DTOUsuario usuario);
    public boolean editarUsuario(DTOUsuario usuario);
    public boolean eliminarUsuario(DTOUsuario usuario);
    public boolean editarClave(DTOUsuario usuario);
    public boolean editarPortada(DTOUsuario usuario);
    public boolean editarFoto(DTOUsuario usuario);
    public DTOUsuario obtenerUsuario(String documento_identidad);
    public boolean validarUsuario(DTOUsuario usuario);
    public boolean validarCorreoUsuario(String destinatario);
    public DTOUsuario obtenerUsuarioCorreo(String destinatario);
    public List<DTOUsuario> listarClientesGanaderia();
    public List<DTOUsuario> listarClientesMascotas();
    public List<DTOUsuario> listarClientesAlimentos();
    public List<DTOUsuario> listarClientesInsumos();
    public List<DTOUsuario> listarClientesBusqueda(String busqueda);
    public DTOUsuario obtenerClienteProducto(int id_producto);
    public DTOUsuario obtenerClienteVenta(int id_venta);
    
}
