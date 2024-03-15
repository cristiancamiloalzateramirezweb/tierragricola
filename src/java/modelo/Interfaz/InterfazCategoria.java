
package modelo.Interfaz;

import java.util.List;
import modelo.DTO.DTOCategoria;

public interface InterfazCategoria {
    
    public List<DTOCategoria> obtenerCategoriasSeccion(int id_seccion);
    public List<DTOCategoria> listarCategoriaProductosGanaderia();
    public List<DTOCategoria> listarCategoriaProductosMascotas();
    public List<DTOCategoria> listarCategoriaProductosAlimentos();
    public List<DTOCategoria> listarCategoriaProductosInsumos();
    public List<DTOCategoria> listarCategoriaProductosBusqueda(String busqueda);
    public DTOCategoria obtenerCategoriaItemProducto(int id_producto);
    public DTOCategoria obtenerCategoriaProducto(int id_producto);
    
}
