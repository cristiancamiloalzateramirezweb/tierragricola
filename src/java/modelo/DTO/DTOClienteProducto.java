
package modelo.DTO;

public class DTOClienteProducto {
    
    private int numero_folio;
    private String documento_identidad;
    private int id_producto;

    public DTOClienteProducto() {
    }

    public DTOClienteProducto(int numero_folio, String documento_identidad, int id_producto) {
        this.numero_folio = numero_folio;
        this.documento_identidad = documento_identidad;
        this.id_producto = id_producto;
    }

    public int getNumero_folio() {
        return numero_folio;
    }

    public void setNumero_folio(int numero_folio) {
        this.numero_folio = numero_folio;
    }

    public String getDocumento_identidad() {
        return documento_identidad;
    }

    public void setDocumento_identidad(String documento_identidad) {
        this.documento_identidad = documento_identidad;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    @Override
    public String toString() {
        return "DTOClienteProducto{" + "numero_folio=" + numero_folio + ", documento_identidad=" + documento_identidad + ", id_producto=" + id_producto + '}';
    }
    
}
