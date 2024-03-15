/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Interfaz;

import java.util.List;
import modelo.DTO.DTOEstadoVenta;

/**
 *
 * @author camil
 */
public interface InterfazEstadoVenta {

    public List<DTOEstadoVenta> listarEstadoComprasCliente(String documento_identidad);
    public List<DTOEstadoVenta> listarEstadoNegociosCliente(int numero_folio);
    
}
