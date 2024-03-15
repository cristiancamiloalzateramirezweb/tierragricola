 
package modelo.Interfaz;

import java.util.List;
import modelo.DTO.DTOMunicipio;

public interface InterfazMunicipio {
    
    public List<DTOMunicipio> obtenerMunicipiosDepartamento(int id_departamento);
    public List<DTOMunicipio> listarMunicipioClientesDestacados();
    public List<DTOMunicipio> listarMunicipioClientesGanaderia();
    public List<DTOMunicipio> listarMunicipioClientesMascotas();
    public List<DTOMunicipio> listarMunicipioClientesAlimentos();
    public List<DTOMunicipio> listarMunicipioClientesInsumos();
    public List<DTOMunicipio> listarMunicipioClientesBusqueda(String busqueda);
    public DTOMunicipio obtenerMunicipioClienteProducto(int id_producto);
    public DTOMunicipio obtenerMunicipioUsuario(String documento_identidad);
    
}
