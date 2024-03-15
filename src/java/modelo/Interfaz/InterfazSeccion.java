
package modelo.Interfaz;

import modelo.DTO.DTOSeccion;

public interface InterfazSeccion {
    
    public DTOSeccion obtenerSeccionItemProducto(int id_producto);
    public DTOSeccion obtenerSeccionProducto(int id_producto);
    
}
