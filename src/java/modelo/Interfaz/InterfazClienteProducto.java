
package modelo.Interfaz;

import java.util.List;
import modelo.DTO.DTOClienteProducto;

public interface InterfazClienteProducto {
    
    public boolean crearClienteProducto(DTOClienteProducto clienteProducto);
    public List<DTOClienteProducto> listarClientesProductosDestacados();
    public List<DTOClienteProducto> listarClientesProductosGanaderia();
    public List<DTOClienteProducto> listarClientesProductosMascotas();
    public List<DTOClienteProducto> listarClientesProductosAlimentos();
    public List<DTOClienteProducto> listarClientesProductosInsumos();
    public List<DTOClienteProducto> listarClientesProductosBusqueda(String busqueda);
    public DTOClienteProducto obtenerClienteProducto(int id_producto);
    public List<DTOClienteProducto> listarClienteProductoUsuario(String documento_identidad);
    public List<DTOClienteProducto> listarBusquedaClienteProductoUsuario(String documento_identidad, String busqueda);
    public List<DTOClienteProducto> listarClienteProductoVentas(int numero_folio);
    
}
