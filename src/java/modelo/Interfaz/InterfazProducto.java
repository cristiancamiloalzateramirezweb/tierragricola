
package modelo.Interfaz;

import java.util.List;
import modelo.DTO.DTOProducto;

public interface InterfazProducto {
    
    public boolean crearProducto(DTOProducto producto);
    public boolean editarProducto(DTOProducto producto);
    public boolean editarCantidadProducto(int numero_folio);
    public boolean eliminarProducto(DTOProducto producto);
    public DTOProducto obtenerProducto(int id_producto);
    public DTOProducto obtenerItemProducto(int id_producto);
    public List<DTOProducto> listarProductosDestacados();
    public List<DTOProducto> listarProductosGanaderia();
    public List<DTOProducto> listarProductosMascotas();
    public List<DTOProducto> listarProductosAlimentos();
    public List<DTOProducto> listarProductosInsumos();
    public List<DTOProducto> listarProductosBusqueda(String busqueda);
    public List<DTOProducto> listarProductosCliente(String documento_identidad);
    public List<DTOProducto> listarBusquedaProductosCliente(String documento_identidad, String busqueda);
    public List<DTOProducto> listarProductosComprasCliente(String documento_identidad);
    public List<DTOProducto> listarProductoVentasCliente(int numero_folio);
    public int obtenerIdProducto();
    public DTOProducto obtenerProductoVentaFolio(int numero_folio);
    public DTOProducto obtenerProductoVenta(int id_venta);
    
}
