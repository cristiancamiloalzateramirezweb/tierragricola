
package modelo.DTO;

public class DTOSeccion {

    private int id_seccion;
    private String nombre_seccion;

    public DTOSeccion() {
    }

    public DTOSeccion(int id_seccion, String nombre_seccion) {
        this.id_seccion = id_seccion;
        this.nombre_seccion = nombre_seccion;
    }

    public int getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(int id_seccion) {
        this.id_seccion = id_seccion;
    }

    public String getNombre_seccion() {
        return nombre_seccion;
    }

    public void setNombre_seccion(String nombre_seccion) {
        this.nombre_seccion = nombre_seccion;
    }

    @Override
    public String toString() {
        return "DTOSeccion{" + "id_seccion=" + id_seccion + ", nombre_seccion=" + nombre_seccion + '}';
    }
    
}
