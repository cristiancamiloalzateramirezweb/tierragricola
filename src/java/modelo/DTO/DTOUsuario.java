
package modelo.DTO;

public class DTOUsuario {

    private String documento_identidad;
    private String tipo_documento;
    private String nombre;
    private String apellido;
    private String portada;
    private String foto;
    private String correo;
    private String clave;
    private String celular;
    private int id_departamento;
    private int id_municipio;
    private String direccion;
    private String fecha_miembro;

    public DTOUsuario() {
    }

    public DTOUsuario(String documento_identidad, String tipo_documento, String nombre, String apellido, String portada, String foto, String correo, String clave, String celular, int id_departamento, int id_municipio, String direccion, String fecha_miembro) {
        this.documento_identidad = documento_identidad;
        this.tipo_documento = tipo_documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.portada = portada;
        this.foto = foto;
        this.correo = correo;
        this.clave = clave;
        this.celular = celular;
        this.id_departamento = id_departamento;
        this.id_municipio = id_municipio;
        this.direccion = direccion;
        this.fecha_miembro = fecha_miembro;
    }

    public String getDocumento_identidad() {
        return documento_identidad;
    }

    public void setDocumento_identidad(String documento_identidad) {
        this.documento_identidad = documento_identidad;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha_miembro() {
        return fecha_miembro;
    }

    public void setFecha_miembro(String fecha_miembro) {
        this.fecha_miembro = fecha_miembro;
    }

    @Override
    public String toString() {
        return "DTOUsuario{" + "documento_identidad=" + documento_identidad + ", tipo_documento=" + tipo_documento + ", nombre=" + nombre + ", apellido=" + apellido + ", portada=" + portada + ", foto=" + foto + ", correo=" + correo + ", clave=" + clave + ", celular=" + celular + ", id_departamento=" + id_departamento + ", id_municipio=" + id_municipio + ", direccion=" + direccion + ", fecha_miembro=" + fecha_miembro + '}';
    }

}
