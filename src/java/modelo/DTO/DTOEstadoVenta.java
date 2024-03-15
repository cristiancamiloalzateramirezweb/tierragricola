/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DTO;

/**
 *
 * @author camil
 */
public class DTOEstadoVenta {

    private int id_estado_venta;
    private String estado_venta;

    public DTOEstadoVenta() {
    }

    public DTOEstadoVenta(int id_estado_venta, String estado_venta) {
        this.id_estado_venta = id_estado_venta;
        this.estado_venta = estado_venta;
    }

    public int getId_estado_venta() {
        return id_estado_venta;
    }

    public void setId_estado_venta(int id_estado_venta) {
        this.id_estado_venta = id_estado_venta;
    }

    public String getEstado_venta() {
        return estado_venta;
    }

    public void setEstado_venta(String estado_venta) {
        this.estado_venta = estado_venta;
    }

    @Override
    public String toString() {
        return "DAOEstadoVenta{" + "id_estado_venta=" + id_estado_venta + ", estado_venta=" + estado_venta + '}';
    }
}
