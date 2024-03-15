
package modelo.DTO;

public class DTOProducto {

    private int id_producto;
    private int id_seccion;
    private int id_categoria;
    private String titulo_anuncio;
    private String catalogo;
    private int precio;
    private int cantidad;
    private String descripcion_producto;
    private String fecha_publicacion;
    private String estado_producto;

    public DTOProducto() {
    }

    public DTOProducto(int id_producto, int id_seccion, int id_categoria, String titulo_anuncio, String catalogo, int precio, int cantidad, String descripcion_producto, String fecha_publicacion, String estado_producto) {
        this.id_producto = id_producto;
        this.id_seccion = id_seccion;
        this.id_categoria = id_categoria;
        this.titulo_anuncio = titulo_anuncio;
        this.catalogo = catalogo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion_producto = descripcion_producto;
        this.fecha_publicacion = fecha_publicacion;
        this.estado_producto = estado_producto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(int id_seccion) {
        this.id_seccion = id_seccion;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getTitulo_anuncio() {
        return titulo_anuncio;
    }

    public void setTitulo_anuncio(String titulo_anuncio) {
        this.titulo_anuncio = titulo_anuncio;
    }

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getEstado_producto() {
        return estado_producto;
    }

    public void setEstado_producto(String estado_producto) {
        this.estado_producto = estado_producto;
    }

    @Override
    public String toString() {
        return "DTOProducto{" + "id_producto=" + id_producto + ", id_seccion=" + id_seccion + ", id_categoria=" + id_categoria + ", titulo_anuncio=" + titulo_anuncio + ", catalogo=" + catalogo + ", precio=" + precio + ", cantidad=" + cantidad + ", descripcion_producto=" + descripcion_producto + ", fecha_publicacion=" + fecha_publicacion + ", estado_producto=" + estado_producto + '}';
    }

}
