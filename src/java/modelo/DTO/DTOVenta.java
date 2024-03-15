package modelo.DTO;

public class DTOVenta {

    private int id_venta;
    private String documento_identidad;
    private int numero_folio;
    private int precio_venta;
    private int cantidad_venta;
    private String mensaje;
    private int id_estado_negociacion;
    private int id_estado_compra;
    private int id_estado_venta;

    public DTOVenta() {
    }

    public DTOVenta(int id_venta, String documento_identidad, int numero_folio, int precio_venta, int cantidad_venta, String mensaje, int id_estado_negociacion, int id_estado_compra, int id_estado_venta) {
        this.id_venta = id_venta;
        this.documento_identidad = documento_identidad;
        this.numero_folio = numero_folio;
        this.precio_venta = precio_venta;
        this.cantidad_venta = cantidad_venta;
        this.mensaje = mensaje;
        this.id_estado_negociacion = id_estado_negociacion;
        this.id_estado_compra = id_estado_compra;
        this.id_estado_venta = id_estado_venta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getDocumento_identidad() {
        return documento_identidad;
    }

    public void setDocumento_identidad(String documento_identidad) {
        this.documento_identidad = documento_identidad;
    }

    public int getNumero_folio() {
        return numero_folio;
    }

    public void setNumero_folio(int numero_folio) {
        this.numero_folio = numero_folio;
    }

    public int getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(int precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getCantidad_venta() {
        return cantidad_venta;
    }

    public void setCantidad_venta(int cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getId_estado_negociacion() {
        return id_estado_negociacion;
    }

    public void setId_estado_negociacion(int id_estado_negociacion) {
        this.id_estado_negociacion = id_estado_negociacion;
    }

    public int getId_estado_compra() {
        return id_estado_compra;
    }

    public void setId_estado_compra(int id_estado_compra) {
        this.id_estado_compra = id_estado_compra;
    }

    public int getId_estado_venta() {
        return id_estado_venta;
    }

    public void setId_estado_venta(int id_estado_venta) {
        this.id_estado_venta = id_estado_venta;
    }

    @Override
    public String toString() {
        return "DTOVenta{" + "id_venta=" + id_venta + ", documento_identidad=" + documento_identidad + ", numero_folio=" + numero_folio + ", precio_venta=" + precio_venta + ", cantidad_venta=" + cantidad_venta + ", mensaje=" + mensaje + ", id_estado_negociacion=" + id_estado_negociacion + ", id_estado_compra=" + id_estado_compra + ", id_estado_venta=" + id_estado_venta + '}';
    }

}
