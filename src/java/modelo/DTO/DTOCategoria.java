
package modelo.DTO;

public class DTOCategoria {

    private int id_categoria;
    private int id_seccion;
    private String nombre_categoria;

    public DTOCategoria() {
    }

    public DTOCategoria(int id_categoria, int id_seccion, String nombre_categoria) {
        this.id_categoria = id_categoria;
        this.id_seccion = id_seccion;
        this.nombre_categoria = nombre_categoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(int id_seccion) {
        this.id_seccion = id_seccion;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    @Override
    public String toString() {
        return "DTOCategoria{" + "id_categoria=" + id_categoria + ", id_seccion=" + id_seccion + ", nombre_categoria=" + nombre_categoria + '}';
    }

}
