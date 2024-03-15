/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Interfaz;

import java.util.List;
import modelo.DTO.DTOVenta;

/**
 *
 * @author camil
 */
public interface InterfazVenta {
    
    public List<DTOVenta> listarVentasProductoCliente(int numero_folio);
    public List<DTOVenta> listarComprasProductoCliente(String documento_identidad);
    public boolean crearVenta(DTOVenta venta);
    public boolean editarCompra(DTOVenta venta);
    public boolean editarNegocio(DTOVenta venta);
    public DTOVenta obtenerVenta(int id_venta);
    public boolean editarVenta(DTOVenta venta);
    
}
