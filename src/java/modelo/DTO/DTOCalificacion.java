
package modelo.DTO;

public class DTOCalificacion {
    
    private int id_calificacion;
    private int calificacion;
    private String observaciones;
    private String fecha;

    public DTOCalificacion() {
    }

    public DTOCalificacion(int id_calificacion, int calificacion, String observaciones, String fecha) {
        this.id_calificacion = id_calificacion;
        this.calificacion = calificacion;
        this.observaciones = observaciones;
        this.fecha = fecha;
    }

    public int getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(int id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha_hora) {
        this.fecha = fecha_hora;
    }

    @Override
    public String toString() {
        return "DTOCalificacion{" + "id_calificacion=" + id_calificacion + ", calificacion=" + calificacion + ", observaciones=" + observaciones + ", fecha=" + fecha+ '}';
    }
    
}
