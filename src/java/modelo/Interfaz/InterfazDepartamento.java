
package modelo.Interfaz;

import java.util.List;
import modelo.DTO.DTODepartamento;

public interface InterfazDepartamento {
    
    public List<DTODepartamento> listarDepartamentoClientesDestacados();
    public List<DTODepartamento> listarDepartamentoClientesGanaderia();
    public List<DTODepartamento> listarDepartamentoClientesMascotas();
    public List<DTODepartamento> listarDepartamentoClientesAlimentos();
    public List<DTODepartamento> listarDepartamentoClientesInsumos();
    public List<DTODepartamento> listarDepartamentoClientesBusqueda(String busqueda);
    public DTODepartamento obtenerDepartamentoClienteProducto(int id_producto);
    public DTODepartamento obtenerDepartamentoUsuario(String documento_identidad);
    public List<DTODepartamento> listarDepartamentos();
    
}
